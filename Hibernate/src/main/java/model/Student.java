package model;

import javax.persistence.*;


@Entity //It tells that this class is representing a database
@Table (name = "students") //here we are giving name of the table if table does not exist in db it will create
public class Student {
    @Id //Tells that each data should be unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)//works as autoincrement
    private  int id;
    @Column(name = "student_name")
    private  String name;
    @Column(name = "student_age")
    private int age;

    //default Constructor
    public Student() {
    }

    //parameterized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Getter and Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
