package Bank.solarTransit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Bank.solarTransit.Model.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String>{
	
	@Query(value="SELECT * FROM Balance WHERE iduser = :idUser",nativeQuery = true)
	public Balance findByUser(String idUser);
}
