package Bank.solarTransit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Bank.solarTransit.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,String>{
	
	@Query(value="SELECT * FROM RoleTable WHERE roletype = :RoleType", nativeQuery = true)
	public Role findByRoleName(String RoleType);
}
