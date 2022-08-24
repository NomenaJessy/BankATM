package Bank.solarTransit.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bank.solarTransit.Model.Balance;
import Bank.solarTransit.Model.User;
import Bank.solarTransit.Repository.BalanceRepository;
import Bank.solarTransit.Repository.UserRepository;
import Bank.solarTransit.Util.Helper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public BalanceRepository balanceRepository;
	
	@GetMapping("/user")
	public Map<String,Object> findAll(){
		return Helper.succesResponse(userRepository.findAll());
	}
	
	@GetMapping("/user/{id}")
	public Map<String,Object> findById(@PathVariable("id") String idUser){
		return Helper.succesResponse(userRepository.findById(idUser));
	}
	
	@PostMapping("/connexion")
	public Map<String,Object> connexion(@RequestParam(value = "mail") String Mail,@RequestParam(value = "password") String Password){
		try {
			User user = userRepository.login(Mail, Password);
			return Helper.succesResponse(user);
		}catch(Exception e) {
			return Helper.errorResponse(e.getMessage());
		}
	}
	
	@PostMapping("/inscription")
	public Map<String,Object> inscription(@ModelAttribute User user){
		try {
			userRepository.inscription(user);
			User newUser = userRepository.findByMail(user.getMail());
			Balance balance = new Balance(0.0,newUser.getIdUser());
			balanceRepository.save(balance);
			return Helper.succesResponse(newUser);
		}catch(Exception e) {
			return Helper.errorResponse(e.getMessage());
		}
	}
	
//	@PutMapping("/user/{id}")
//	public Map<String,Object> update(@PathVariable("id") String idUser,@RequestBody User user){
//		user.setIdUser(idUser);
//		return Helper.succesResponse(userRepository.save(user));
//	}
	
	@DeleteMapping("user/{id}")
	public Map<String,Object> delete(@PathVariable("id") String idUser){
		User data = userRepository.getById(idUser);
		userRepository.delete(data);
		return Helper.succesResponse(userRepository.findAll());
	}
}
