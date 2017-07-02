package org.kitpes.data.contract;

import org.kitpes.model.User;

import java.util.List;

/**
 * Created by mac on 13.05.17.
 */
public interface UserRepository {
    List<User> readAll();

    User readOne(long id);

    User readByEmailAndPass(String email, String password);

    int deleteOne(long id);

    int updateOne(User user);

    int updateProfileImage(String profileImage, long id);

    long save(User user);
}
