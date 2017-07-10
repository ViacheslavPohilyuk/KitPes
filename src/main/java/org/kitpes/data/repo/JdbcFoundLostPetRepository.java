package org.kitpes.data.repo;

import lombok.NoArgsConstructor;
import org.kitpes.data.contract.FoundLostPetRepository;
import org.kitpes.model.FoundLostPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by mac on 03.07.17.
 */
@Repository
public class JdbcFoundLostPetRepository implements FoundLostPetRepository {
    private JdbcOperations jdbc;

    @Autowired
    public JdbcFoundLostPetRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Getting all the found_lost_pets from the db
     *
     * @return a list of found_lost_pets
     */
    public List<FoundLostPet> readAll(Integer type) {
        List<FoundLostPet> foundLostPets;
        if (type != null)
            foundLostPets = jdbc.query("SELECT * FROM found_lost_pets WHERE type = ?",
                    new JdbcFoundLostPetRepository.FoundLostPetRowMapper(), type);
        else
            foundLostPets = jdbc.query("SELECT * FROM found_lost_pets",
                    new JdbcFoundLostPetRepository.FoundLostPetRowMapper());
        return foundLostPets;
    }

    /**
     * Getting an FoundLostPet with suitable id
     *
     * @param id an id of a pet
     * @return an instance of the FoundLostPetclass
     */
    public FoundLostPet readOne(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM found_lost_pets WHERE id = ?",
                new JdbcFoundLostPetRepository.FoundLostPetRowMapper(), id);
    }

    /**
     * Delete an FoundLostPet with suitable id
     *
     * @param id pet's id
     */
    public int deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        return jdbc.update("DELETE FROM found_lost_pets WHERE id = ?", params, types);
    }

    /**
     * Changing data of received FoundLostPet in the db
     *
     * @param foundLostPet an instance of the FoundLostPetclass
     */
    public int updateOne(FoundLostPet foundLostPet) {
        String updateStatement = " UPDATE found_lost_pets SET name =?, sex=?, species=?, age=?, description=?, type=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {
                foundLostPet.getName(),
                foundLostPet.getSex(),
                foundLostPet.getSpecies(),
                foundLostPet.getAge(),
                foundLostPet.getDescription(),
                foundLostPet.getType(),
                foundLostPet.getId(),
        };

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * Insert a new pet's data to the db, and return
     * auto-generated key, that is id of this foundLostPet.
     *
     * @param foundLostPet an instance of FoundLostPet class
     * @return auto-generated key from the db
     */
    public long save(FoundLostPet foundLostPet) {
        final String insertSQL = "INSERT INTO found_lost_pets (name, sex, species, age, description, type, profile_image)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, foundLostPet.getName());
                    ps.setString(2, foundLostPet.getSex());
                    ps.setString(3, foundLostPet.getSpecies());
                    ps.setInt(4, foundLostPet.getAge());
                    ps.setString(5, foundLostPet.getDescription());
                    ps.setInt(6, foundLostPet.getType());
                    ps.setString(7, foundLostPet.getProfileImgURL());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    /**
     * This method needs for getting url of an pet's profile image
     *
     * @param profileImage url string of profile image of an pet
     * @param id           id of the required pet
     */
    public int updateProfileImage(String profileImage, long id) {
        String updateStatement = " UPDATE found_lost_pets"
                + " SET profile_image=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {profileImage, id};

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * This row mapper class needs to get all data of some FoundLostPet from the db
     */
    @NoArgsConstructor
    private static class FoundLostPetRowMapper implements RowMapper<FoundLostPet>, Serializable {
        public FoundLostPet mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new FoundLostPet(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("sex"),
                    rs.getString("species"),
                    rs.getInt("age"),
                    rs.getString("description"),
                    rs.getInt("type"),
                    rs.getString("profile_image"));
        }
    }
}
