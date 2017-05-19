package org.kitpes.entity;

import org.hibernate.validator.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by mac on 11.04.17.
 */
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

    public User() {
    }

    public User(String email,
                String password) {
        this(null, null, null, null, email, password, null);
    }

    public User(String username,
                String firstName,
                String lastName,
                String email,
                String password,
                String profileImgURL) {
        this(null, username, firstName, lastName, email, password, profileImgURL);
    }

    public User(Long id,
                String username,
                String firstName,
                String lastName,
                String email,
                String password,
                String profileImgURL) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profileImgURL = profileImgURL;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
