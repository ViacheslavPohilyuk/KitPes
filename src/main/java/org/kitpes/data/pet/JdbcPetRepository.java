package org.kitpes.data.pet;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import lombok.NoArgsConstructor;
import org.kitpes.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Getting all the pets from the db
     *
     * @return a list of pets
     */
    public List<Pet> readAll() {
        return jdbc.query(
                "SELECT * FROM pets",
                new PetRowMapper());
    }

    /**
     * Getting a list of pets with required user's id
     *
     * @param userID a host id of this pet
     * @return a list of pets
     */
    public List<Pet> readByUserID(long userID) {
        return jdbc.query(
                "SELECT * FROM pets" +
                        " WHERE user_id = ?",
                new PetRowMapper(), userID);
    }

    /**
     * Getting an pet with suitable id
     *
     * @param petID a pet's id
     * @return an instance of the pet class
     */
    public List<Pet> readByOrganizationID(long petID) {
        return jdbc.query(
                "SELECT * FROM pets" +
                        " WHERE organization_id = ?",
                new PetRowMapper(), petID);
    }


    public Pet readOne(long id) {
        Pet pet;

        pet = jdbc.queryForObject(
                "SELECT * FROM pets" +
                        " WHERE id = ?",
                new PetRowMapper(), id);
        return pet;
    }

    /**
     * Delete an pet with suitable id
     *
     * @param id pet's id
     */
    public int deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        return jdbc.update("DELETE FROM pets" +
                        " WHERE id = ?",
                params, types);
    }

    /**
     * Changing data of received pet in the db
     *
     * @param pet an instance of the pet class
     */
    public int updateOne(Pet pet) {
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

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * This method needs for getting url of an pet's profile image
     *
     * @param profileImage url string of profile image of an pet
     * @param id           id of the required pet
     */
    public int updateProfileImage(String profileImage, long id) {
        String updateStatement = " UPDATE pets"
                + " SET profile_image=?"
                + " WHERE id=?";

        System.out.println("jdbc: " + profileImage);
        Object[] updatedDataAndID = {profileImage, id};

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * Insert a new pet's data to the db, and return
     * auto-generated key, that is id of this pet.
     *
     * @param pet an instance of pet class
     * @return auto-generated key from the db
     */
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

                    /* Setting userID and petID */
                    Long userID = pet.getUserID();
                    Long petID = pet.getOrganizationID();

                    /* Set userID with some id or null */
                    if (userID != null)
                        ps.setLong(7, userID);
                    else
                        ps.setNull(7, Types.BIGINT);

                    /* Set petID with some id or null */
                    if (petID != null)
                        ps.setLong(8, petID);
                    else
                        ps.setNull(8, Types.BIGINT);

                    ps.setString(9, pet.getProfileImgURL());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    /**
     * This row mapper class needs to get all data of some pet from the db
     */
    @NoArgsConstructor
    private static class PetRowMapper implements RowMapper<Pet>, Serializable {
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
                    rs.getString("profile_image"),
                    rs.getBoolean("vaccinated"),
                    rs.getBoolean("sterilized"));
        }
    }
}
