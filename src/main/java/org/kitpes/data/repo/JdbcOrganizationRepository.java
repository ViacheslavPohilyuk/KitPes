package org.kitpes.data.repo;

import lombok.NoArgsConstructor;
import org.kitpes.data.contract.OrganizationRepository;
import org.kitpes.model.Organization;
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
 * Created by blizardinka on 14.05.17.
 */

@Repository
public class JdbcOrganizationRepository implements OrganizationRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcOrganizationRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Getting all the organizations from the db
     *
     * @return a list of organizations
     */
    @Override
    public List<Organization> readAll() {
        return jdbc.query(
                "SELECT * FROM organizations",
                new OrganizationRowMapper());
    }

    /**
     * Getting an organization with suitable id
     *
     * @param id organization's id
     * @return an instance of the Organization class
     */
    @Override
    public Organization readOne(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM organizations" +
                        " WHERE id = ?",
                new OrganizationRowMapper(), id);
    }

    /**
     * Getting an organization with suitable name
     *
     * @param name a name of an organization
     * @return an organization with required name
     */
    public Organization readOneByName(String name) {
        return jdbc.queryForObject(
                "SELECT * FROM organizations" +
                        " WHERE name = ?",
                new OrganizationRowMapper(), name);
    }

    /**
     * Getting a list of organizations with required user's id
     *
     * @param userID a host id of this organization
     * @return a list of organizations
     */
    public List<Organization> readByUserID(long userID) {
        return jdbc.query(
                "SELECT * FROM organizations" +
                        " WHERE user_id = ?",
                new OrganizationRowMapper(), userID);
    }

    /**
     * Delete an organization with suitable id
     *
     * @param id organization's id
     */
    @Override
    public int deleteOne(long id) {
        /* Deleting an organization with a suitable id */
        Object[] params = {id};
        int[] types = {Types.BIGINT};

        return jdbc.update("DELETE FROM organizations"
                        + " WHERE id = ?",
                params, types
        );
    }

    /**
     * Changing data of received organization in the db
     *
     * @param organization an instance of the Organization class
     */
    @Override
    public int updateOne(Organization organization) {
        String updateStatement = "UPDATE organizations"
                + " SET name=?, address=?, description=?"
                + " WHERE id=?";

        Object[] updateDataAndID = {
                organization.getName(),
                organization.getAddress(),
                organization.getDescription(),
                organization.getId()
        };

        return jdbc.update(updateStatement, updateDataAndID);
    }

    /**
     * This method needs for getting url of an organization's profile image
     *
     * @param profileImage url string of profile image of an organization
     * @param id           id of the required organization
     */
    public int updateProfileImage(String profileImage, long id) {
        String updateStatement = " UPDATE organizations"
                + " SET profile_image=?"
                + " WHERE id=?";

        System.out.println("jdbc: " + profileImage);
        Object[] updatedDataAndID = {profileImage, id};

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * Insert a new organization's data to the db, and return
     * auto-generated key, that is id of this organization
     *
     * @param organization an instance of Organization class
     * @return auto-generated key from the db
     */
    @Override
    public long save(Organization organization) {
        final String insertSQL = "INSERT INTO organizations (name, address, description, user_id, profile_image, type)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, organization.getName());
                    ps.setString(2, organization.getAddress());
                    ps.setString(3, organization.getDescription());

                    if(organization.getUserID() != null)
                        ps.setLong(4, organization.getUserID());

                    ps.setString(5, organization.getProfileImgURL());
                    ps.setInt(6, organization.getType());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    /**
     * This row mapper class needs to get all data of some organization from the db
     */
    @NoArgsConstructor
    private static class OrganizationRowMapper implements RowMapper<Organization>, Serializable {
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Organization(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("description"),
                    rs.getLong("user_id"),
                    rs.getString("profile_image"),
                    rs.getInt("type")
            );
        }
    }
}
