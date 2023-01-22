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
    public DoctorDto registerDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto,Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor,DoctorDto.class);
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Integer id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor","id",id));
        doctor.setUserid(doctor.getUserid());
        if (doctorDto.getFirstname()!=null){
            doctor.setFirstname(doctorDto.getFirstname());
        }
        if(doctorDto.getLastname()!=null){
            doctor.setLastname(doctorDto.getLastname());
        }
        if (doctorDto.getEmail()!=null){
            doctor.setEmail(doctorDto.getEmail());
        }
        if (doctorDto.getPhone()!=null){
            doctor.setPhone(doctorDto.getPhone());
        }
        doctor.setAge(doctorDto.getAge());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setImage(doctorDto.getImage());
        doctor.setDepartment(doctorDto.getDepartment());
        doctor.setSpecialist(doctorDto.getSpecialist());
        doctor.setEducation(doctorDto.getEducation());

        doctorRepository.save(doctor);
        return modelMapper.map(doctor,DoctorDto.class);
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
