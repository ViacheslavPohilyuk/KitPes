package org.kitpes.data;

import org.kitpes.entity.Organization;

import java.util.List;

/**
 * Created by blizardinka on 14.05.17.
 */
public interface OrganizationRepository {

    public List<Organization> readbyUserID(long userID);

    public List<Organization> readAll();

    public Organization readOne(long id);

    public int deleteOne(long id);

    public int updateOne(Organization organization);

    public long save(Organization organization);
}
