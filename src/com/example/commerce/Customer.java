package com.example.commerce;

public class Customer {

    // 고객명,이메일,등급필드
    private String name;
    private String email;
    private String grade;

    public Customer(String name, String email, String grade){
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getGrade() {return grade;}

}
