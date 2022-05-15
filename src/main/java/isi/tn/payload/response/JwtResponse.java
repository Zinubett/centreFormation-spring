package isi.tn.payload.response;



import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String login;
	private String pwd;
	private List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String pwd, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.login = username;
		this.pwd = pwd;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String username) {
		this.login = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}


