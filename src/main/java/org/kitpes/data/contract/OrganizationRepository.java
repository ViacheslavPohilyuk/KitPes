package org.kitpes.data.contract;

import org.kitpes.model.Organization;

import java.util.List;

/**
 * Created by blizardinka on 14.05.17.
 */
public interface OrganizationRepository {

    List<Organization> readAll();

    List<Organization> readByUserID(long userID);

    Organization readOneByName(String name);

    Organization readOne(long id);

    int deleteOne(long id);

    int updateOne(Organization organization);

    int updateProfileImage(String profileImage, long id);

    long save(Organization organization);
}
