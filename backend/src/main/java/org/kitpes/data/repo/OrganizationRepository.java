package org.kitpes.data.repo;

import org.kitpes.model.User;
import org.kitpes.data.SessionExecutor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mac on 30.07.17.
 */
public class OrganizationRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public Collection<User> getAllTextFiles() {
        return sessionExecutor.readSession((s) -> new ArrayList<User>(s.createCriteria(User.class).list()));
    }

    public User getUser(long id) {
        return sessionExecutor.readSession((s) -> (User) s.get(User.class, id));
    }

    public void updateUser(User user) {
        sessionExecutor.updateSession((s) -> s.update(user));
    }

    public void saveUser(User user) {
        sessionExecutor.updateSession((s) -> s.persist(user));
    }

    public void deleteUser(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    User user = (User) s.get(User.class, id);
                    s.delete(user);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }

    public void updateImageUser(String profileImage, long userId) {
        sessionExecutor.updateSession((s) -> {
            String hqlUpdate = "update users u set u.profile_image = :newImage where u.id = :userId";
            s.createQuery(hqlUpdate)
                    .setString("newImage", profileImage)
                    .setLong("userId", userId)
                    .executeUpdate();
        });
    }
}
