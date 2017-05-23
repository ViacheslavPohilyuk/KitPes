package org.kitpes.entity;
import java.util.List;

/**
 * Created by mac on 11.04.17.
 */
public class Organization {
    private Long id;

    private String name;

    private String address;

    private String description;

    private List<Pet> pets = null;

    private Long userID = null;

    private String profileImgURL = "/resources/images/default_org.png";

    public Organization() {
    }

    public Organization(String name, String address, String description, Long userID, String profileImgURL) {
        this(null, name, address, description, userID, profileImgURL);
    }

    public Organization(Long id, String name, String address, String description, Long userID, String profileImgURL) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.userID = userID;
        this.profileImgURL = profileImgURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pet> getPets() { return pets; }

    public void setPets(List<Pet> pets) { this.pets = pets; }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", pets=" + pets +
                ", userID=" + userID +
                ", profileImgURL='" + profileImgURL + '\'' +
                '}';
    }
}
