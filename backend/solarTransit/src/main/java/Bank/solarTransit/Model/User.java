package Bank.solarTransit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="usertable")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iduser")
	String idUser;
	
	@Column(name="firstname")
	String Firstname;
	
	@Column(name="lastname")
	String Lastname;
	
	@Column(name="birthdate")
	Date Birthdate;
	
	@Column(name="mail")
	String Mail;
	
	@Column(name="password")
	String Password;
	
	@Column(name="roletype")
	String RoleType;
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public Date getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}
	public String getMail() {
		return Mail;
	}
	public void setMail(String mail) {
		Mail = mail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRoleType() {
		return RoleType;
	}
	public void setRoleType(String RoleType) {
		this.RoleType = RoleType;
	}
	
	public User() {}
	
	public User(String Mail,String Password) {
		this.setMail(Mail);
		this.setPassword(Password);
	}
	
	public User(String idUser,String Firstname,String Lastname,Date Birthdate,String Mail,String Password,String RoleType) {
		this.setIdUser(idUser);
		this.setFirstname(Firstname);
		this.setLastname(Lastname);
		this.setBirthdate(Birthdate);
		this.setMail(Mail);
		this.setPassword(Password);
		this.setRoleType(RoleType);
	}
}
