package com.hospitalmanagement.Hospital.Management.Repository;

import com.hospitalmanagement.Hospital.Management.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    List<Patient> findByFirstname(String name);
    Patient findByPhone(String phone);
    Patient findByEmail(String email);
}
