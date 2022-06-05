package KauaNog.ApiRestLogin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KauaNog.ApiRestLogin.model.User;
import KauaNog.ApiRestLogin.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("Usuários")
public class UserRestController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
	public ResponseEntity<User> findByEmail(@PathVariable String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}

    @PostMapping
	public ResponseEntity<User> inserir(@RequestBody User user) {
		userService.insert(user);
		return ResponseEntity.ok(user);
	}

    @PutMapping("/{email}")
	public ResponseEntity<User> atualizar(@PathVariable String email, @RequestBody User user) {
		userService.update(email, user);
		return ResponseEntity.ok(user);
	}

    @DeleteMapping("/{email}")
	public ResponseEntity<Void> deletar(@PathVariable String email) {
		userService.delete(email);
		return ResponseEntity.ok().build();
	}

}
