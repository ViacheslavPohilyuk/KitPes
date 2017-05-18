package org.kitpes.data.organization;

import org.kitpes.entity.Organization;

import java.util.List;

/**
 * Created by blizardinka on 14.05.17.
 */
public interface OrganizationRepository {

    public List<Organization> readAll();

    public Organization readOne(long id);

    public Organization readByEmailAndPass(String email, String password);

    public void deleteOne(long id);

    public void updateOne(Organization organization);

    public long save(Organization organization);
}
