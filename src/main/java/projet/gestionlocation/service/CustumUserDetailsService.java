package projet.gestionlocation.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import projet.gestionlocation.dao.IUtilisateur;
import projet.gestionlocation.model.Role;
import projet.gestionlocation.model.Utilisateur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Service
//ou @Component
public class CustumUserDetailsService implements UserDetailsService{
	@Autowired
	private IUtilisateur userDAO ;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur user = userDAO.findByLogin(username);
		if(user != null)
		{
			 User u = new User(user.getLogin(),user.getPwd(),
					 true,true,true,true,getAuthorities(user.getRoles()));
			 return u ;
		}
		
		return null;
	}
	
	private Collection getAuthorities(List roles) {
		List authorities = new ArrayList();
		for(Object role : roles)
		{
			Role l = (Role)role;
			authorities.add(new SimpleGrantedAuthority(l.getLibRole()));
		}
		return authorities ;
	}

}
