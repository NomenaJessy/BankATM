package Bank.solarTransit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Bank.solarTransit.Model.User;
import Bank.solarTransit.Util.Helper;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	
	@Query(value = "SELECT COUNT(*) FROM UserTable  WHERE mail = :Mail AND password = :Password", nativeQuery = true)
	public int checkUser(String Mail, String Password);
	
	@Query(value = "SELECT COUNT(*) FROM UserTable  WHERE mail = :Mail", nativeQuery = true)
	public int checkCompte(String Mail);

	@Query(value = "SELECT * FROM UserTable WHERE mail = :Mail", nativeQuery = true)
	public User findByMail(String Mail);
	
	public default User login(String Mail, String Password) throws Exception {
		Password = Helper.sha1(Password);
		if (this.checkUser(Mail, Password) == 0) {
			throw new Exception("Adresse mail ou mot de passe incorrect");
		}
		User user = this.findByMail(Mail);
		return user;
	}
	
	public default String inscription(User user) throws Exception{
    	int check = checkCompte(user.getMail());
    	if(check > 0) {
    		throw new Exception("Cet adresse est deja utilise");
    	}
    	String password = Helper.sha1(user.getPassword());
    	user.setPassword(password); 
    	this.save(user);
    	return "Inscription réussie";
    }
}
