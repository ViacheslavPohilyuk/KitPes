package org.kitpes.data.user;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import lombok.NoArgsConstructor;
import org.kitpes.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcUserRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Getting all the users from the db
     *
     * @return a list of users
     */
    public List<User> readAll() {
        return jdbc.query("SELECT * FROM users", new UserRowMapper());
    }

    /**
     * Getting an user with suitable id
     *
     * @param id user's id
     * @return an instance of the user class
     */
    public User readOne(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM users" +
                        " WHERE id = ?",
                new UserRowMapper(), id);
    }

    /**
     * Getting an user with suitable email and password
     *
     * @param email an user's email
     * @param password an user's password
     * @return an instance of the User class
     */
    public User readByEmailAndPass(String email, String password) {
        return jdbc.queryForObject(
                "SELECT * FROM users" +
                        " WHERE email = ? AND pass = ?",
                new UserRowMapper(), email, password);
    }

    /**
     * Delete an user with suitable id
     *
     * @param id user's id
     */
    public void deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        jdbc.update("DELETE FROM users" +
                        " WHERE id = ?",
                params, types);
    }

    /**
     * Changing data of received user in the db
     *
     * @param user an instance of the user class
     */
    public void updateOne(User user) {
        String updateStatement = " UPDATE users"
                + " SET username=?, firstName=?, lastName=?, email=?, pass=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getId()
        };

        jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * This method needs for getting url of an user's profile image
     *
     * @param profileImage url string of profile image of an user
     * @param id           id of the required user
     */
    public void updateProfileImage(String profileImage, long id) {
        String updateStatement = " UPDATE users"
                + " SET profile_image=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {profileImage, id};

        jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * Insert a new user's data to the db, and return
     * auto-generated key, that is id of this user
     *
     * @param user an instance of user class
     * @return auto-generated key from the db
     */
    public long save(User user) {
        final String insertSQL = "INSERT INTO users (username, firstName, lastName, email, pass, profile_image)" +
                " VALUES (?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, user.getUsername());
                    ps.setString(2, user.getFirstName());
                    ps.setString(3, user.getLastName());
                    ps.setString(4, user.getEmail());
                    ps.setString(5, user.getPassword());
                    ps.setString(6, user.getProfileImgURL());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    /**
     * This row mapper class needs to get all data of some user from the db
     */
    @NoArgsConstructor
    private static class UserRowMapper implements RowMapper<User>, Serializable {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("pass"),
                    rs.getString("profile_image"));
        }
    }
}
