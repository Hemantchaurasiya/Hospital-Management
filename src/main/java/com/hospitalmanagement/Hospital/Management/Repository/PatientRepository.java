package com.hospitalmanagement.Hospital.Management.Repository;

import com.hospitalmanagement.Hospital.Management.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
