package repository.impl;

import co.edu.cesde.ga.models.Student;
import co.edu.cesde.ga.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> students;
    private Long nextStudentId;

    public StudentRepositoryInMemory() {
        this.students = new ArrayList<>();
        this.nextStudentId = 1L;
    }

    @Override
    public Student create(Student student) {

        if (student == null) {
            return null;
        }

        // Validar documento duplicado
        if (existsByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }


        students.add(student);
        return student;
    }


    @Override
    public boolean delete(Long studentId) {

        Student student = findById(studentId);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }

    @Override
    public boolean update(Student studentUpdate) {

        if (studentUpdate == null || studentUpdate.getStudentId() == null) {
            return false;
        }

        Student existing = findById(studentUpdate.getStudentId());

        if (existing == null) {
            return false;
        }
        return true;
    }

    @Override
    public Student findById(Long studentId) {

        if (studentId == null) {
            return null;
        }

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }

        return null;
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return false;
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students); // evita modificar la original
    }

    @Override
    public boolean existById(Long studentId) {
        return findById(studentId)==null;
    }
}