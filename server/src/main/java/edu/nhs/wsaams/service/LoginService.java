package edu.nhs.wsaams.service;

import edu.nhs.wsaams.entity.Loginuser;

import java.util.List;

public interface LoginService {

    String validate(Loginuser loginUser);

    List<Loginuser> getAll();

    String save(Loginuser loginUser);

    Loginuser getById(Loginuser loginUser);

    Loginuser getByUsername(Loginuser loginUser);

    List<Loginuser> getByStatus(Loginuser loginUser);

    List<Loginuser> getByLastAttemptStatus(Loginuser loginUser);

    String delete(Loginuser loginUser);

    String updatePassword(Loginuser loginUser);

    String updateStatus(Loginuser loginUser);

    String deleteAll();
}
