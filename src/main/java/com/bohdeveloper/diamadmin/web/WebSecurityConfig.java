package com.bohdeveloper.diamadmin.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	//Para construir usuarios en memoria
//	@Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails user1 = User.withUsername("user1")
//            .password(passwordEncoder().encode("user1Pass"))
//            .roles("USER")
//            .build();
//        UserDetails user2 = User.withUsername("user2")
//            .password(passwordEncoder().encode("user2Pass"))
//            .roles("USER")
//            .build();
//        UserDetails admin = User.withUsername("admin")
//            .password(passwordEncoder().encode("adminPass"))
//            .roles("ADMIN")
//            .build();
//        return new InMemoryUserDetailsManager(user1, user2, admin);
//    }
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withUsername("admin")
           .password(passwordEncoder().encode("admin"))
           .roles("ADMIN")
           .build();

		return new InMemoryUserDetailsManager(user);
	}
	
	//Para acceder a usuarios de la base de datos
//	@Autowired
//	private DataSource dataSource;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	    auth.jdbcAuthentication().dataSource(dataSource)
//		  
//	//Iniciar sesión con email
//	.usersByUsernameQuery("SELECT email, password, 1 "
//	        + "FROM usuarios "
//	        + "WHERE email = ?")
//	      .authoritiesByUsernameQuery("SELECT u.email, CONCAT('ROLE_', r.nombre) "
//		    + "FROM usuarios u JOIN roles r ON u.id_roles = r.id_roles "
//	        + "WHERE email = ?");
//	}
	
	//Para configurar los accesos a páginas
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests((requests) -> requests
			.antMatchers("/app/**").authenticated()
			.anyRequest().permitAll()
		)
		.formLogin((form) -> form
			.loginPage("/login")
			.defaultSuccessUrl("/app")
			.permitAll()
		)
		.logout((logout) -> logout
				.logoutSuccessUrl("/")
				.permitAll());

	return http.build();
		 
//        http.csrf()
//        .disable()
//        .authorizeRequests()
//		.antMatchers("/app/**").authenticated()// <-- Acceso a usuarios registrados / .hasRole("ADMIN") <-- Acceso al rol administrador
//		.anyRequest().permitAll()
//		.and()
//	.formLogin()
//		.loginPage("/login")
//	.permitAll()
//		.and()
//		.logout()
//	.permitAll();
//        return http.build();        
//            .disable()
//            .authorizeRequests()
//            .antMatchers("/admin/**")
//            .hasRole("ADMIN")
//            .antMatchers("/anonymous*")
//            .anonymous()
//            .antMatchers("/login*")
//            .permitAll()
//            .anyRequest()
//            .authenticated();
//            return http.build();
    }
	
	//Para encriptar
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	//Para ingorar solicitudes
//	@Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/prueba/*", "/ignore");
//    }
	


}