package com.example.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private List<Employment> employments;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Employment> getEmployments() {
    }
}

