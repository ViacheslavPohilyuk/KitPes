package org.kitpes.model.pet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by mac on 28.07.17.
 */
@Getter
@Setter
@ToString()
public class HomelessPet extends MainPet {

    /* health of a pet
     * - здоровый
     * - в тяжелом состоянии
     * - требует специального ухода */
    private String status;

    Boolean sterilized;

    Boolean vaccinated;

    public HomelessPet() {
        super();
    }

    public HomelessPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, Long userId, String dateLost, String status, Boolean sterilized, Boolean vaccinated) {
        super(id, name, species, age, sex, description, profileImgURL, userId);
        this.status = status;
        this.sterilized = sterilized;
        this.vaccinated = vaccinated;
    }
}
