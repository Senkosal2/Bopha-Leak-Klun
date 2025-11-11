package com.bophaleakklun.api.dto;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.bophaleakklun.api.utils.Global;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDetailDTO {
    private int id;

    @NotNull(message = "Username cannot be empty!")
    private String username;

    @NotNull(message = "Password cannot be empty!")
    @Size(min = 8, message = "Password must be at least 8")
    private String password;

    // @JsonProperty("address")
    // private AddressDTO addressDTO;

    @JsonFormat(pattern = "dd-MM-yyyy") // day-month-year
    private Date dateOfBirth;

    @Email(message = "Invalid email")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number must be 10 digits")
    @NotNull(message = "Phone number cannot be empty!")
    private String phoneNumber;

    // @NotNull
    // private Global.UserType userType;
}
