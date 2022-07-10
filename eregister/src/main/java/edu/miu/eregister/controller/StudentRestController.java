package edu.miu.eregister.controller;

import edu.miu.eregister.dto.StudentRequest;
import edu.miu.eregister.model.Student;
import edu.miu.eregister.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ={"/eregister/api/v1/student"})
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/list"})
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(value = {"/get/{studentId}"})
    public ResponseEntity<Student> getStudentId(@PathVariable Integer studentId) {
        Optional<Student> student = studentService.getStudentById(studentId);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(value = {"/new"})
    public ResponseEntity<Student> addNewStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(studentService.addNewStudent(studentRequest),
                HttpStatus.CREATED);
    }

    @PutMapping(value = {"/update/{studentId}"})
    public ResponseEntity<Student> updateStudent(@RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(studentRequest));
    }

    @DeleteMapping(value = {"/delete/{studentId}"})
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        boolean isDeleted = studentService.deleteStudentById(studentId);
        return new ResponseEntity<>(isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
