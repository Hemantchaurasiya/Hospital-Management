package com.hospitalmanagement.Hospital.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstname" ,nullable = false)
    private String firstname;

    @Column(name = "lastname" ,nullable = false)
    private String lastname;

    @Column(name = "email" ,nullable = false)
    private String email;

    @Column(name = "password" ,nullable = false)
    private String password;

    @Column(name = "phone" ,nullable = false)
    private String phone;

    @Column(name = "address" ,nullable = false)
    private String address;

    @Column(name = "role" ,nullable = false)
    private boolean role;

    private boolean activate = false;
}
