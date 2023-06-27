package com.dantas.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dantas.helpdesk.domain.People;
import com.dantas.helpdesk.domain.repositories.PeopleRepository;
import com.dantas.helpdesk.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private PeopleRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<People> user = repository.findByEmail(email);
		if (user.isPresent()) {
			People people = user.get();
			return new UserSS(people.getId(), people.getEmail(), people.getPassword(), people.getProfiles());
		}
		throw new UsernameNotFoundException(email);
	}

}