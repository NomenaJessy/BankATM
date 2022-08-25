package Bank.solarTransit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transactiontype")
public class TransactionType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtransactiontype")
	String idTransactionType;
	
	@Column(name="operationtype")
	String OperationType;

	public String getIdTransactionType() {
		return idTransactionType;
	}

	public void setIdTransactionType(String idTransactionType) {
		this.idTransactionType = idTransactionType;
	}

	public String getOperationType() {
		return OperationType;
	}

	public void setOperationType(String operationType) {
		OperationType = operationType;
	}
	
	public TransactionType() {}
	public TransactionType(String idTransactionType,String OperationType) {
		this.setIdTransactionType(idTransactionType);
		this.setOperationType(OperationType);
	}
}
