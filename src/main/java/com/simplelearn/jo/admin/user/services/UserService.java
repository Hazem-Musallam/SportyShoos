package com.simplelearn.jo.admin.user.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplelearn.jo.admin.data.UserRoles;
import com.simplelearn.jo.admin.user.entity.User;
import com.simplelearn.jo.admin.user.repository.UserRepository;

@Service
public class UserService extends JpaEntityService<User> implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findOneByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
	}

	@Override
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repository.save(user);
	}

	public Optional<User> findOneByUsername(String username) {
		return repository.findOneByUsername(username);
	}

	public Page<User> findAllUserRole(Pageable page, UserRoles roleUser) {
		return repository.findAllByRolesNameIgnoreCase(roleUser.name(), page);

	}

	public Page<User> findAllUserRoleAndSearch(String search, Pageable page, UserRoles roleUser) {
		return repository.findAllByUsernameIgnoreCaseAndRolesNameIgnoreCase(search, roleUser.name(), page);
	}

}
