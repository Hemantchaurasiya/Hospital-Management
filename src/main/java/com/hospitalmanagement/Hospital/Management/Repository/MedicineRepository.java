package com.hospitalmanagement.Hospital.Management.Repository;

import com.hospitalmanagement.Hospital.Management.Entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
