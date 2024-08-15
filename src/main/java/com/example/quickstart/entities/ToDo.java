package com.example.quickstart.entities;

// import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name = "toDo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // private String firstName;

    // private String lastName;

    // private String dateOfBirth;

    private String activity;

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.
    private ToDo() {
    }

    public ToDo(String activity) { // String firstName, String lastName, String dateOfBirth
        // this.firstName = firstName;
        // this.lastName = lastName;
        // this.dateOfBirth = dateOfBirth;
        this.activity = activity;
    }

    public Integer getId() {
        return this.id;
    }

    public String getActivity() {
        return this.activity;
    }
    // public String getFirstName() {
    // return this.firstName;
    // }

    // public String getLastName() {
    // return this.lastName;
    // }

    // public String getDateOfBirth() {
    // return this.dateOfBirth;
    // }
}