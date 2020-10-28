package com.sda.userSda.model;

import com.sda.userSda.utils.Utils;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@Entity
@Table(name = "uzytkownicy")
@NamedQueries({
    @NamedQuery(name = "dateBetween", query = "select u from User u where u.firstName = :name")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "identyfikator")
    private int userId;

    @Size(min = 2, max = 20, message = "Za krótkie imie")
    @Column(name = "imie")
    private String firstName;

    @Size(min = 2, message = "Za krótkie nazwisko")
    @Size(max = 20, message = "Za długie nazwisko")
    @Column(name = "nazwisko")
    private String lastName;

    @Column(name = "data_urodzenia")
    private LocalDate birthDate;

    @Pattern(regexp = "[\\d]{4}-[\\d]{2}-[\\d]{2}", message = "Nieprawidłowa data")
    @Transient
    private String birthDateTemp;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDateTemp() {
        if(birthDate != null) {
            birthDateTemp = birthDate.format(Utils.formatter);
        }
        return birthDateTemp;
    }

    public void setBirthDateTemp(String birthDateTemp) {
        this.birthDateTemp = birthDateTemp;
        try {
            this.birthDate = LocalDate.parse(birthDateTemp, Utils.formatter);
        } catch (DateTimeParseException e) {
            //normal when you choose nothing
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
