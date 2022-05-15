package isi.tn.payload.request;


import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String login;

	@NotBlank
	private String pwd;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String password) {
		this.pwd = password;
	}
}


