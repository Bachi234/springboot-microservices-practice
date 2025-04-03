package net.schale.departmentservice.service.impl;
import lombok.AllArgsConstructor;
import net.schale.departmentservice.dto.DepartmentDTO;
import net.schale.departmentservice.entity.Department;
import net.schale.departmentservice.repository.DepartmentRepo;
import net.schale.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepo departmentRepo;
    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        //convert deptDTO to deptJPA Entity
        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDeptName(),
                departmentDTO.getDeptDescription(),
                departmentDTO.getDeptCode()
        );
        //convert JPA to deptDTO
        Department savedDepartment = departmentRepo.save(department);
        DepartmentDTO savedDepartmentDTO = new DepartmentDTO(
                savedDepartment.getId(),
                savedDepartment.getDeptName(),
                savedDepartment.getDeptDescription(),
                savedDepartment.getDeptCode()
        );
        return savedDepartmentDTO;
    }
    @Override
    public DepartmentDTO getByDeptCode(String deptCode) {
        Department department = departmentRepo.findByDeptCode(deptCode);
        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getDeptName(),
                department.getDeptDescription(),
                department.getDeptCode()
        );
        return departmentDTO;
    }
}
