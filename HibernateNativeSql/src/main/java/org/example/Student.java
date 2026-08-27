package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Create database if not exists University;
//Use University;
//create table student(
//        id int primary key,
//        name varchar(100),
//course varchar(100),
//status varchar(50),
//registration_date date
//);

//insert into student values
//        (1,'John','Java','active','2026-10-10');


@Entity
@Table(name = "student")
public class Student {

    @Id
    private  int id;
    private  String name;
    private String course;
    private String status;
    private String registration_date;

    public  Student(){}

    public Student(int id, String name, String course, String status, String registration_date) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.status = status;
        this.registration_date = registration_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }
}
