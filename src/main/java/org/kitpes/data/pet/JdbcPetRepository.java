package org.kitpes.data.pet;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import org.kitpes.entity.Pet;
import org.kitpes.entity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcPetRepository implements PetRepository {

    private JdbcOperations jdbc;

    private DataSource dataSource;

    @Autowired
    public JdbcPetRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Pet> readAll() {
        return jdbc.query(
                "SELECT * FROM pets",
                new PetRowMapper());
    }

    public List<Pet> readByUserID(long userID) {
        return jdbc.query(
                "SELECT * FROM pets" +
                        " WHERE user_id = ?",
                new PetRowMapper(), userID);
    }

    public List<Pet> readbyOrganizationID(long organizationID) {
        return jdbc.query(
                "SELECT * FROM pets" +
                        " WHERE organization_id = ?",
                new PetRowMapper(), organizationID);
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
                + " SET name=?, animal=?, age=?, sex=?, description=?, status=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {
                pet.getName(),
                pet.getAnimal(),
                pet.getAge(),
                pet.getSex(),
                pet.getDescription(),
                pet.getStatus(),
                pet.getId()};

        jdbc.update(updateStatement, updatedDataAndID);
    }

    public void updateProfileImage(String profileImage, long id) {
        String updateStatement = " UPDATE pets"
                + " SET profile_image=?"
                + " WHERE id=?";

        System.out.println("jdbc: " + profileImage);
        Object[] updatedDataAndID = { profileImage, id };

        jdbc.update(updateStatement, updatedDataAndID);
    }

    public long save(Pet pet) {
        final String insertSQL = "INSERT INTO pets (name, animal, age, sex, description, status, user_id, organization_id, profile_image)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

                    /* Setting userID and organizationID */
                    Long userID  = pet.getUserID();
                    Long organizationID = pet.getOrganizationID();

                    /* Set userID with some id or null */
                    if(userID != null)
                        ps.setLong(7, userID);
                    else
                        ps.setNull(7, Types.BIGINT);

                    /* Set organizationID with some id or null */
                    if(organizationID != null)
                        ps.setLong(8, organizationID);
                    else
                        ps.setNull(8, Types.BIGINT);

                    ps.setString(9, pet.getProfileImgURL());
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
                    rs.getLong("user_id"),
                    rs.getLong("organization_id"),
                    rs.getString("profile_image"));
        }
    }
}
