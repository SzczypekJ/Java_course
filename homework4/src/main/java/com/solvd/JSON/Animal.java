package com.solvd.JSON;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Animal {
    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Animal() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
