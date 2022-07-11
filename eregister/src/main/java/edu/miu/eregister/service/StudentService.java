package edu.miu.eregister.service;

import edu.miu.eregister.dto.StudentRequest;
import edu.miu.eregister.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student add(StudentRequest studentRequest);
    List<Student> getAll();
    Optional<Student> get(Integer studentId);
    Student update(StudentRequest studentRequest);
    boolean delete(Integer studentId);

}
