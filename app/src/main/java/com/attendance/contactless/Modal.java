package com.attendance.contactless;

public class Modal {

    // variables for our Student,
    private String firstName;
    private String lastName;
    private int attend;
    private String professor;
    private String studentID;
    private int id;
    private String professorID;
    private String pin;

    //getter and setter methods
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getProfessorID() {
        return professorID;
    }

    public void setProfessorID(String professorID) {
        this.professorID = professorID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

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
    public Modal(String firstName, String lastName, int attend, String professor,String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.attend = attend;
        this.professor = professor;
        this.studentID = studentID;
    }
    public Modal(String firstName, String lastName, String professorID, String pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.professorID = professorID;
        this.pin = pin;
    }
    public Modal (String pin){
        this.pin = pin;
    }
}
