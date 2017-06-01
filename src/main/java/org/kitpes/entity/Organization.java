package org.kitpes.entity;
import lombok.*;

import java.util.List;
/**
 * Created by mac on 11.04.17.
 */
@Getter
@Setter
@ToString(exclude="pets")
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private Long id;

    private String name;

    private String address;

    private String description;

    private List<Pet> pets = null;

    private Long userID = null;

    private String profileImgURL = "/resources/images/default_org.png";

    private int type = 0;

    public Organization(String name, String address, String description, Long userID, String profileImgURL, Integer type) {
        this(null, name, address, description, null, userID, profileImgURL, type);
    }

    public Organization(Long id, String name, String address, String description, Long userID, String profileImgURL, Integer type) {
        this(null, name, address, description, null, userID, profileImgURL, type);

    }
}
