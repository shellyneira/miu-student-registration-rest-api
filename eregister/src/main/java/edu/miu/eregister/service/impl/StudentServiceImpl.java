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
    public Student addNewStudent(StudentRequest studentRequest) {
        Student newStudent = new Student(null, studentRequest.getStudentNumber(),
                studentRequest.getFirstName(), studentRequest.getMiddleName(),
                studentRequest.getLastName(), studentRequest.getCgpa(),
                studentRequest.isInternational());
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("firstName"));
    }

    @Override
    public Optional<Student> getStudentById(Integer studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest) {
        Student newStudent = new Student(null, studentRequest.getStudentNumber(),
                studentRequest.getFirstName(), studentRequest.getMiddleName(),
                studentRequest.getLastName(), studentRequest.getCgpa(),
                studentRequest.isInternational());
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public boolean deleteStudentById(Integer studentId) {
        if(studentRepository.findById(studentId).isPresent()){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }
}
