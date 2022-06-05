package KauaNog.ApiRestLogin.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KauaNog.ApiRestLogin.model.Userss;
import KauaNog.ApiRestLogin.model.UserRepository;
import KauaNog.ApiRestLogin.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public Userss findByEmail(String email) {
        //retorna o email
        Optional<Userss> user = userRepository.findById(email);
        //testa existencia e retorna
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    @Override
    public void insert(Userss user) {
        //salva user no bd
        saveUser(user);
    }

    @Override
    public void update(String email, Userss user) {
        //atualiza a partir do email
        Optional<Userss> userBanco = userRepository.findById(email);
        if(userBanco.isPresent()){
            saveUser(user);
        }
    }

    @Override
    public void delete(String email) {
        //deleta via email
        userRepository.deleteById(email);
    }

    private void saveUser(Userss user){
        //salva users via email
        String email = user.getEmail();
        user = userRepository.findById(email).orElseGet(() -> {
            Userss newUser = null;
            return newUser;
        });
    }
}
