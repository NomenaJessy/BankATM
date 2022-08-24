package Bank.solarTransit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Bank.solarTransit.Model.TransactionType;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType,String>{
	
	@Query(value="SELECT * FROM TransactionType WHERE idtransactiontype = :OperationType",nativeQuery = true)
	public TransactionType findByOperationType(String OperationType);
}
