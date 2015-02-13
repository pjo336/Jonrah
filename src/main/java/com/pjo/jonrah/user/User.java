package com.pjo.jonrah.user;

import com.pjo.jonrah.entity.JonrahEntity;
import com.pjo.jonrah.trustt.comment.IssueComment;
import com.pjo.jonrah.trustt.issue.Issue;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "JONRAH_USER")
public class User implements JonrahEntity {

    public User() {}

    public User(String userName, String password, String firstName, String lastName, UserGender gender, String email, UserType type) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
        this.setUserType(type);
    }

    public User(String userName, String password, String firstName, String lastName, UserGender gender, String email) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setGender(gender);
        this.setEmail(email);
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

    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateAdded;

    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateModified;

    /**
     * Created bugs
     */
    @OneToMany(mappedBy="createdById")
    private Set<Issue> createdIssues;

    /**
     * Modified bugs
     */
    @OneToMany(mappedBy="lastModifiedById")
    private Set<Issue> modifiedIssues;

    /**
     * Owned bugs
     */
    @OneToMany(mappedBy="ownerId")
    private Set<Issue> ownedIssues;

    /**
     * Assigned bugs
     */
    @OneToMany(mappedBy="assignedToId")
    private Set<Issue> assignedIssues;

    /**
     * Comments
     */
    @OneToMany(mappedBy="commenter")
    private Set<IssueComment> comments;

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

    public String getDateAdded() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dateAdded);
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

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
}
