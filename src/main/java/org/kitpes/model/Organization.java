package org.kitpes.model;
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

    private Long userID = null;

    private String profileImgURL = "/resources/images/default_org.png";

    private int type = 0;

    private List<Pet> pets = null;

    public Organization(String name, String address, String description, Long userID, String profileImgURL, Integer type) {
        this(null, name, address, description, userID, profileImgURL, type, null);
    }

    public Organization(Long id, String name, String address, String description, Long userID, String profileImgURL, Integer type) {
        this(id, name, address, description, userID, profileImgURL, type, null);

    }
}
