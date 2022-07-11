package edu.miu.eregister.service.impl;

import edu.miu.eregister.dto.StudentRequest;
import edu.miu.eregister.model.Student;
import edu.miu.eregister.repository.StudentRepository;
import edu.miu.eregister.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student add(StudentRequest studentRequest) {
        Student newStudent = buildStudent(studentRequest);
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public Optional<Student> get(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student update(StudentRequest studentRequest) {
        Student newStudent = buildStudent(studentRequest);
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public boolean delete(Integer studentId) {
        if(studentRepository.findById(studentId).isPresent()){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }

    private final Student buildStudent(StudentRequest studentRequest) {
        return Student.build(null, studentRequest.getStudentNumber(),
                studentRequest.getFirstName(), studentRequest.getMiddleName(),
                studentRequest.getLastName(), studentRequest.getCgpa(),
                studentRequest.isInternational());
    }

}
