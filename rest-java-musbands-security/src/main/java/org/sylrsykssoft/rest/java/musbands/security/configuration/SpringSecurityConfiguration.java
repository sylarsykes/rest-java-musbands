package org.sylrsykssoft.rest.java.musbands.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Spring security configuration
 * 
 * @author juan.gonzalez.fernandez.jgf
 *
 */
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/admin/**").hasAnyRole("ADMIN").anyRequest().authenticated();
	}

	/**
	 * Configure defaul users.
	 * 
	 * @param builder
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder builder) throws Exception {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);

		builder.inMemoryAuthentication()
				.withUser(userBuilder.username("admin").password("4815162342").roles("ADMIN", "USER"))
				.withUser(userBuilder.username("john.doe").password("123456789").roles("USER"));
	}
}
