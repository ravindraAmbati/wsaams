package edu.nhs.wsaams.service;

import edu.nhs.wsaams.entity.Loginuser;

import java.util.List;

public interface LoginService extends Service<Loginuser>{

    String validate(String username,String password);

    Loginuser getByUsername(String username);

    List<Loginuser> getByLastAttemptStatus(String lastAttemptStatus);

    String delete(String id);

    String updatePassword(String id,String password);
}
