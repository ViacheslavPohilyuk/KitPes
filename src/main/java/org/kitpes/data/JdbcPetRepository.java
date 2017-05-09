package org.kitpes.data;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.kitpes.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPetRepository implements PetRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcPetRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    public List<Pet> readAll() {
        return jdbc.query(
                "SELECT * FROM pets",
                new PetRowMapper());
    }

    public Pet readOne(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM pets" +
                        " WHERE id = ?",
                new PetRowMapper(), id);
    }

    public int deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        int countDeleted = jdbc.update("DELETE FROM pets" +
                        " WHERE id = ?",
                params, types);

        return countDeleted;
    }

    public int updateOne(Pet pet) {
        String updateStatement = " UPDATE pets"
                + " SET name=?, animal=?, age=?, sex=?, description=?, status=?, organization=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {
                pet.getName(),
                pet.getAnimal(),
                pet.getAge(),
                pet.getSex(),
                pet.getDescription(),
                pet.getStatus(),
                pet.getOrganization(),
                pet.getId()};

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    public void save(Pet pet) {
        jdbc.update(
                "INSERT INTO pets (id, name, animal, age, sex, description, status, organization)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                pet.getId(),
                pet.getName(),
                pet.getAnimal(),
                pet.getAge(),
                pet.getSex(),
                pet.getDescription(),
                pet.getStatus(),
                pet.getOrganization());
    }

    private static class PetRowMapper implements RowMapper<Pet>, Serializable {
        PetRowMapper() {}

        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Pet(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("animal"),
                    rs.getInt("age"),
                    rs.getString("sex"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("organization"));
        }
    }
}
