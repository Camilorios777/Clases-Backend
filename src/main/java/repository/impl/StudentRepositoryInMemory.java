package co.edu.cesde.ga.repository.impl;

import co.edu.cesde.ga.models.Student;
import co.edu.cesde.ga.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private final List<Student> students;
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

        if (existsByDocumentNumber(student.getDocumentNumber())) {
            return null;
        }

        student.setStudentId(nextStudentId++);
        students.add(student);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean existsById(Long studentId) {
        if (studentId == null || studentId<0L) {
            return false;
        }

        for (Student student : students) {
            if (studentId.equals(student.getStudentId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findByDocumentNumber(String documentNumber) {
        if (documentNumber == null || documentNumber.isBlank()) {
            return null;
        }

        for (Student student : students) {
            if (documentNumber.equals(student.getDocumentNumber())) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean update(Student updatedStudent) {
        if (updatedStudent == null || updatedStudent.getStudentId() == null) {
            return false;
        }

        for (Student student : students) {
            if (!student.getStudentId().equals(updatedStudent.getStudentId())
                    && student.getDocumentNumber().equals(updatedStudent.getDocumentNumber())) {
                return false;
            }
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equals(updatedStudent.getStudentId())) {
                students.set(i, updatedStudent);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long studentId) {
        Student student = findById(studentId);
        if (student == null) {
            return false;
        }
        return students.remove(student);
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return findByDocumentNumber(documentNumber) != null;
        if (documentNumber == null|| documentNumber.isBlank()){
            return false;
        }
        for (Student student : students){
            if (student.getDocumentNumber().equals(documentNumber)){
                return student;
            }
        }
        return null;
    }

}