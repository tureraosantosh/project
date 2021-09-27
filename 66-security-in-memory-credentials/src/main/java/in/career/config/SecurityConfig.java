package in.career.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("devs").password("{noop}devs").authorities("ADMIN");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/home").permitAll().antMatchers("welcome").authenticated()
				.antMatchers("/admin").hasAuthority("ADMIN").antMatchers("/emp").hasAuthority("EMPLOYEE")
				.antMatchers("/mgr").hasAuthority("MANAGER").antMatchers("common")
				.hasAnyAuthority("ADMIN", "MANAGER", "EMPLOYEE").anyRequest().authenticated().and().formLogin()
				.defaultSuccessUrl("/welcome", true).and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and().exceptionHandling()
				.accessDeniedPage("/accessDenied");
	}

}
