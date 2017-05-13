package com.ador.medicalexpress;

/**
 * Created by ADOR'S Lappy on 11-May-17.
 */

public class BloodRequest {

    private String name;
    private String blood_group;
    private String place;
    private String contact;
    private String date;


    public BloodRequest(String name, String blood_group, String place, String contact, String date) {
        this.setName(name);
        this.setBlood_group(blood_group);
        this.setPlace(place);
        this.setContact(contact);
        this.setDate(date);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
