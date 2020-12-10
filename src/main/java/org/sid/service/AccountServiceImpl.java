package org.sid.service;

import javax.transaction.Transactional;

import org.sid.dao.AppRoleRepository;
import org.sid.dao.AppUserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private AppRoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public AppUser saveUser(AppUser u) {
		return u;

//		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
//		return userRepository.save(u);
	}

	@Override
	public AppRole saveRole(AppRole r) {
		roleRepository.save(r);
		return null;
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppUser user=userRepository.findByUsername(username);
		AppRole  role=roleRepository.findByRole(roleName);
		user.getRoles().add(role);
		
	}

}
