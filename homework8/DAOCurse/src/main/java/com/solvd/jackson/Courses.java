package com.solvd.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE)
public class Courses {
    @JsonProperty("Course")
    private List<Course> courseList;

    public Courses(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Courses() {}

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return courseList != null ? courseList.toString() : "null";
    }
}