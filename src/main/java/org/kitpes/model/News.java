package org.kitpes.model;

import lombok.*;

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

    String dateAdded;

    String image;

    public News(String name, String description) {
        this(null, name, description, null, null);
    }

    public News(Long id, String name, String description) {
        this(id, name, description, null, null);
    }
}
