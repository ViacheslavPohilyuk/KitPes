package org.kitpes.model;

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

    public Pet() {
    }

    public Pet(Long id,
               String name,
               String animal,
               int age,
               String sex,
               String description,
               String status,
               String organization
               ) {
        this.id = id;
        this.name = name;
        this.animal = animal;
        this.status = status;
        this.description = description;
        this.organization = organization;
        this.age = age;
        this.sex = sex;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAnimal() { return animal; }

    public void setAnimal(String type) { this.animal = type; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getOrganization() { return organization; }

    public void setOrganization(String oraginzation) { this.organization = oraginzation; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public String getSex() { return this.sex; }

    public void setSex(String sex) { this.sex = sex; }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + animal + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", organization='" + organization + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
