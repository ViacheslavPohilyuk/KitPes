package org.kitpes.entity;

import java.sql.Time;

/**
 * Created by mac on 11.04.17.
 */
public class Organization {
    private Long id;
    private String name;
    private String address;
    private Long cellNumber;
    private Time openingHours;
    private String workingDays;
    private String description;

    public Organization() {
    }

    public Organization(String name,
                        String address,
                        Long cellNumber,
                        Time openingHours,
                        String workingDays,
                        String description) {
        this(null, name, address, cellNumber, openingHours, workingDays, description);
    }

    public Organization(
            Long id,
            String name,
            String address,
            Long cellNumber,
            Time openingHours,
            String workingDays,
            String description) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellNumber = cellNumber;
        this.openingHours = openingHours;
        this.workingDays = workingDays;
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

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cellNumber=" + cellNumber +
                ", openingHours=" + openingHours +
                ", workingDays='" + workingDays + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
