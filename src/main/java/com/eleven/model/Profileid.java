package com.eleven.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 2017/11/22.
 */
public class Profileid {
    private Integer id;
    private String type = ProfileType.USER.getName();
    private Set<UserToProfileid> userToProfileidHashSet=new HashSet<UserToProfileid>(); //集合的类型为中间的实体类类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<UserToProfileid> getUserToProfileidHashSet() {
        return userToProfileidHashSet;
    }

    public void setUserToProfileidHashSet(Set<UserToProfileid> userToProfileidHashSet) {
        this.userToProfileidHashSet = userToProfileidHashSet;
    }

    @Override
    public String toString() {
        return "Profileid{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", userToProfileidHashSet=" + userToProfileidHashSet +
                '}';
    }
}
