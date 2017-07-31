package org.kitpes.data.repo.pet;

import org.kitpes.data.SessionExecutor;
import org.kitpes.model.pet.FoundPet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mac on 30.07.17.
 */
@Repository
public class FoundPetRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public Collection<FoundPet> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<FoundPet>(s.createCriteria(FoundPet.class).list()));
    }

    public FoundPet get(long id) {
        return sessionExecutor.readSession((s) -> (FoundPet) s.get(FoundPet.class, id));
    }

    public void update(FoundPet pet) {
        sessionExecutor.updateSession((s) -> s.update(pet));
    }

    public void save(FoundPet pet) {
        sessionExecutor.updateSession((s) -> s.persist(pet));
    }

    public void delete(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    FoundPet pet = (FoundPet) s.get(FoundPet.class, id);
                    s.delete(pet);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }

    public void updateImage(String profileImage, long petId) {
        sessionExecutor.updateSession((s) -> {
            String hqlUpdate = "update found_pets f set f.profile_image = :newImage where f.id = :petId";
            s.createQuery(hqlUpdate)
                    .setString("newImage", profileImage)
                    .setLong("petId", petId)
                    .executeUpdate();
        });
    }
}
