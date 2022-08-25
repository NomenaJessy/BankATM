package Bank.solarTransit.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtransaction")
	String idTransaction;
	
	@Column(name="amount")
	Double Amount;
	
	@Column(name="transactiondate")
	Date TransactionDate;
	
	@Column(name="iduser")
	String idUser;
	
	@Column(name="receiver")
	String Receiver;
	
	@Column(name="idtransactiontype")
	String idTransactionType;
	
	
	public String getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}
	
	public Date getTransactionDate() {
		return TransactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	
	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getReceiver() {
		return Receiver;
	}

	public void setReceiver(String receiver) {
		Receiver = receiver;
	}

	public String getIdTransactionType() {
		return idTransactionType;
	}

	public void setIdTransactionType(String idTransactionType) {
		this.idTransactionType = idTransactionType;
	}

	public Transaction() {}
	
	public Transaction(Double Amount,String idUser,String Receiver,String idTransactionType) {
		this.setAmount(Amount);
		this.setIdUser(idUser);
		this.setReceiver(Receiver);
		this.setIdTransactionType(idTransactionType);
	}
	
	public Transaction(String idTransaction,Double Amount,Date TransactionDate,String idUser,String Receiver,String idTransactionType) {
		this.setIdTransaction(idTransaction);
		this.setAmount(Amount);
		this.setTransactionDate(TransactionDate);
		this.setIdUser(idUser);
		this.setReceiver(Receiver);
		this.setIdTransactionType(idTransactionType);
	}
}
