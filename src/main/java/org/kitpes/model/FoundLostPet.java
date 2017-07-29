package org.kitpes.model;

import lombok.*;

/**
 * Created by mac on 03.07.17.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class FoundLostPet {
    private Long id;

    private String name;

    private String sex;

    private String species; // cat, dog etc.

    private int age;

    private String description;

    private String dateLostFound;

    private boolean type; // lost or found

    private String profileImgURL = "/resources/images/default_pet.jpg";

    long userId;

    public FoundLostPet(Long id, String name, String sex, String species, int age, String description, String dateLostFound, boolean type, String profileImgURL, long userId) {

        this.name = (name != null) ? name : "Без имени";
        this.dateLostFound = (dateLostFound != null) ? dateLostFound : "Нет данных";

        this.id = id;
        this.sex = sex;
        this.species = species;
        this.age = age;
        this.description = description;
        this.type = type;
        this.profileImgURL = profileImgURL;
        this.userId = userId;
    }
}
