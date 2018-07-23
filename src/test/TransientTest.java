package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable{

	private static final long serialVersionUID = 8294180014912103005L;

	public static String username;
	private transient String passwd;

	public User(){

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
public class TransientTest {

	public static void main(String[] args){

		User user = new User();
		user.setUsername("Alexia");
		user.setPasswd("123456");

		System.out.println("read before Serializable:");
		System.out.println("username : " + user.getUsername());
		System.out.println("password : " + user.getPasswd());

		try{
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("user.txt")
			);
			os.writeObject(user);
			os.flush();
			os.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}

		try{
			User.username = "jhf";
			ObjectInputStream is = new ObjectInputStream(
					new FileInputStream("user.txt")
			);

			user = (User) is.readObject();
			is.close();

			System.out.println("\read after Serializable:");
			System.out.println("username : " + user.getUsername());
			System.out.println("password : " + user.getPasswd());
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
