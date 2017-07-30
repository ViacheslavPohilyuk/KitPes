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
@Table(name = "lost_pets")
public class LostPet extends Pet {

    @Column(name = "dateLost")
    private String dateLost;

    public LostPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, Long userId, String dateLost) {
        super(id, name, species, age, sex, description, profileImgURL, userId);
        this.dateLost = (dateLost != null) ? dateLost : "Нет данных";
    }

    public void setDateLost(String dateLost) {
        this.dateLost = dateLost;
    }
}
