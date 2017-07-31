package org.kitpes.model.pet;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mac on 28.07.17.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "found_pets")
public class FoundPet extends Pet {

    @Column(name = "dateFound")
    private String dateFound;

    public FoundPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, String dateFound) {
        super(id, name, species, age, sex, description, profileImgURL);
        this.dateFound = (dateFound != null) ? dateFound : "Нет данных";
    }
}
