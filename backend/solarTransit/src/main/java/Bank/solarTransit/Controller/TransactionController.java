package Bank.solarTransit.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bank.solarTransit.Model.Balance;
import Bank.solarTransit.Repository.BalanceRepository;
import Bank.solarTransit.Repository.TransactionRepository;
import Bank.solarTransit.Repository.TransactionTypeRepository;
import Bank.solarTransit.Util.Helper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TransactionController {

	@Autowired
	public TransactionRepository transactionRepository;
	
	@Autowired
	public TransactionTypeRepository optionRepository;
	
	@Autowired
	public BalanceRepository balanceRepository;
	
	@GetMapping("/transaction")
	public Map<String,Object> getTransaction(){
		return Helper.succesResponse(transactionRepository.findAll());
	}
	
	@GetMapping("/transaction/{id}")
	public Map<String,Object> getTransactionByUserId(@PathVariable("id") String idUser){
		return Helper.succesResponse(transactionRepository.findByUserId(idUser));
	}
	
	@GetMapping("/transactionType")
	public Map<String,Object> getTransactionType(){
		return Helper.succesResponse(optionRepository.findAll());
	}
	
	@GetMapping("/transactionType/{id}")
	public Map<String,Object> getTransactionTypeById(@PathVariable("id")String operationType){
		return Helper.succesResponse(optionRepository.findByOperationType(operationType));
	}
	
	@PostMapping("/transaction")
	public Map<String,Object> operation(@RequestParam("idUser") String idUser,@RequestParam("amount") String amount,@RequestParam("receiver") String receiver,@RequestParam("operationType") String idOperationType){
		Double Amount = Double.parseDouble(amount);
		transactionRepository.insert(Amount, idUser, receiver, idOperationType);
		Balance balance = balanceRepository.findByUser(idUser);
		Amount += balance.getAmount(); 
		balance.setAmount(Amount);
		return Helper.succesResponse(balanceRepository.save(balance));
	}

}
