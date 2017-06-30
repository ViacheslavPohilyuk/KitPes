package org.kitpes.data.pet;

import org.kitpes.model.Pet;

import java.util.List;

/**
 * Created by mac on 08.05.17.
 */
public interface PetRepository {
    List<Pet> readByUserID(long userID);

    List<Pet> readByOrganizationID(long organizationID);

    List<Pet> readAll();

    Pet readOne(long id);

    int deleteOne(long id);

    int updateOne(Pet pet);

    int updateProfileImage(String profileImage, long id);

    long save(Pet pet);
}
