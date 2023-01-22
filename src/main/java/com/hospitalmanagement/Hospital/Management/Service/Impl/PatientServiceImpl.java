package com.hospitalmanagement.Hospital.Management.Service.Impl;

import com.hospitalmanagement.Hospital.Management.Dto.PatientDto;
import com.hospitalmanagement.Hospital.Management.Entity.Patient;
import com.hospitalmanagement.Hospital.Management.Exception.ResourceNotFoundException;
import com.hospitalmanagement.Hospital.Management.Repository.PatientRepository;
import com.hospitalmanagement.Hospital.Management.Service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PatientDto getPatientById(Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Patients","id",id));
        return modelMapper.map(patient,PatientDto.class);
    }
    @Override
    public List<PatientDto> getPatientByName(String name) {
        List<Patient> patients = patientRepository.findByFirstname(name);
        List<PatientDto> patientDtoList = patients.stream()
                .map(patient -> modelMapper.map(patient,PatientDto.class))
                .collect(Collectors.toList());
        return patientDtoList;
    }
    @Override
    public PatientDto getPatientByPhone(String phone) {
        Patient patient = patientRepository.findByPhone(phone);
        return modelMapper.map(patient,PatientDto.class);
    }
    @Override
    public PatientDto getPatientByEmail(String email) {
        Patient patient = patientRepository.findByEmail(email);
        return modelMapper.map(patient,PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtoList = patients.stream()
                .map(patient -> modelMapper.map(patient,PatientDto.class))
                .collect(Collectors.toList());
        return patientDtoList;
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Doctor","id",id));
        patient.setAddress(patientDto.getAddress());
        patient.setAge(patientDto.getAge());
        patient.setImage(patientDto.getImage());
        patient.setWeight(patientDto.getWeight());
        patient.setHeight(patientDto.getHeight());
        patient.setBloodGroup(patientDto.getBloodGroup());
        patientRepository.save(patient);
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public void deletePatient(Integer id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Patients","id",id));
        patientRepository.delete(patient);
    }
}
