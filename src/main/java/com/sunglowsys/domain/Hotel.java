package com.sunglowsys.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String type;
    private String mobile;
    private String email;

    public Hotel() {
    }

    public Hotel(String code, String name, String type, String mobile, String email) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.mobile = mobile;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id) && Objects.equals(code, hotel.code) && Objects.equals(name, hotel.name) && Objects.equals(type, hotel.type) && Objects.equals(mobile, hotel.mobile) && Objects.equals(email, hotel.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, type, mobile, email);
    }
}
