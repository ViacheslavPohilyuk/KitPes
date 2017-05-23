package org.kitpes.entity;

/**
 * Created by mac on 11.04.17.
 */
public class Pet {
    private Long id;

    private String name;

    /* cat, dog etc. */
    private String animal;

    private int age;

    private String sex;

    /* description about a pet */
    private String description;

    /* health of a pet */
    private String status;

    /* the reference to the user entity */
    private Long userID = null;

    /* the reference to the organization entity */
    private Long organizationID = null;

    /* URL of a profile picture of a pet */
    private String profileImgURL = "/resources/images/default_pet.jpg";

    public Pet() {
    }

    public Pet(String name, String animal, int age, String sex, String description,
               String status, Long userID, Long organizationID, String profileImgURL) {
        this(null, name, animal, age, sex, description,
                status, userID, organizationID, profileImgURL);
    }

    public Pet(Long id, String name, String animal, int age, String sex,
               String description, String status, Long userID, Long organizationID,
               String profileImgURL) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.status = status;
        this.description = description;
        this.age = age;
        this.sex = sex;
        this.userID = userID;
        this.organizationID = organizationID;
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

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String type) {
        this.animal = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public String getProfileImgURL() {
        return profileImgURL;
    }

    public void setProfileImgURL(String profileImgURL) {
        this.profileImgURL = profileImgURL;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", animal='" + animal + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", userID=" + userID +
                ", organizationID=" + organizationID +
                ", profileImgURL='" + profileImgURL + '\'' +
                '}';
    }
}
