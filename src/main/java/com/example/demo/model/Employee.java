package com.example.demo.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Employee {

    @SerializedName("_id")
    private String id;

    @SerializedName("_rev")
    private String rev;

    private String name;
    private String designation;
    private String department;
    private List<String> skills;
    private int experience;

    // 🔹 Default constructor (required for serialization/deserialization)
    public Employee() {
    }

    // 🔹 Constructor for test or manual creation
    public Employee(String id, String name, String designation, String department) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
    }

    // ✅ Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
