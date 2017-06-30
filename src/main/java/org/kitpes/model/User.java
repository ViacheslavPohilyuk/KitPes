package org.kitpes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.kitpes.data.organization.OrganizationRepository;
import org.kitpes.data.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
/**
 * Created by mac on 11.04.17.
 */

@Getter
@Setter
@ToString(exclude={"pets", "organizations", "petRepository", "organizationRepository"})
@NoArgsConstructor
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

    @JsonIgnore
    @Autowired
    PetRepository petRepository;

    @JsonIgnore
    @Autowired
    OrganizationRepository organizationRepository;

    public User(Long id, String username, String firstName, String lastName, String email, String password, String profileImgURL) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profileImgURL = profileImgURL;

        /* Reading all pets from the db with an id of this user */
        this.pets = petRepository.readByUserID(id);

        /* Reading all organizations from the db with an id of this user */
        this.organizations = organizationRepository.readByUserID(id);

        /* Clean these objects */
        petRepository = null;
        organizationRepository = null;
    }
}
