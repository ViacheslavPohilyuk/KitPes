package org.kitpes.data.pet;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import org.kitpes.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

    public List<Pet> readbyUserID(long userID) {
        return jdbc.query(
                "SELECT * FROM pets" +
                        " WHERE user_id = ?",
                new PetRowMapper(), userID);
    }

    public Pet readOne(long id) {
        Pet pet;

        pet = jdbc.queryForObject(
                "SELECT * FROM pets" +
                        " WHERE id = ?",
                new PetRowMapper(), id);
        return pet;
    }

    public void deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        jdbc.update("DELETE FROM pets" +
                        " WHERE id = ?",
                params, types);
    }

    public void updateOne(Pet pet) {
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

        jdbc.update(updateStatement, updatedDataAndID);
    }

    public long save(Pet pet) {
        final String insertSQL = "INSERT INTO pets (name, animal, age, sex, description, status, organization, user_id)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, pet.getName());
                    ps.setString(2, pet.getAnimal());
                    ps.setInt(3, pet.getAge());
                    ps.setString(4, pet.getSex());
                    ps.setString(5, pet.getDescription());
                    ps.setString(6, pet.getStatus());
                    ps.setString(7, pet.getOrganization());
                    ps.setLong(8, pet.getUserID());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    private static class PetRowMapper implements RowMapper<Pet>, Serializable {
        PetRowMapper() {
        }

        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Pet(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("animal"),
                    rs.getInt("age"),
                    rs.getString("sex"),
                    rs.getString("description"),
                    rs.getString("status"),
                    rs.getString("organization"),
                    rs.getLong("user_id"));
        }
    }
}
