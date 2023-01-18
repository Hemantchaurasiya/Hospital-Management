package com.hospitalmanagement.Hospital.Management.Service;

import com.hospitalmanagement.Hospital.Management.Dto.MedicineDto;

import java.util.List;

public interface MedicineService {
    MedicineDto saveMedicine(MedicineDto medicineDto);
    MedicineDto getMedicineById(MedicineDto medicineDto);
    List<MedicineDto> getAllMedicines();
    MedicineDto updateMedicine(MedicineDto medicineDto,Integer id);
    void deleteMedicine(Integer id);
}
