package com.hospitalmanagement.Hospital.Management.Dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto extends UserDto{
    private String address;
    private int age;
    private String image;
    private String department;
    private String specialist;
    private String education;
}
