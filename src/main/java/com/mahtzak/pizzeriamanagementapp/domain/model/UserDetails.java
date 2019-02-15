package com.mahtzak.pizzeriamanagementapp.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String address;
    @NotNull
    @Size(min=7)
    @Pattern(regexp = "[0-9]+")
    @Column(name="phone_number")
    private String phoneNumber;
    @NotNull
    @Column(name="first_name")
    @Size(min=3)
    private String firstName;
    @NotNull
    @Size(min=2)
    @Column(name="last_name")
    private String lastName;
    private int bonusPoints;
    @Column(name="pay_per_hour")
    private Double payPerHour;

    @OneToOne(mappedBy = "userDetails")
    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void setBonusPoints(int bonusPoints) {
        this.bonusPoints = bonusPoints;
    }

    public Double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(Double payPerHour) {
        this.payPerHour = payPerHour;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
