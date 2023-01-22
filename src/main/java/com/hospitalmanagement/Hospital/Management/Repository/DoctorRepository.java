package com.hospitalmanagement.Hospital.Management.Repository;

import com.hospitalmanagement.Hospital.Management.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
