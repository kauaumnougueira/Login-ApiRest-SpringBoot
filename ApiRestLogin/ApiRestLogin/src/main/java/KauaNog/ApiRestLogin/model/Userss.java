package KauaNog.ApiRestLogin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Userss {
    private String name;
    @Id
    private String email;
    private String senha;

   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

     public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
