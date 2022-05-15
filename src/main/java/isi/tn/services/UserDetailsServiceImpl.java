package isi.tn.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.entities.*;
import isi.tn.repository.*;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	userRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.findByLogin(login)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: " + login));

		return UserDetailsImpl.build(user);
	}

}

