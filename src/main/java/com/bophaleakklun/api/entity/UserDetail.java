package com.bophaleakklun.api.entity;

import java.sql.Date;

import com.bophaleakklun.api.utils.Global;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity(name="tblUser")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

    // @OneToOne(cascade=CascadeType.ALL)
    // private Address address;

    private Date dateOfBirth;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Global.UserType userType;
}
