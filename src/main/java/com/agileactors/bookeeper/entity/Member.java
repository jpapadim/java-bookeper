package com.agileactors.bookeeper.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Member {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "username {error.not.blank}")
    @NaturalId
    //TODO use email as username if email is required?
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "password {error.not.blank}")
    private String password;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Email {error.not.blank}")
    @Email(message = "Email {error.not.valid}")
    private String email;

    private String firstname;
    private String lastname;
    private String address;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "phone {error.not.blank}")
    private String phone;

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
