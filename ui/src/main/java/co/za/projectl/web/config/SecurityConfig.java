package co.za.projectl.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import co.za.projectl.web.filter.CsrfHeaderFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
				.anyRequest().authenticated()
		.and()
			    .formLogin().loginPage("/login").permitAll()
			    .usernameParameter("username").passwordParameter("password")
		.and()
			.logout().logoutSuccessUrl("/login?logout") 
		.and()
			.exceptionHandling().accessDeniedPage("/not-allowed")
		.and()
			.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class).csrf()
			.csrfTokenRepository(csrfTokenRepository());
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName("X-XSRF-TOKEN");
		return repository;
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}
}