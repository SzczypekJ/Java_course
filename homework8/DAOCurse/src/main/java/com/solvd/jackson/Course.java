package com.solvd.jackson;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Course {

    @JsonProperty("Name")
    private  String Name;

    @JsonProperty("Code")
    private String Code;

    @JsonProperty("Numberofpeople")
    private Integer Numberofpeople;

    public Course(String name, String code, Integer numberofpeople) {
        Name = name;
        Code = code;
        Numberofpeople = numberofpeople;
    }

    public Course() {}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public Integer getNumberofpeople() {
        return Numberofpeople;
    }

    public void setNumberofpeople(Integer numberofpeople) {
        Numberofpeople = numberofpeople;
    }

    @Override
    public String toString() {
        return "Course{" +
                "Name='" + Name + '\'' +
                ", Code='" + Code + '\'' +
                ", Numberofpeople=" + Numberofpeople +
                '}';
    }
}
