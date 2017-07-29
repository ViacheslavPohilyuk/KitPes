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
public class LostPet extends MainPet {
    private String dateLost;

    public LostPet() {
        super();
    }

    public LostPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, Long userId, String dateLost) {
        super(id, name, species, age, sex, description, profileImgURL, userId);
        this.dateLost = (dateLost != null) ? dateLost : "Нет данных";
    }
}
