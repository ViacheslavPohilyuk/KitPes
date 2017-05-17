package org.kitpes.data;

import org.kitpes.model.Organization;
import org.kitpes.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                "SELECT * FROM organization",
                new Orga
        );
    }

    @Override
    public Organization readOne(long id) {
        return null;
    }

    @Override
    public int deleteOne(long id) {
        return 0;
    }

    @Override
    public int updateOne(Organization organization) {
        return 0;
    }

    @Override
    public long save(Organization organization) {
        return 0;
    }

    private static class OrganizationRowMapper implements RowMapper<Organization>, Serializable {
        OrganizationRowMapper() {
        }
        public Organization mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Organization(rs.getLong("id"),
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
