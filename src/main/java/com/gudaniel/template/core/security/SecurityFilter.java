package com.gudaniel.template.core.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gudaniel.template.repositories.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
	public static final String HEADER_ATTRIBUTE = "Authorization";
	public static final String ATTRIBUTE_PREFIX = "Bearer ";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String tokenJWT = findToken(request);
		
		if(tokenJWT != null) {
			var subject = tokenService.getSubject(tokenJWT);
			var user = userRepository.findByUserName(subject);
			var authentication = new UsernamePasswordAuthenticationToken(user.get(), null, new ArrayList<>());	
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String findToken(HttpServletRequest request) {
		var authorization = request.getHeader(HEADER_ATTRIBUTE);
		
		if(authorization != null) {
			return authorization.replace(ATTRIBUTE_PREFIX, "");
		} 
		
		return null;

	}
}
