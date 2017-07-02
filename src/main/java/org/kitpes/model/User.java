package org.kitpes.model;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by mac on 11.04.17.
 */

@Getter
@Setter
@ToString()
@NoArgsConstructor
public class User {
    private Long id;

    @NotNull
    @Email
    @Size(min = 2, max = 16, message = "{username.size}")
    private String username;

    @NotNull
    @Size(min = 2, max = 30, message = "{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message = "{lastName.size}")
    private String lastName;

    @NotNull
    @Size(min = 5, max = 25, message = "{password.size}")
    private String password;

    private String profileImgURL = "/resources/images/profile.png";

    private List<Pet> pets = null;

    private List<Organization> organizations = null;

    public User(Long id, String username, String firstName, String lastName, String password, String profileImgURL) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.profileImgURL = profileImgURL;
    }
}
