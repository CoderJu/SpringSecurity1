package com.eleven.model;

/**
 * Created by User on 2017/11/22.
 */

/**
 *
 */
public class UserToProfileid {

    private Integer id;
    private User userid;
    private Profileid profileid;

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Profileid getProfileid() {
        return profileid;
    }

    public void setProfileid(Profileid profileid) {
        this.profileid = profileid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
