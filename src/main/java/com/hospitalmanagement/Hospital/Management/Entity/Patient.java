package com.hospitalmanagement.Hospital.Management.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient extends User{
    private String image;
    private float height;
    private float weight;


    @OneToMany
    private List<Medicine> medicines;
}
