package org.kitpes.data.contract;

import org.kitpes.model.News;

import java.util.List;

/**
 * Created by mac on 02.07.17.
 */
public interface NewsRepository {
    List<News> readAll();

    News readOne(long id);

    int deleteOne(long id);

    int updateOne(News news);

    int updateProfileImage(String profileImage, long id);

    long save(News news);
}
