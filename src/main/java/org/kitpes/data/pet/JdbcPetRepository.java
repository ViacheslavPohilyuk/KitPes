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

    public Pet readOne(long id) {
        Pet pet;
        try {
            pet = jdbc.queryForObject(
                    "SELECT * FROM pets" +
                            " WHERE id = ?",
                    new PetRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            /* Assigning empty Pet instance to {@code pet} valuable
             if program can't find pet with required id in the db */
            pet = new Pet();
        }
        return pet;
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

    public long save(Pet pet) {
        final String insertSQL = "INSERT INTO pets (name, animal, age, sex, description, status, organization)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
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
                    rs.getString("organization"));
        }
    }
}
