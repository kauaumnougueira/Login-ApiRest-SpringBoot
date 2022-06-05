package KauaNog.ApiRestLogin.service;

import KauaNog.ApiRestLogin.model.Userss;

public interface UserService {
    
    Userss findByEmail(String email);

    void insert(Userss user);

    void update(String email, Userss user);

    void delete(String email);

}
