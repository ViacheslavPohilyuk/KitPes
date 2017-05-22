package org.kitpes.data.organization;

import org.kitpes.entity.Organization;
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
    public JdbcOrganizationRepository(JdbcOperations jdbc) { this.jdbc = jdbc;}

    @Override
    public List<Organization> readAll() {
        return jdbc.query(
                "SELECT * FROM organizations",
                new OrganizationRowMapper());
    }

    public List<Organization> readbyUserID(long userID) {
        return jdbc.query(
                "SELECT * FROM organizations" +
                        " WHERE user_id = ?",
                new JdbcOrganizationRepository.OrganizationRowMapper(), userID);
    }

    @Override
    public Organization readOne(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM organizations" +
                        " WHERE id = ?",
                new OrganizationRowMapper(), id);
    }

    @Override
    public void deleteOne(long id) {
        Object[] params = {id};
        int[] types = {Types.BIGINT};
        jdbc.update("DELETE FROM organizations"
                        + " WHERE id = ?",
                params, types
        );
    }

    @Override
    public void updateOne(Organization organization) {
        String updateStatement = "UPDATE organizations"
                + " SET name=?, address=?, description=?"
                + " WHERE id=?";

        Object[] updateDataAndID = {
                organization.getName(),
                organization.getAddress(),
                organization.getDescription(),
                organization.getId()
        };

        jdbc.update(updateStatement, updateDataAndID);
    }

    @Override
    public long save(Organization organization) {
        final String insertSQL = "INSERT INTO organizations (name, address, description, user_id)" +
                " VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, organization.getName());
                    ps.setString(2, organization.getAddress());
                    ps.setString(3, organization.getDescription());
                    ps.setLong(4, organization.getUserID());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    private static class OrganizationRowMapper implements RowMapper<Organization>, Serializable {
        OrganizationRowMapper() {
        }
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Organization(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("description"),
                    rs.getLong("user_id")
            );
        }
    }
}
