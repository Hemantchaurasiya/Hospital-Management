package com.hospitalmanagement.Hospital.Management.Service;

import com.hospitalmanagement.Hospital.Management.Dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto updateDoctor(DoctorDto doctorDto,Integer id);
    DoctorDto getDoctorById(Integer id);
    DoctorDto getDoctorByName(String name);
    List<DoctorDto> getAllDoctors();
    void deleteDoctor(Integer id);
}
