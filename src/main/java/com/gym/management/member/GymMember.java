package com.gym.management.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gym_members")
public class GymMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String membershipType;

    protected GymMember() {
    }

    public GymMember(String name, String email, String phone, String membershipType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipType = membershipType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void update(String name, String email, String phone, String membershipType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipType = membershipType;
    }
}
