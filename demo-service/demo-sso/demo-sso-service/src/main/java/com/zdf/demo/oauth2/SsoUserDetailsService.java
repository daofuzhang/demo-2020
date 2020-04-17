package com.zdf.demo.oauth2;


import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SsoUserDetailsService implements UserDetailsService {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		 Set<GrantedAuthority> userAuthotities = new HashSet<GrantedAuthority>();
         userAuthotities.add(new SimpleGrantedAuthority("demo-admin"));
        return new User("admin", passwordEncoder.encode("admin"), userAuthotities);
	}
	


}
