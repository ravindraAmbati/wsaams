package edu.nhs.wsaams.controller;

import edu.nhs.wsaams.entity.Loginuser;

import java.util.List;

public interface LoginController extends Controller<Loginuser> {

    String isValidUser(Loginuser loginuser);

    List<Loginuser> viewByLastAttemptStatus(Loginuser loginuser);

    String updatePassword(Loginuser loginuser);

    Loginuser viewByUsername(Loginuser loginuser);
}
