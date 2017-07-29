package org.kitpes.model.pet;

import lombok.*;

/**
 * Created by mac on 28.07.17.
 */
@Getter
@Setter
@ToString()
@NoArgsConstructor
public class MainPet {
    private Long id;

    private String name;

    private String sex;

    private String species; // cat, dog etc.

    private int age;

    private String description;

    private String profileImgURL = "/resources/images/default_pet.jpg";

    long userId;

    public MainPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, Long userId) {
        this.id = id;
        this.name = (name != null) ? name : "Без имени";
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.profileImgURL = profileImgURL;
        this.userId = userId;
    }
}
