package org.kitpes.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by mac on 11.04.17.
 */
public class Organization {
    private Long id;
    @NotNull
    @Size(min = 2, max = 16)
    private String name;
    @NotNull
    @Size(min = 2, max = 50)
    private String address;
    private String description;

    private Long userID = null;

    public Organization() {
    }

    public Organization(String name,
                        String address,
                        String description,
                        Long userID) {
        this(null, name, address, description, userID);
    }

    public Organization(
            Long id,
            String name,
            String address,
            String description,
            Long userID
    ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
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
        description = description;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
