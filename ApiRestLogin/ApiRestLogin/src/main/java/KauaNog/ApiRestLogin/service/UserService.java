package KauaNog.ApiRestLogin.service;

import KauaNog.ApiRestLogin.model.User;

public interface UserService {
    
    User findByEmail(String email);

    void insert(User user);

    void update(String email, User user);

    void delete(String email);

}
