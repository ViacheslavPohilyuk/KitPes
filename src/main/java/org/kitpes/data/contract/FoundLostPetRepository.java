package org.kitpes.data.contract;

import org.kitpes.model.FoundLostPet;

import java.util.List;

/**
 * Created by mac on 03.07.17.
 */
public interface FoundLostPetRepository {
    List<FoundLostPet> readLimited(int type, int lowerBound, int count);

    List<FoundLostPet> readAll(Integer type);

    FoundLostPet readOne(long id);

    int deleteOne(long id);

    int updateOne(FoundLostPet pet);

    int updateProfileImage(String profileImage, long id);

    long save(FoundLostPet pet);
}
