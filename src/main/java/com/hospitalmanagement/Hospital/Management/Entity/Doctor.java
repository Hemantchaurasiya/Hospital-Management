package com.hospitalmanagement.Hospital.Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor extends User{
    private int age;
    private String image;
    private String department;
    private String specialist;
    private String education;
}
