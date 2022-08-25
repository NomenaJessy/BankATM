package Bank.solarTransit.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Bank.solarTransit.Model.Role;
import Bank.solarTransit.Repository.RoleRepository;
import Bank.solarTransit.Util.Helper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RoleController {

	@Autowired
	public RoleRepository roleRepository;
	
	@GetMapping("/role")
	public Map<String,Object> getRole(){
		return Helper.succesResponse(roleRepository.findAll());
	}
	
//	@GetMapping("/role/{roleType}")
//	public Map<String,Object> getRoleByRoleType(@PathVariable("roleType")String roleType){
//		return Helper.succesResponse(roleRepository.findByRoleName(roleType));
//	}
	
	@GetMapping("/role/{id}")
	public Map<String,Object> getRoleById(@PathVariable("id")String idRole){
		return Helper.succesResponse(roleRepository.findById(idRole));
	}
	
	@PostMapping("/role")
	public Map<String,Object> addRole(@ModelAttribute Role role){
		return Helper.succesResponse(roleRepository.save(role));
	}
}
