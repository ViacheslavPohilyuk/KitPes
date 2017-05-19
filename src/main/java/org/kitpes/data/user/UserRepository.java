package org.kitpes.data.user;

import org.kitpes.entity.User;
import java.util.List;

/**
 * Created by mac on 13.05.17.
 */
public interface UserRepository {
    public List<User> readAll();

    public User readOne(long id);

    public User readByEmailAndPass(String email, String password);

    public void deleteOne(long id);

    public void updateOne(User user);

    public void updateOneProfileImage(String profileImage, long id);

    public long save(User user);
}
