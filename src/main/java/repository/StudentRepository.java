package co.edu.cesde.ga.repository;

import co.edu.cesde.ga.models.Student;

import java.util.List;

public interface StudentRepository {

    Student create(Student student);
    boolean delate (Long studentId);
    boolean update(Student studentUpdate);
    Student findById(Long studentId);
    boolean findByDocumentNumber(String documentNumber);

    List<Student> findAll();

    boolean existById(Long studentId);

}