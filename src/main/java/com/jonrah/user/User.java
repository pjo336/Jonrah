package com.jonrah.user;

import com.jonrah.entity.EntityInterface;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User implements EntityInterface {

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public User(String userName, String password, String firstName, String lastName, UserGender gender, String email, UserType type) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        this.setUserType(type);
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "gender")
    private int gender;

    @Column(name = "email")
    private String email;
    
    @Column(name = "user_type")
    private String userType;
    
    public long getId() {
        return id;
    }
   
    public void setId(long id) {
            this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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