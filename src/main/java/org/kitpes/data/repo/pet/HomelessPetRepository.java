package org.kitpes.data.repo.pet;

import org.kitpes.data.SessionExecutor;
import org.kitpes.model.pet.HomelessPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mac on 30.07.17.
 */
@Repository
public class HomelessPetRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public Collection<HomelessPet> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<HomelessPet>(s.createCriteria(HomelessPet.class).list()));
    }

    public HomelessPet get(long id) {
        return sessionExecutor.readSession((s) -> (HomelessPet) s.get(HomelessPet.class, id));
    }

    public void update(HomelessPet pet) {
        sessionExecutor.updateSession((s) -> s.update(pet));
    }

    public void save(HomelessPet pet) {
        sessionExecutor.updateSession((s) -> s.persist(pet));
    }

    public void delete(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    HomelessPet pet = (HomelessPet) s.get(HomelessPet.class, id);
                    s.delete(pet);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }

    public void updateImage(String profileImage, long petId) {
        sessionExecutor.updateSession((s) -> {
            String hqlUpdate = "update homeless_pets u set u.profile_image = :newImage where u.id = :petId";
            s.createQuery(hqlUpdate)
                    .setString("newImage", profileImage)
                    .setLong("petId", petId)
                    .executeUpdate();
        });
    }
}
