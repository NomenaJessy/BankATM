package Bank.solarTransit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Bank.solarTransit.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,String>{
	
	@Query(value="SELECT * FROM Transaction WHERE iduser = :idUser",nativeQuery = true)
	public List<Transaction>findByUserId(String idUser);
	
	@Query(value="INSERT INTO Transaction(amount,iduser,receiver,idtransactiontype) VALUES (:amount,:iduser,:receiver,:idtransactionType)",nativeQuery=true)
	public void insert(Double amount,String iduser,String receiver,String idtransactionType);
}
