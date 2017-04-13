package org.kitpes.entity;

import java.util.Date;

/**
 * Created by mac on 11.04.17.
 */
public class User {
    private String email;
    private String password;

    /* fields below are optional */
    private String firstName;
    private String lastName;
    private Date birthday;
    private String number; // phone number

    public User(String email,
                String password,
                String firstName,
                String lastName,
                Date birthday,
                String number,
                String country,
                String city) {
        this.email = email;
        this.password = password;
        this.firstName = null;
        this.lastName = null;
        this.birthday = null;
        this.number = null;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) { this.birthday = birthday; }

    public String getNumber() { return number; }

    public void setNumber(String number) { this.number = number; }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", number='" + number + '\'' +
                '}';
    }
}
