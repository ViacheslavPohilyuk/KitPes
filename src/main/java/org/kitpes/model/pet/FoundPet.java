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
public class FoundPet extends MainPet {
    private String dateFound;

    public FoundPet() {
        super();
    }

    public FoundPet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, Long userId, String dateFound) {
        super(id, name, species, age, sex, description, profileImgURL, userId);
        this.dateFound = (dateFound != null) ? dateFound : "Нет данных";
    }
}
