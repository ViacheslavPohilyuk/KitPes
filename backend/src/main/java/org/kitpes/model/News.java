package org.kitpes.model;

import lombok.*;

import java.util.Date;

/**
 * Created by mac on 02.07.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class News {
    Long id;

    String name;

    String description;

    String dateAddedFormat;

    String image;

    public News(String name, String description) {
        this(null, name, description, null, null);
    }

    public News(Long id, String name, String description) { this(id, name, description, null, null); }
}
