package com.hospitalmanagement.Hospital.Management.Service.Impl;

import com.hospitalmanagement.Hospital.Management.Dto.DoctorDto;
import com.hospitalmanagement.Hospital.Management.Entity.Doctor;
import com.hospitalmanagement.Hospital.Management.Entity.User;
import com.hospitalmanagement.Hospital.Management.Exception.ResourceNotFoundException;
import com.hospitalmanagement.Hospital.Management.Repository.DoctorRepository;
import com.hospitalmanagement.Hospital.Management.Repository.UserRepository;
import com.hospitalmanagement.Hospital.Management.Service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","id",id));
        if (!user.getRole().equals("DOCTOR")){
            return null;
        }
        Doctor newDoctor = modelMapper.map(doctorDto, Doctor.class);
        newDoctor.setUserid(user.getUserid());
        System.out.print("****************************");
        System.out.print(user.getUserid());
        newDoctor.setFirstname(user.getFirstname());
        newDoctor.setLastname(user.getLastname());
        newDoctor.setEmail(user.getEmail());
        newDoctor.setPassword(user.getPassword());
        newDoctor.setPhone(user.getPhone());
        newDoctor.setRole(user.getRole());
        doctorRepository.save(newDoctor);
        return modelMapper.map(newDoctor,DoctorDto.class);
    }

    @Override
    public DoctorDto getDoctorById(Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor","id",id));
        return modelMapper.map(doctor,DoctorDto.class);
    }

    @Override
    public DoctorDto getDoctorByName(String name) {
        return null;
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDto> doctorDtoList = doctors.stream()
                .map(doctor -> modelMapper.map(doctor,DoctorDto.class))
                .collect(Collectors.toList());
        return doctorDtoList;
    }

    @Override
    public void deleteDoctor(Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor","id",id));
        doctorRepository.delete(doctor);
    }
}
