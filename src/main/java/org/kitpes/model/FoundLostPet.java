package org.kitpes.model;

import lombok.*;

/**
 * Created by mac on 03.07.17.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoundLostPet {
    private Long id;

    private String sex;

    private String species; // cat, dog etc.

    private int age;

    private String description;

    private int type; // lost or found

    private String profileImgURL = "/resources/images/default_pet.jpg";

    public FoundLostPet(String sex, String species, int age, String description, int type, String profileImgURL) {
        this(null, sex, species, age, description, type, profileImgURL);
    }
}
