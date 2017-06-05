package org.kitpes.entity;

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
@ToString(exclude={"pets", "organizations"})
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;

    @NotNull
    @Size(min = 2, max = 16, message="{username.size}")
    private String username;

    @NotNull
    @Size(min = 2, max = 30, message="{firstName.size}")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30, message="{lastName.size}")
    private String lastName;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 25, message="{password.size}")
    private String password;

    private List<Pet> pets = null;

    private List<Organization> organizations = null;

    private String profileImgURL = "/resources/images/profile.png";

    public User(Long id, String username, String firstName, String lastName, String email, String password, String profileImgURL) {
        this(id, username, firstName, lastName, email, password, null, null, profileImgURL);
    }

    public User(String username, String firstName, String lastName, String email, String password, String profileImgURL) {
        this(null, username, firstName, lastName, email, password, null, null, profileImgURL);
    }
}
