package org.kitpes.entity;

/**
 * Created by mac on 11.04.17.
 */
public class Pet {
    private String name;
    private String type; // cat, dog etc.
    private String status; // if a pet need to be treated
    private String description; // description about a pet
    private String organization; // an organization that a pet is bound
    private int age;
    private boolean sex;
    private boolean vaccinated; // a pet is vaccinated or not
    private boolean sterilized; // a pet is sterilized or not

    public Pet(String name,
               String type,
               String status,
               String description,
               String organization,
               int age,
               boolean sex,
               boolean vaccinated,
               boolean sterilized) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.description = description;
        this.organization = organization;
        this.age = age;
        this.sex = sex;
        this.vaccinated = vaccinated;
        this.sterilized = sterilized;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getOrganization() { return organization; }

    public void setOrganization(String oraginzation) { this.organization = oraginzation; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public boolean isSex() { return sex; }

    public void setSex(boolean sex) { this.sex = sex; }

    public boolean isVaccinated() { return vaccinated;}

    public void setVaccinated(boolean vaccinated) { this.vaccinated = vaccinated; }

    public boolean isSterilized() { return sterilized; }

    public void setSterilized(boolean sterilized) { this.sterilized = sterilized; }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", organization='" + organization + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", vaccinated=" + vaccinated +
                ", sterilized=" + sterilized +
                '}';
    }
}
