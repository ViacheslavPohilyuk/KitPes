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

    public int deleteOne(long id);

    public int updateOne(User user);

    public long save(User user);
}
