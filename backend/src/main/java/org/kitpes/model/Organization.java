package org.kitpes.model;

import lombok.*;

import java.util.List;

/**
 * Created by mac on 11.04.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private Long id;

    private String name;

    private String address;

    private String description;

    private Long userID = null;

    private String profileImgURL = "/resources/images/default_org.png";

    private boolean type;

    private String phoneNumber;

    private String webSite;
}
