package org.kitpes.data.user;

import org.kitpes.entity.User;

import java.util.List;

/**
 * Created by mac on 13.05.17.
 */
public interface UserRepository {
    List<User> readAll();

    User readOne(long id);

    User readByEmailAndPass(String email, String password);

    void deleteOne(long id);

    void updateOne(User user);

    void updateProfileImage(String profileImage, long id);

    long save(User user);
}
