package com.hospitalmanagement.Hospital.Management.Service;

import com.hospitalmanagement.Hospital.Management.Dto.AdminDto;

public interface AdminService {
    AdminDto getAdminById(Integer id);
    AdminDto updateAdmin(AdminDto adminDto,Integer id);
    void deleteAdmin(Integer id);
}
