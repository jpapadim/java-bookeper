package com.agileactors.bookeeper.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Publisher {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "name {error.not.blank}")
    @UniqueElements(message = "name {error.not.unique}")
    @NaturalId()
    private String name;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "username {error.not.blank}")
    @UniqueElements(message = "username {error.not.unique}")
    private String username;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "password {error.not.blank}")
    private String password;

    @Column(name="last_update", nullable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    //TODO add contact information for publisher?


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getDate() {
        return date;
    }
}
