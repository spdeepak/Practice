package com.movie.ticketing.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cast implements Common {

    private long id;

    private String firstName;

    private String lastName;

    private Type type;

    public Cast() {

    }

    public Cast(String firstName, String lastName, Type type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    @Enumerated(value = EnumType.STRING)
    public Type getType() {
        return type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
