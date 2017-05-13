package org.kitpes.model;

import java.sql.Time;

/**
 * Created by mac on 11.04.17.
 */
public class Organization {
    private Long id;
    private String name;
    private String address;
    private Long cellNumber;
    private Time oppeningHours;
    private String workingDays;

    public Organization() {
    }

    public Organization(String name,
                        String address,
                        Long cellNumber,
                        Time oppeningHours,
                        String workingDays ) {
        this(null, name, address, cellNumber, oppeningHours, workingDays);
    }

    public Organization(
            Long id,
            String name,
            String address,
            Long cellNumber,
            Time oppeningHours,
            String workingDays) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellNumber = cellNumber;
        this.oppeningHours = oppeningHours;
        this.workingDays = workingDays;
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

    public Time getOppeningHours() {
        return oppeningHours;
    }

    public void setOppeningHours(Time oppeningHours) {
        this.oppeningHours = oppeningHours;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cellNumber=" + cellNumber +
                ", oppeningHours=" + oppeningHours +
                ", workingDays='" + workingDays + '\'' +
                '}';
    }

}
