package org.kitpes.data.organization;

import org.kitpes.entity.Organization;

import java.util.List;

/**
 * Created by blizardinka on 14.05.17.
 */
public interface OrganizationRepository {

    List<Organization> readAll();

    List<Organization> readbyUserID(long userID);

    Organization readOne(long id);

    void deleteOne(long id);

    void updateOne(Organization organization);

    void updateProfileImage(String profileImage, long id);

    long save(Organization organization);
}
