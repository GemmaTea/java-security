import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.google.common.hash.Hashing;

public class User {
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = encryptPassword(password);
	}
	
	public String encryptPassword(String password) {
		return Hashing.sha256()
				  .hashString(password, StandardCharsets.UTF_8)
				  .toString();
	}
	
	public boolean isPasswordMatch(String password) {
		return this.password.equals(encryptPassword(password));
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	public static void main(String[] args) {
		User user = new User("thang", "hellosadfasdf");
//		System.out.println(user);
//		Scanner scanner = new Scanner(System.in);
//		String password = scanner.nextLine();
//		if (user.isPasswordMatch(password)) {
//			System.out.println("login success!");
//		} else {
//			System.out.println("login failed!");
//		}
		System.out.println(user.getPassword().length());
	}
}
