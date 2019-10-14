package edu.nhs.wsaams.service;

import edu.nhs.wsaams.entity.Grade;

import java.util.List;

public interface GradeService extends Service<Grade> {

    List<Grade> getByEmployeeId(String id);

    String updateEmployeeId(String id, String employeeId);
}
