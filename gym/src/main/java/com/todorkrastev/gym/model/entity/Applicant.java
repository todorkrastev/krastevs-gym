package com.todorkrastev.gym.model.entity;

import com.todorkrastev.gym.model.entity.enums.CityName;
import com.todorkrastev.gym.model.entity.enums.CountryName;
import com.todorkrastev.gym.model.entity.enums.PositionName;

import javax.persistence.*;

@Entity
@Table(name = "applicants")
public class Applicant extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private PositionName positionName;
    private CountryName countryName;
    private CityName cityName;

    public Applicant() {
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone_number", nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Enumerated(EnumType.STRING)
    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Enumerated(EnumType.STRING)
    public CountryName getCountryName() {
        return countryName;
    }

    public void setCountryName(CountryName countryName) {
        this.countryName = countryName;
    }

    @Enumerated(EnumType.STRING)
    public CityName getCityName() {
        return cityName;
    }

    public void setCityName(CityName cityName) {
        this.cityName = cityName;
    }
}
