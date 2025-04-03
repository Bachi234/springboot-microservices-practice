package net.schale.departmentservice.service;
import net.schale.departmentservice.dto.DepartmentDTO;
public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);
    DepartmentDTO getByDeptCode(String code);
}
