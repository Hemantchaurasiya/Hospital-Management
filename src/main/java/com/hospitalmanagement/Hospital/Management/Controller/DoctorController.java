package com.hospitalmanagement.Hospital.Management.Controller;

import com.hospitalmanagement.Hospital.Management.Dto.DoctorDto;
import com.hospitalmanagement.Hospital.Management.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> getDoctorById(@PathVariable("doctorId") Integer doctorId){
        DoctorDto doctorDto = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<DoctorDto>(doctorDto,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> doctorDtoList = doctorService.getAllDoctors();
        return new ResponseEntity<List<DoctorDto>>(doctorDtoList,HttpStatus.OK);
    }
    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDto> updateDoctor(
            @RequestBody DoctorDto doctorDto,
            @PathVariable("doctorId") Integer id
            ){
        System.out.print("************************");
        System.out.print(id);
        DoctorDto doctor = doctorService.updateDoctor(doctorDto,id);
        return new ResponseEntity<DoctorDto>(doctor,HttpStatus.OK);
    }
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") Integer id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<String>("doctor is deleted", HttpStatus.OK);
    }

}
