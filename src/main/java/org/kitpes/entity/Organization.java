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
    @Size(min=2, max=16)
    private Long cellNumber;
    @NotNull
    @Size(min=2, max=16)
    private Time openingHours;
    @NotNull
    @Size(min=2, max=16)
    private String workingDays;

    private String description;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 5, max = 25)
    private String password;

    public Organization() {
    }

    public Organization(String email,
                        String password) {
        this(null, null, null,
                null, null, null,
                null, email, password);
    }

    public Organization(String name,
                        String address,
                        Long cellNumber,
                        Time openingHours,
                        String workingDays,
                        String description,
                        String email,
                        String password) {
        this(null, name, address, cellNumber, openingHours, workingDays, description, email, password);
    }

    public Organization(
            Long id,
            String name,
            String address,
            Long cellNumber,
            Time openingHours,
            String workingDays,
            String description,
            String email,
            String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellNumber = cellNumber;
        this.openingHours = openingHours;
        this.workingDays = workingDays;
        this.description = description;
        this.email = email;
        this.password = password;
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

    public Long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(Long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public Time getOpeningHours() {
        return openingHours;
    }

     public void setOpeningHours(Time openingHours) {
        this.openingHours = openingHours;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cellNumber=" + cellNumber +
                ", openingHours=" + openingHours +
                ", workingDays='" + workingDays + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
