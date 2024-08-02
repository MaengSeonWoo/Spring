package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	//1. 암호화/복호화에 사용하는 Bean 등록
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//2. 인증 및 인가 설정
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // HttpSecurity 보안 정보 담당
		http// Security가 체크하는 경로 및 각 경로별 권한
			.authorizeHttpRequests()
			.antMatchers("/", "/all") 		// 경로
				.permitAll()				// 인증/인가 확인 X
			.antMatchers("/admin/**")		// 경로
				// ROLE_ADMIN
				.hasRole("ADMIN") 			// 권한 부여(특정한 권한 체크)
			.antMatchers("/user/**")		// 경로
				//.hasAuthority("ROLE_USER")  		// 권한(자유롭게 권한명 사용)
				.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN") // 나열한 권한 중 하나만 해당해도 접근 가능
			.anyRequest()
				.authenticated() // anyRequest - 나머지 요청 일괄처리, authenticated - 권한은 무시하고 인증되었는지만 확인
		.and()
		.formLogin()
			.defaultSuccessUrl("/all") // 로그인했을때 어떤 페이지로 가고 싶은지
		.and()
		.logout()
			.logoutSuccessUrl("/all"); // 로그아웃했을때 어떤 페이지로 가고 싶은지
		
		return http.build();
	}
	
	// 테스트용 ) 메모리 인증 방식
//	@Bean
//	InMemoryUserDetailsManager inMemoryUserDetailsService() {
//		UserDetails user = User.builder()
//								.username("user1")
//								.password(passwordEncoder().encode("1234"))
////								.authorities("ROLE_USER")
//								.roles("USER") // ROLE_USER(알아서 ROLE이 붙음)
//								.build();
//		
//		UserDetails admin = User.builder()
//								.username("admin")
//								.password(passwordEncoder().encode("1234"))
////								.authorities("ROLE_ADMIN")
//								.roles("ADMIN") // ROLE_USER(알아서 ROLE이 붙음)
//								.build();
//		
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}
