package de.gtwsp21.handmanserv.init;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import de.gtwsp21.handmanserv.domain.Benutzer;
import de.gtwsp21.handmanserv.repository.BenutzerRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BenutzerRepository benutzerRepository;
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	   http.authorizeRequests().antMatchers("/**/*.html").denyAll()
    	      .and()
    	      // some more method calls
    	      .formLogin()
                .successHandler(new AuthenticationSuccessHandler() {
 
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                            Authentication authentication) throws IOException, ServletException {
	                    	Benutzer b =benutzerRepository.findByeMailadresse(((User)authentication.getPrincipal()).getUsername());
	                    	b.setLetzteAnmeldung(LocalDateTime.now());
	                    	benutzerRepository.save(b);
                    	}
                });
    }
 
}