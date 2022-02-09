package com.app.config.system_data;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class UserDetailsAuth implements Serializable {

    String name;
    String lastName;
    String israeliIdNumber;

    DateOfBirth dateOfBirth;

    String mail;
    String preFix;
    String suffix;
    String password;

    UserType userType;

    String presentedByID;

    public UserDetailsAuth(){

    }

    public UserDetailsAuth(String name, String lastName, String israeliIdNumber, DateOfBirth dateOfBirth, String mail, String preFix, String suffix, String password, UserType userType, String presentedByID) {
        this.name = name;
        this.lastName = lastName;
        this.israeliIdNumber = israeliIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.mail = mail;
        this.preFix = preFix;
        this.suffix = suffix;
        this.password = password;
        this.userType = userType;
        this.presentedByID = presentedByID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsraeliIdNumber() {
        return israeliIdNumber;
    }

    public void setIsraeliIdNumber(String israeliIdNumber) {
        this.israeliIdNumber = israeliIdNumber;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPreFix() {
        return preFix;
    }

    public void setPreFix(String preFix) {
        this.preFix = preFix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPresentedByID() {
        return presentedByID;
    }

    public void setPresentedByID(String presentedByID) {
        this.presentedByID = presentedByID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
