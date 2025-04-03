package net.schale.departmentservice.controller;
import lombok.AllArgsConstructor;
import net.schale.departmentservice.dto.DepartmentDTO;
import net.schale.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private DepartmentService departmentService;
    //build create dept REST API
    @PostMapping
    public ResponseEntity<DepartmentDTO> savedDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    //GET DEPT REST API
    @GetMapping("{dept-code}")
    public ResponseEntity<DepartmentDTO> getDept(@PathVariable("dept-code") String deptCode){
        DepartmentDTO departmentDTO = departmentService.getByDeptCode(deptCode);
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }
}
