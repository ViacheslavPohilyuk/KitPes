package org.kitpes.data.repo;

import lombok.NoArgsConstructor;
import org.joda.time.LocalDateTime;
import org.kitpes.data.contract.NewsRepository;
import org.kitpes.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Created by mac on 02.07.17.
 */
@Repository
public class JdbcNewsRepository implements NewsRepository {
    private JdbcOperations jdbc;

    @Autowired
    public JdbcNewsRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Getting all the Newss from the db
     *
     * @return a list of Newss
     */
    public List<News> readAll() {
        return jdbc.query("SELECT * FROM news", new JdbcNewsRepository.NewsRowMapper());
    }

    public News readOne(long id) {
        return jdbc.queryForObject("SELECT * FROM news WHERE id = ?", new JdbcNewsRepository.NewsRowMapper(), id);
    }

    /**
     * Delete an News with suitable id
     *
     * @param id News's id
     */
    public int deleteOne(long id) {
        // define query arguments
        Object[] params = {id};
        // define SQL types of the arguments
        int[] types = {Types.BIGINT};
        return jdbc.update("DELETE FROM news WHERE id = ?", params, types);
    }

    /**
     * Changing data of received News in the db
     *
     * @param News an instance of the News class
     */
    public int updateOne(News News) {
        String updateStatement = " UPDATE news"
                + " SET name=?, description=?, dateAdded=?, image=? WHERE id=?";

        Object[] updatedDataAndID = {
                News.getName(),
                News.getDescription(),
                News.getDateAdded(),
                News.getImage(),
                News.getId()
        };

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * This method needs for getting url of an News's profile image
     *
     * @param profileImage url string of profile image of an News
     * @param id           id of the required News
     */
    public int updateProfileImage(String profileImage, long id) {
        String updateStatement = " UPDATE news"
                + " SET image=?"
                + " WHERE id=?";

        System.out.println("jdbc: " + profileImage);
        Object[] updatedDataAndID = {profileImage, id};

        return jdbc.update(updateStatement, updatedDataAndID);
    }

    /**
     * Insert a new News's data to the db, and return
     * auto-generated key, that is id of this News.
     *
     * @param news an instance of News class
     * @return auto-generated key from the db
     */
    public long save(News news) {
        /* Set the date when news is added to the db */
        String ldt = new LocalDateTime().toString();
        int indexT = ldt.indexOf('T');
        String dateAdded = ldt.substring(0, indexT) + " " + ldt.substring(indexT + 1, ldt.lastIndexOf(':'));
        news.setDateAdded(dateAdded);

        final String insertSQL = "INSERT INTO news (name, description, dateAdded, image) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update((connection) -> {
                    PreparedStatement ps =
                            connection.prepareStatement(insertSQL, new String[]{"id"});
                    ps.setString(1, news.getName());
                    ps.setString(2, news.getDescription());
                    ps.setString(3, news.getDateAdded());
                    ps.setString(4, news.getImage());
                    return ps;
                },
                keyHolder);

        return (long) keyHolder.getKey();
    }

    /**
     * This row mapper class needs to get all data of some News from the db
     */
    @NoArgsConstructor
    private static class NewsRowMapper implements RowMapper<News>, Serializable {
        public News mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new News(rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("dateAdded"),
                    rs.getString("image"));
        }
    }
}
