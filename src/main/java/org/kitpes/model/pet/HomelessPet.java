package org.kitpes.model.pet;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mac on 28.07.17.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "homeless_pets")
public class HomelessPet extends Pet {

    /* health of a pet
     * - здоровый
     * - в тяжелом состоянии
     * - требует специального ухода */
    @Column(name = "status")
    private String status;

    @Column(name = "sterilized")
    Boolean sterilized;

    @Column(name = "vaccinated")
    Boolean vaccinated;

    public HomelessPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, String status, Boolean sterilized, Boolean vaccinated) {
        super(id, name, species, age, sex, description, profileImgURL);
        this.status = status;
        this.sterilized = sterilized;
        this.vaccinated = vaccinated;
    }
}
