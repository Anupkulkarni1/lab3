package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    public String getPassword() {
        return password;
    }

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;


    protected user() {

    }

    public user(String email,
                String firstname,
                String lastname,
                String password,
                String gender,
                String dob
    ) {

        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.gender = gender;
        this.dob = dob;


    }

    public int getId() { return this.id; }
    public String getEmail() { return this.email; }
    public String getFirstName() { return this.firstname; }
    public String getLastName() { return this.lastname; }
    public String getGender() { return this.gender; }
    public String getDob() { return this.dob; }


    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {

        return "user: " + this.firstname + " " + this.lastname;
    }
}