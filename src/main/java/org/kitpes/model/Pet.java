package org.kitpes.model;

import lombok.*;

/**
 * Created by mac on 11.04.17.
 */
@Getter
@Setter
@ToString()
@NoArgsConstructor
public class Pet {
    private Long id;

    private String name;

    /* cat, dog etc. */
    private String species;

    private Integer age;

    private String sex;

    /* description about a pet */
    private String description;

    /* 0 - found
     * 1 - lost
     * 2 - adopted */
    private Integer type;

    /* URL of a profile picture of a pet */
    private String profileImgURL = "/resources/images/default_pet.jpg";

    private String dateLostFound;

    /* health of a pet
     * - здоровый
     * - в тяжелом состоянии
     * - требует специального ухода */
    private String status;

    /* the reference to the user model */
    private Long userId = null;

    /* the reference to the organization model */
    private Long organizationID = null;

    Boolean sterilized;

    Boolean vaccinated;

    public Pet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, String dateLostFound, String status, Long userId, Long organizationID, Boolean sterilized, Boolean vaccinated) {
        this.id = id;
        this.name = (name != null) ? name : "Без имени";
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.description = description;
        this.profileImgURL = profileImgURL;
        this.dateLostFound = (dateLostFound != null) ? dateLostFound : "Нет данных";
        this.status = status;
        this.userId = userId;
        this.organizationID = organizationID;
        this.sterilized = sterilized;
        this.vaccinated = vaccinated;
    }

    public Pet(String name, String species, Integer age, String sex, String description, String profileImgURL, String dateLostFound, String status, Long userId, Long organizationID, Boolean sterilized, Boolean vaccinated) {
        this(null, name, species, age, sex, description, profileImgURL, dateLostFound, status, userId, organizationID, sterilized, vaccinated);
    }
}
