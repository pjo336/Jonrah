package com.bt.user;

import com.bt.entity.EntityInterface;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User implements EntityInterface {

    public User() {}

    public User(String firstName, String lastName, UserGender gender, String email, UserType type) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        this.setUserType(type);
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "gender")
    private int gender;

    @Column(name = "email")
    private String email;
    
    @Column(name = "user_type")
    private int userType;
    
    public int getId() {
        return id;
    }
   
    public void setId(int id) {
            this.id = id;
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

    public UserGender getGender() {
        return UserGender.getGender(this.gender);
    }

    public void setGender(UserGender gender) {
        this.gender = gender.value();
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public UserType getUserType() {
        return UserType.getUserType(userType);
    }
    
    public void setUserType(UserType userType) {
        this.userType = userType.value();
    }
}