package org.kitpes.model;

import lombok.*;

/**
 * Created by mac on 11.04.17.
 */
@Getter
@Setter
@ToString()
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Long id;

    private String name;

    /* cat, dog etc. */
    private String animal;

    private int age;

    private String sex;

    /* description about a pet */
    private String description;

    /* health of a pet
     * - здоровый
     * - в тяжелом состоянии
     * - требует специального ухода
     */
    private String status;

    /* the reference to the user model */
    private Long userID = null;

    /* the reference to the organization model */
    private Long organizationID = null;

    /* URL of a profile picture of a pet */
    private String profileImgURL = "/resources/images/default_pet.jpg";

    boolean sterilized;

    boolean vaccinated;

    public Pet(String name, String animal, int age, String sex, String description, String status, Long userID, Long organizationID, String profileImgURL, boolean vaccinated, boolean sterilized) {
        this(null, name, animal, age, sex, description, status, userID, organizationID, profileImgURL, vaccinated, sterilized);
    }

}
