package com.exam.todojpa.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.domain.Role;
import com.exam.todojpa.domain.User;
import com.exam.todojpa.repository.RoleRepository;
import com.exam.todojpa.repository.UserRepository;
@Service
@Transactional
//public class UserService implements UserDetailsService {
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User addUser(String email, String encodePassword) {
		User user = new User();
		
		user.setEmail(email);
		user.setPassword(encodePassword);
		
		Role role = roleRepository.findByRolename("ROLE_USER").orElseThrow();
		user.setRoles(List.of(role));
		
		return userRepository.save(user);
	}
	@Transactional
	public User getUser(String email) {
		return userRepository.findByEmail(email).get();
	}

}
