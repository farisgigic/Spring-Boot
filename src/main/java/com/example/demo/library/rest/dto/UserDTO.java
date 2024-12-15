package com.example.demo.library.rest.dto;

import com.example.demo.library.core.model.User;
import com.example.demo.library.core.model.enums.UserType;
import java.util.Date;

public class UserDTO {
    private String id;
    private String name;
    private String username;
    private UserType userType;
    private String email;
    private Date createdAt;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getFirstName() + " " + user.getLastName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.userType = user.getUserType();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
