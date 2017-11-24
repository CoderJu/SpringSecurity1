package com.eleven.model;

/**
 * Created by User on 2017/11/22.
 */
public enum ProfileType {
    USER("USER"),
    ADMIN("ADMIN"),
    DBA("DBA");

    private String type;

    ProfileType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.type;
    }
    public String getName(){
        return this.name();
    }
}
