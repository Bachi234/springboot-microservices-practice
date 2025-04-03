package net.schale.departmentservice.repository;
import net.schale.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
    Department findByDeptCode(String deptCode);
}
