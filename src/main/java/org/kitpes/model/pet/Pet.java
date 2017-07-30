package org.kitpes.model.pet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.kitpes.model.User;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mac on 28.07.17.
 */
/* Lombok annotations
 * for generating getters, setters, toString and constructors */
@Getter
@Setter
@ToString()
@NoArgsConstructor
/*------------------------------------------------------------*/
@MappedSuperclass
public class Pet implements Serializable {

    @ManyToOne
    @JsonIgnore
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "species")
    private String species; // cat, dog etc.

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @Column(name = "profile_image")
    private String profileImgURL = "/resources/images/default_pet.jpg";

    @Column(name = "userId")
    long userId;

    public Pet(Long id, String name, String species, Integer age, String sex, String description, String profileImgURL, Long userId) {
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
