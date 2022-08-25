package Bank.solarTransit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Balance")
public class Balance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idbalance")
	String idBalance;
	
	@Column(name="amount")
	Double Amount;
	
	@Column(name="iduser")
	String idUser;

	public String getIdBalance() {
		return idBalance;
	}

	public void setIdBalance(String idBalance) {
		this.idBalance = idBalance;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Balance() {}
	
	public Balance(Double Amount,String idUser) {
		this.setAmount(Amount);
		this.setIdUser(idUser);
	}
	
	public Balance(String idBalance,Double Amount,String idUser) {
		this.setIdBalance(idBalance);
		this.setAmount(Amount);
		this.setIdUser(idUser);
	}
}
