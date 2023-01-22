package com.hospitalmanagement.Hospital.Management.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto extends UserDto{
    private String address;
    private int age;
    private String image;
    private float height;
    private float weight;
    private String bloodGroup;
}
