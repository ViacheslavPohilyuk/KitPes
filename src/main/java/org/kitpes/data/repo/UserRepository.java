package org.kitpes.data.repo;

import org.hibernate.Query;
import org.kitpes.model.User;
import org.kitpes.data.SessionExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by mac on 28.07.17.
 */
@Repository
public class UserRepository {

    @Autowired
    private SessionExecutor sessionExecutor;

    public Collection<User> getAll() {
        return sessionExecutor.readSession((s) -> new ArrayList<User>(s.createCriteria(User.class).list()));
    }

    public User getByName(String username) {
        return sessionExecutor.readSession((s) -> {
            Query query = s.createQuery("from users where username = :username ");
            query.setParameter("username", username);
            return (User) query.uniqueResult();
        });
    }

    public User get(long id) {
        return sessionExecutor.readSession((s) -> (User) s.get(User.class, id));
    }

    public void update(User user) {
        sessionExecutor.updateSession((s) -> s.update(user));
    }

    public void save(User user) {
        sessionExecutor.updateSession((s) -> s.persist(user));
    }

    public void delete(long id) {
        sessionExecutor.updateSession(
                (s) -> {
                    User user = (User) s.get(User.class, id);
                    s.delete(user);

                    // This makes the pending delete to be done
                    s.flush();
                });
    }

    public void updateImage(String profileImage, long userId) {
        sessionExecutor.updateSession((s) -> {
            String hqlUpdate = "update users u set u.profile_image = :newImage where u.id = :userId";
            s.createQuery(hqlUpdate)
                    .setString("newImage", profileImage)
                    .setLong("userId", userId)
                    .executeUpdate();
        });
    }
}
