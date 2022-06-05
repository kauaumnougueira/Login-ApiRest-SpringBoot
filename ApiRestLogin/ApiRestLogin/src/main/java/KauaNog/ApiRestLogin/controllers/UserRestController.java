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

import KauaNog.ApiRestLogin.model.Userss;
import KauaNog.ApiRestLogin.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("Usuários")
public class UserRestController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/{email}")
	public ResponseEntity<Userss> findByEmail(@PathVariable String email) {
		return ResponseEntity.ok(userService.findByEmail(email));
	}

    @PostMapping
	public ResponseEntity<Userss> inserir(@RequestBody Userss user) {
		userService.insert(user);
		return ResponseEntity.ok(user);
	}

    @PutMapping("/{email}")
	public ResponseEntity<Userss> atualizar(@PathVariable String email, @RequestBody Userss user) {
		userService.update(email, user);
		return ResponseEntity.ok(user);
	}

    @DeleteMapping("/{email}")
	public ResponseEntity<Void> deletar(@PathVariable String email) {
		userService.delete(email);
		return ResponseEntity.ok().build();
	}

}
