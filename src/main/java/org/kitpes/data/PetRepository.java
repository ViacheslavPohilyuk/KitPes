package org.kitpes.data;

import org.kitpes.entity.Pet;

import java.util.List;

/**
 * Created by mac on 08.05.17.
 */
public interface PetRepository {
    public List<Pet> readAll();

    public Pet readOne(long id);

    public int deleteOne(long id);

    public int updateOne(Pet pet);

    public long save(Pet pet);
}
