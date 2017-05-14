package org.kitpes.data;

import org.kitpes.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

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
        return null;
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
}
