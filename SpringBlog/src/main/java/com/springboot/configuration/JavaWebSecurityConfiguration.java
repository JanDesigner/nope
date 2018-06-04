package com.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class JavaWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	DataSource dataSource;
	
	private final String USER_QUERY = "select email,password,enabled from user where email = ?";
	private final String ROLE_QUERY 
		= "select u.email , r.role from user u join user_role ur on ur.user_id = u.id join role r on r.role_id = ur.role_id where email = ?";
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication()
			.usersByUsernameQuery(USER_QUERY)
			.authoritiesByUsernameQuery(ROLE_QUERY)
			.passwordEncoder(bCryptPasswordEncoder)
			.dataSource(dataSource);
		
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/signup").permitAll()
			.antMatchers("/login").permitAll()
			.antMatchers("/logout").permitAll()
			.antMatchers("/home").hasAnyAuthority("MEMBER","ADMIN")
		.and()
			.formLogin()
			.loginPage("/login").failureUrl("/login?error=true")
			.usernameParameter("email")
			.passwordParameter("password")
			.defaultSuccessUrl("/home")
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
		.and()
			.exceptionHandling().accessDeniedPage("/denied");
	}
	
	
	
	
}
