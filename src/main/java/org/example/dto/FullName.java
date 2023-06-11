package org.example.dto;

public class FullName {
    private String name;
    private String lastName;

    public FullName(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    // Getters & setters for fields: name и lastName
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

}
