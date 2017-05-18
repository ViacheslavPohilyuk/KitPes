package org.kitpes.entity;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

/**
 * Created by mac on 11.04.17.
 */
public class Organization {
    private Long id;
    @NotNull
    @Size(min=2, max=16)
    private String name;
    @NotNull
    @Size(min=2, max=50)
    private String address;
    private String description;

    public Organization() {
    }

    public Organization(String name,
                        String address,
                        String description) {
        this(null, name, address, description);
    }

    public Organization(
            Long id,
            String name,
            String address,
            String description
            ) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
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
