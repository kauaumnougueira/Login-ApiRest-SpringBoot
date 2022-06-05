package KauaNog.ApiRestLogin.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KauaNog.ApiRestLogin.model.User;
import KauaNog.ApiRestLogin.model.UserRepository;
import KauaNog.ApiRestLogin.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        //retorna o email
        Optional<User> user = userRepository.findById(email);
        //testa existencia e retorna
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    @Override
    public void insert(User user) {
        //salva user no bd
        saveUser(user);
    }

    @Override
    public void update(String email, User user) {
        //atualiza a partir do email
        Optional<User> userBanco = userRepository.findById(email);
        if(userBanco.isPresent()){
            saveUser(user);
        }
    }

    @Override
    public void delete(String email) {
        //deleta via email
        userRepository.deleteById(email);
    }

    private void saveUser(User user){
        //salva users via email
        String email = user.getEmail();
        user = userRepository.findById(email).orElseGet(() -> {
            User newUser = null;
            return newUser;
        });
    }
}
