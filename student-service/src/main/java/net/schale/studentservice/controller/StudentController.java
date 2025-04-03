package net.schale.studentservice.controller;
import lombok.AllArgsConstructor;
import net.schale.studentservice.dto.StudentDTO;
import net.schale.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/students")
public class StudentController {
    private StudentService studentService;
    //create STUDENT REST API
    @PostMapping
    public ResponseEntity<StudentDTO> savedStudent(@RequestBody StudentDTO studentDTO){
        StudentDTO savedStudent = studentService.saveStudent(studentDTO);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    @GetMapping("{stud-code}")
    public ResponseEntity<StudentDTO> getDept(@PathVariable("stud-code") String studCode){
        StudentDTO studentDTO = studentService.getByStudCode(studCode);
        return new ResponseEntity<>(studentDTO,HttpStatus.OK);
    }
}
