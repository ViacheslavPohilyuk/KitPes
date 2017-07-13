package org.kitpes.data.contract;

import org.kitpes.model.User;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by mac on 13.05.17.
 */
public interface UserRepository {
    List<String> readUsernames();

    List<User> readAll();

    User readOne(long id);

    User findByUsername(String username);

    int deleteOne(long id);

    int updateOne(User user);

    int updateProfileImage(String profileImage, long userId);

    long save(User user);
}
