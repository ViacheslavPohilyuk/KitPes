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

    @Override
    public Organization readOne(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM organizations" +
                        "WHERE id = ?",
                new OrganizationRowMapper(), id
        );
    }

    @Override
    public Organization readByEmailAndPass(String email, String password) {
        return jdbc.queryForObject(
                "SELECT * FROM organizations" +
                "WHERE email = ? AND pass = ?",
                new OrganizationRowMapper(), email, password
        );
    }

    @Override
    public void deleteOne(long id) {
        Object[] params = {id};
        int[] types = {Types.BIGINT};
        jdbc.update("DELETE FROM users"
                        + "WHERE id = ?",
                params, types
        );
    }

    @Override
    public void updateOne(Organization organization) {
        String updateStatement = "UPDATE organizations"
                + "SET name=?, address=?, cell_number=?, opening_hours=?, working_days=?, description=?"
                + "WHERE id=?";

        Object[] updateDataAndID = {
                organization.getName(),
                organization.getAddress(),
                organization.getCellNumber(),
                organization.getOpeningHours(),
                organization.getWorkingDays(),
                organization.getDescription(),
                organization.getId()
        };
        jdbc.update(updateStatement, updateDataAndID);
    }

    @Override
    public long save(Organization organization) {
        final String insertSQL = "INSERT INTO organizations (name, address, cell_number, opening_hours, working_days, description)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, organization.getName());
                    ps.setString(2, organization.getAddress());
                    ps.setLong(3, organization.getCellNumber());
                    ps.setTime(4, organization.getOpeningHours());
                    ps.setString(5, organization.getWorkingDays());
                    ps.setString(5, organization.getDescription());
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
                    rs.getLong("cell_number"),
                    rs.getTime("opening_hours"),
                    rs.getString("working_days"),
                    rs.getString("description")
            );
        }
    }
}
