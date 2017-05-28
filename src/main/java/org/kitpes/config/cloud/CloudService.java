package org.kitpes.config.cloud;

/**
 * Created by mac on 27.05.17.
 */
public interface CloudService {
    <T> T getConnection();
}
