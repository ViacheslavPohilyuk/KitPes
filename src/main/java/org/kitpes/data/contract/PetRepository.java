package org.kitpes.data.contract;

import org.kitpes.model.FoundLostPet;
import org.kitpes.model.Pet;

import java.util.List;

/**
 * Created by mac on 08.05.17.
 */
public interface PetRepository {
    public int totalPets(boolean type);

    List<Pet> readLimited(int type, int lowerBound, int count);

    List<Pet> readByUserID(long userID);

    List<Pet> readByOrganizationID(long organizationID);

    List<Pet> readAll(Boolean type, Long userId);

    Pet readOne(long id);

    int deleteOne(long id);

    int updateOne(Pet pet);

    int updateProfileImage(String profileImage, long id);

    long save(Pet pet);
}
