package com.hospitalmanagement.Hospital.Management.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medicines")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;


    @ManyToOne()
    private Patient patient;
}
