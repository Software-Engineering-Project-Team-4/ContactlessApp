package com.attendance.contactless;

public class Modal {

    // variables for our Student,
    private String firstName;
    private String lastName;
    private int attend;
    private int studentID;
    private String professor;
    private int id;

    //getter and setter methods
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getStudentID() {return studentID; }

    public void setStudentID(int StudentID) { this.studentID = StudentID; }

    public int getAttend() {
        return attend;
    }

    public void setAttend(int attend) {
        this.attend = attend;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public Modal(String firstName, String lastName, int studentID, int attend, String professor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID =studentID;
        this.attend = attend;
        this.professor = professor;
    }
}
