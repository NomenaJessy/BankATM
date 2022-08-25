package Bank.solarTransit.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bank.solarTransit.Model.Balance;
import Bank.solarTransit.Repository.BalanceRepository;
import Bank.solarTransit.Util.Helper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class BalanceController {

	@Autowired
	public BalanceRepository balanceRepository;
	
	@GetMapping("/balance/{id}")
	public Map<String,Object> getBalance(@PathVariable("id") String idUser){
		return Helper.succesResponse(balanceRepository.findByUser(idUser));
	}
	
	@PutMapping("/balance/{id}")
	public Map<String,Object> updateBalance(@PathVariable("id") String idUser,@RequestParam("amount") String Amount){
		Balance balance = balanceRepository.findByUser(idUser);
		Double amount = balance.getAmount() + Double.parseDouble(Amount);
		balance.setAmount(amount);
		return Helper.succesResponse(balanceRepository.save(balance));
	}
	
}
