package net.schale.studentservice.service.impl;
import lombok.AllArgsConstructor;
import net.schale.studentservice.dto.StudentDTO;
import net.schale.studentservice.entity.Student;
import net.schale.studentservice.repository.StudentRepo;
import net.schale.studentservice.service.StudentService;
import org.springframework.stereotype.Service;
@Service @AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO){
        //Convert studDTO to studJPA Entity
        Student student = new Student(
                studentDTO.getId(),
                studentDTO.getStudFName(),
                studentDTO.getStudLName(),
                studentDTO.getStudDescription(),
                studentDTO.getStudEmail(),
                studentDTO.getStudCode()
        );
        //convertJPAtoDEPTDTO
        Student savedStudent = studentRepo.save(student);
        StudentDTO savedStudentDTO = new StudentDTO(
                savedStudent.getId(),
                savedStudent.getStudFName(),
                savedStudent.getStudLName(),
                savedStudent.getStudDescription(),
                savedStudent.getStudEmail(),
                savedStudent.getStudCode()
        );
        return savedStudentDTO;
    }

    @Override
    public StudentDTO getByStudCode(String studCode) {
        Student student = studentRepo.findByStudCode(studCode);
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getStudFName(),
                student.getStudLName(),
                student.getStudDescription(),
                student.getStudEmail(),
                student.getStudCode()
        );
        return studentDTO;
    }
}
