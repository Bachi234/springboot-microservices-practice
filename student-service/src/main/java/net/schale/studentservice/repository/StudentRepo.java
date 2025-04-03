package net.schale.studentservice.repository;

import net.schale.studentservice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByStudCode(String studCode);
}
