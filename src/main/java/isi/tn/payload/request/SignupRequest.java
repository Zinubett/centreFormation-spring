package isi.tn.payload.request;



import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String login;
 
   
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String pwd;
  
    public String getLogin() {
        return login;
    }
 
    public void setLogin(String username) {
        this.login = username;
    }
 
   
 
    public String getPwd() {
        return pwd;
    }
 
    public void setPwd(String password) {
        this.pwd = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}

