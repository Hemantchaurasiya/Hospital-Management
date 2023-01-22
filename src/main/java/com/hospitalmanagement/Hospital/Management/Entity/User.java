package com.hospitalmanagement.Hospital.Management.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;

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

    @Column(name = "role" ,nullable = false)
    private String role;

    private boolean activate = false;
}
