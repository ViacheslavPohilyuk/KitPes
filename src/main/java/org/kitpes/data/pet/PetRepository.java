package org.kitpes.data.pet;

import org.kitpes.entity.Pet;
import org.kitpes.entity.Pet;

import java.util.List;

/**
 * Created by mac on 08.05.17.
 */
public interface PetRepository {
    List<Pet> readbyUserID(long userID);

    List<Pet> readbyOrganizationID(long organizationID);

    List<Pet> readAll();

    Pet readOne(long id);

    void deleteOne(long id);

    void updateOne(Pet pet);

    long save(Pet pet);
}
