package service.impl;

import co.edu.cesdega.Service.StudentService;
import co.edu.cesde.ga.models.Student;
import co.edu.cesde.ga.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        if (isInvalidStudent(student)|| studentRepository.existsByDocumentNumber(student.getDocumentNumber())){
            return null;
        }
        return studentRepository.create(student);
    }

    @Override
    public boolean delete(Long studentId) {
        if (studentRepository.findById(studentId) != null) {
            studentRepository.delete(studentId);
            return true;
        }
        return false;
    }
    @Override
    public boolean update(Student studentUpdate) {
        if (studentUpdate != null && studentRepository.findById(studentUpdate.getStudentId()) != null) {
            studentRepository.update(studentUpdate);
            return true;
        }
        return false;
    }

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return studentRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }
    private boolean isInvalidStudent(Student student){
        return student == null
                ||!isNotBlank(student.getCode())
                ||!isNotBlank(student.getDocumentNumber())
                ||!isNotBlank(student.getFirstName())
                ||!isNotBlank(student.getLastName())
                ||!isNotBlank(student.getStatus())
                ||!isNotBlank(student.getBirthDate());
    }

    private boolean isNotBlank(String values){
        return values != null && !values.isBlank();
    }

    @Override
    public boolean existsById(Long StudentId) {
        return false;
    }
}