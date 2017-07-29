package org.kitpes.data.repo;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import lombok.NoArgsConstructor;
import org.kitpes.data.contract.PetRepository;
import org.kitpes.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPetRepository implements PetRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcPetRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    public int totalPets(boolean type) {
        SqlRowSet rowSet = jdbc.queryForRowSet("SELECT COUNT(*) FROM found_lost_pets WHERE type = ?", type);
        rowSet.next();
        return rowSet.getInt(1);
    }

    public List<Pet> readLimited(int type, int lowerBound, int count) {
        return jdbc.query("SELECT * FROM pets WHERE type = ? LIMIT ?, ?",
                new PetRowMapper(), type, lowerBound, count);
    }

    /**
     * Getting all the found_lost_pets from the db
     *
     * @return a list of found_lost_pets
     */
    public List<Pet> readAll(Boolean type, Long userId) {
        List<Pet> foundLostPets;
        if (type != null) {
            if (userId != null) {
                foundLostPets = jdbc.query("SELECT * FROM pets WHERE type = ?  AND user_id = ?",
                        new PetRowMapper(), type, userId);
            } else {
                foundLostPets = jdbc.query("SELECT * FROM pets WHERE type = ?",
                        new PetRowMapper(), type);
            }
        } else {
            if (userId != null) {
                foundLostPets = jdbc.query("SELECT * FROM pets WHERE user_id = ?",
                        new PetRowMapper(), userId);
            } else {
                foundLostPets = jdbc.query("SELECT * FROM pets", new PetRowMapper());
            }
        }
        return foundLostPets;
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
        return jdbc.queryForObject(
                "SELECT * FROM pets" +
                        " WHERE id = ?",
                new PetRowMapper(), id);
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
                + " SET name=?, species=?, age=?, sex=?, description=?, status=?, vaccinated=?, sterilized=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {
                pet.getName(),
                pet.getSpecies(),
                pet.getAge(),
                pet.getSex(),
                pet.getDescription(),
                pet.getStatus(),
                pet.getId(),
                pet.getSterilized(),
                pet.getVaccinated()
        };

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
        final String insertSQL = "INSERT INTO pets (name, species, age, sex, description, status, user_id, organization_id, profile_image, sterilized, vaccinated)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    /* Setting userID and petID */
                    Long userID = pet.getUserId();
                    Long petID = pet.getOrganizationID();

                    ps.setString(1, pet.getName());
                    ps.setString(2, pet.getSpecies());
                    if (pet.getAge() != null) ps.setLong(3, pet.getAge());
                    else ps.setNull(3, Types.BIGINT);
                    ps.setString(4, pet.getSex());
                    ps.setString(5, pet.getDescription());
                    ps.setString(6, pet.getStatus());

                    /* Set userID and petID with some id or null */
                    if (userID != null) ps.setLong(7, userID);
                    else ps.setNull(7, Types.BIGINT);
                    if (petID != null) ps.setLong(8, petID);
                    else ps.setNull(8, Types.BIGINT);
                    ps.setString(9, pet.getProfileImgURL());

                    if (pet.getSterilized() != null) ps.setBoolean(10, pet.getSterilized());
                    else ps.setNull(10, Types.BIGINT);
                    if (pet.getVaccinated() != null) ps.setBoolean(11, pet.getVaccinated());
                    else ps.setNull(11, Types.BIGINT);

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
                    rs.getString("species"),
                    rs.getInt("age"),
                    rs.getString("sex"),
                    rs.getString("description"),
                    rs.getString("profile_image"),
                    rs.getString("dateLostFound"),
                    rs.getString("status"),
                    rs.getLong("user_id"),
                    rs.getLong("organization_id"),
                    rs.getBoolean("vaccinated"),
                    rs.getBoolean("sterilized"));
        }
    }
}
