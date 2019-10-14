package edu.nhs.wsaams.repository;

import edu.nhs.wsaams.entity.Grade;

import java.util.List;

public interface GradeRepository extends Repository<Grade> {

    List<Grade> findByEmployeeId(String employeeId);

    boolean updateEmployeeId(String id, String employeeId);
}
