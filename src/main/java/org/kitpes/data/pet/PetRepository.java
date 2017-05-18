package org.kitpes.data.pet;

import org.kitpes.entity.Pet;
import org.kitpes.model.Pet;

import java.util.List;

/**
 * Created by mac on 08.05.17.
 */
public interface PetRepository {
    public List<Pet> readbyUserID(long userID);

    public List<Pet> readAll();

    public Pet readOne(long id);

    public void deleteOne(long id);

    public void updateOne(Pet pet);

    public long save(Pet pet);
}
