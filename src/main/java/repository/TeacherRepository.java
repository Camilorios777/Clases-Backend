package repository;

import co.edu.cesde.ga.models.Teacher;

import java.util.List;

public interface TeacherRepository {
    Teacher create(Teacher teacher);

    boolean delete(Long teacherId);

    boolean update(Teacher teacherUpdate);

    Teacher findById(Long id);

    List<Teacher> findAll();

    boolean existsByDocumentNumber(String documentNumber);

    Teacher findByDocumentNumber(String documentNumber);
}