package com.simplelearn.jo.admin.data;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.simplelearn.jo.admin.user.entity.Privilege;
import com.simplelearn.jo.admin.user.entity.Role;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.services.PrivilegeService;
import com.simplelearn.jo.admin.user.services.RoleService;
import com.simplelearn.jo.admin.user.services.UserService;

@Component
public class InitialDataLoader {

	@Autowired
	UserService userService;

	@Autowired
	PrivilegeService privilegeService;

	@Autowired
	RoleService roleService;

	@PostConstruct
	private void init() {
		if (userService.count() == 0) {
			userService.deleteAll();
			roleService.deleteAll();
			privilegeService.deleteAll();

			Privilege readPrivilege = new Privilege();
			readPrivilege.setName(Previliges.READ);
			privilegeService.save(readPrivilege);

			Privilege writePrivilege = new Privilege();
			writePrivilege.setName(Previliges.WRITE);
			privilegeService.save(writePrivilege);

			Role adminRole = new Role();
			adminRole.setName(UserRoles.ROLE_ADMIN.name());
			adminRole.setPrivileges(Arrays.asList(readPrivilege, writePrivilege));
			roleService.save(adminRole);

			Role userRole = new Role();
			userRole.setName(UserRoles.ROLE_USER.name());
			userRole.setPrivileges(Arrays.asList(readPrivilege));
			roleService.save(userRole);

			User admin = new User();
			admin.setUsername("spl");
			admin.setPassword("spl");
			admin.setRoles(Arrays.asList(adminRole));
			userService.save(admin);

		}
	}

}