package org.kitpes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 11.04.17.
 */
/* Lombok annotations
 * for generating getters, setters, toString and constructors */
@Getter
@Setter
@ToString()
@NoArgsConstructor
/*------------------------------------------------------------*/
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Size(min = 2, max = 35, message = "{username.size}")
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    @Column(name = "pass")
    private String password;

    @Column(name = "profile_image")
    private String profileImgURL = "/resources/images/profile.png";

    @Transient
    @JsonIgnore
    private List<Role> authorities = new ArrayList<>();

    //private List<Pet> pets = null;

    //private List<Pet> foundLostPets = null;

    //private List<Organization> organizations = null;

    public User(Long id, String username, String firstName, String lastName, String password, String profileImgURL) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.profileImgURL = profileImgURL;
    }
}
