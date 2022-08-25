package Bank.solarTransit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roletable")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idrole")
	String idRole;
	
	@Column(name="roletype")
	String RoleType;

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getRoleType() {
		return RoleType;
	}

	public void setRoleType(String roleType) {
		RoleType = roleType;
	}
	
	public Role() {}
	
	public Role(String RoleType) {
		this.setRoleType(RoleType);
	}
	
	public Role(String idRole,String RoleType) {
		this.setIdRole(idRole);
		this.setRoleType(RoleType);
	}
	
	
}
