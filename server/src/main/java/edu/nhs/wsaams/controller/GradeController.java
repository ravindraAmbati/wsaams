package edu.nhs.wsaams.controller;

import edu.nhs.wsaams.entity.Grade;

import java.util.List;

public interface GradeController extends Controller<Grade>{

    List<Grade> viewByEmployeeId(String empId);

    String updateEmployeeId(Grade grade);
}
