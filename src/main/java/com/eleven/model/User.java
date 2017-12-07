package com.eleven.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/11/21.
 */
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    private String email;
    private String state = State.ACTIVE.getState();

   // private Set<UserToProfileid> userToProfileidHashSet=new HashSet<UserToProfileid>(); //集合的类型为中间的实体类类型

    private Set<Profileid> profileids=new HashSet<Profileid>(); //集合的类型为中间的实体类类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
/*
    public Set<UserToProfileid> getUserToProfileidHashSet() {
        return userToProfileidHashSet;
    }

    public void setUserToProfileidHashSet(Set<UserToProfileid> userToProfileidHashSet) {
        this.userToProfileidHashSet = userToProfileidHashSet;
    }*/

    public Set<Profileid> getProfileids() {
        return profileids;
    }

    public void setProfileids(Set<Profileid> profileids) {
        this.profileids = profileids;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
