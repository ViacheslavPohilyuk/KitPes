package org.kitpes.data.repo;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

import lombok.NoArgsConstructor;
import org.kitpes.data.contract.UserRepository;
import org.kitpes.model.Role;
import org.kitpes.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
        return jdbc.queryForObject("SELECT * FROM users WHERE id = ?", new UserRowMapper(), id);
    }

    public User findByUsername(String username) {
        User user = jdbc.queryForObject(
                "SELECT * FROM users WHERE username = ?",
                new UserRowMapper(), username);

        /* Retrieve roles of this user from the db */
        user.setAuthorities(jdbc.query("SELECT role FROM user_roles WHERE user_id = ?", new RoleRowMapper(), user.getId()));
        return user;
    }

    /**
     * Delete an user with suitable id
     *
     * @param id user's id
     */
    public int deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        return jdbc.update("DELETE FROM users" +
                        " WHERE id = ?",
                params, types);
    }

    /**
     * Changing data of received user in the db
     *
     * @param user an instance of the user class
     */
    public int updateOne(User user) {
        String updateStatement = " UPDATE users"
                + " SET username=?, firstName=?, lastName=?, pass=?"
                + " WHERE id=?";

        Object[] updatedDataAndID = {
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getId()
        };

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * This method needs for getting url of an user's profile image
     *
     * @param profileImage url string of profile image of an user
     * @param userId       id of the required user
     */
    public int updateProfileImage(String profileImage, long userId) {
        String updateStatement = " UPDATE users SET profile_image=? WHERE id=?";

        Object[] updatedDataAndId = {profileImage, userId};

        return jdbc.update(updateStatement, updatedDataAndId);
    }

    /**
     * Insert a new user's data to the db, and return
     * auto-generated key, that is id of this user
     *
     * @param user an instance of user class
     * @return auto-generated key from the db
     */
    public long save(User user) {
        final String insertSQL = "INSERT INTO users (username, firstName, lastName, pass, profile_image)" +
                " VALUES (?, ?, ?, ?, ?)";

        /* Save main information about a new user to the db */
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, user.getUsername());
                    ps.setString(2, user.getFirstName());
                    ps.setString(3, user.getLastName());
                    ps.setString(4, user.getPassword());
                    ps.setString(5, user.getProfileImgURL());
                    return ps;
                },
                keyHolder);
        long userId = (long) keyHolder.getKey();

        /* Save all roles of a new user to the db */
        String sql = "INSERT INTO user_roles (user_id, role) VALUES (?, ?)";
        List<Role> userRoles = user.getAuthorities();

        jdbc.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Role role = userRoles.get(i);
                ps.setLong(1, userId);
                ps.setString(2, role.getRoleName());
            }

            @Override
            public int getBatchSize() {
                return user.getAuthorities().size();
            }
        });

        return userId;
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
                    rs.getString("pass"),
                    rs.getString("profile_image"));
        }
    }

    @NoArgsConstructor
    private static class RoleRowMapper implements RowMapper<Role>, Serializable {
        public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Role(rs.getString("role"));
        }
    }
}
