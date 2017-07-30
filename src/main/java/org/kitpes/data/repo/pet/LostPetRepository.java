package org.kitpes.data.repo.pet;

import org.kitpes.model.pet.LostPet;
import org.kitpes.data.SessionExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mac on 30.07.17.
 */
@Repository
public class LostPetRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public Collection<LostPet> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<LostPet>(s.createCriteria(LostPet.class).list()));
    }

    public LostPet get(long id) {
        return sessionExecutor.readSession((s) -> (LostPet) s.get(LostPet.class, id));
    }

    public void update(LostPet pet) {
        sessionExecutor.updateSession((s) -> s.update(pet));
    }

    public void save(LostPet pet) {
        sessionExecutor.updateSession((s) -> s.persist(pet));
    }

    public void delete(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    LostPet pet = (LostPet) s.get(LostPet.class, id);
                    s.delete(pet);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }

    public void updateImage(String profileImage, long petId) {
        sessionExecutor.updateSession((s) -> {
            String hqlUpdate = "update lost_pets u set u.profile_image = :newImage where u.id = :petId";
            s.createQuery(hqlUpdate)
                    .setString("newImage", profileImage)
                    .setLong("petId", petId)
                    .executeUpdate();
        });
    }
}
