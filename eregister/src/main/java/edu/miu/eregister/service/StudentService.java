package edu.miu.eregister.service;

import edu.miu.eregister.dto.StudentRequest;
import edu.miu.eregister.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addNewStudent(StudentRequest studentRequest);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Integer studentId);
    Student updateStudent(StudentRequest studentRequest);
    boolean deleteStudentById(Integer studentId);
}
