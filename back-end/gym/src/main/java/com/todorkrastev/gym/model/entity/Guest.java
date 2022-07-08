package com.todorkrastev.gym.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "guests")
public class Guest extends BaseEntity {

    private String name;
    private String email;
    private String phoneNumber;
    private LocalDateTime trialDay;

    public Guest() {
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Column(name = "trial_day", nullable = false)
    public LocalDateTime getTrialDay() {
        return trialDay;
    }

    public void setTrialDay(LocalDateTime trialDay) {
        this.trialDay = trialDay;
    }
}
