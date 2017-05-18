package org.kitpes.entity;

/**
 * Created by mac on 11.04.17.
 */
public class Pet {
    private Long id;
    private String name;
    private String animal; // cat, dog etc.
    private int age;
    private String sex;
    private String description; // description about a pet
    private String status; // if a pet need to be treated
    private String organization; // an organization that a pet is bound
    private Long userID = null;

    public Pet() {
    }

    public Pet(String name,
               String animal,
               int age,
               String sex,
               String description,
               String status,
               String organization,
               Long userID
    ) {
        this(null, name, animal, age, sex, description, status, organization, userID);
    }

    public Pet(Long id,
               String name,
               String animal,
               int age,
               String sex,
               String description,
               String status,
               String organization,
               Long userID
    ) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.status = status;
        this.description = description;
        this.organization = organization;
        this.age = age;
        this.sex = sex;
        this.userID = userID;
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

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String oraginzation) {
        this.organization = oraginzation;
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
                ", organization='" + organization + '\'' +
                ", userID=" + userID +
                '}';
    }
}
