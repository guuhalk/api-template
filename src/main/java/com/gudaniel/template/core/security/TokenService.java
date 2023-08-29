package com.gudaniel.template.core.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.google.gson.Gson;
import com.gudaniel.template.entities.dtos.TokenDto;

@Service
public class TokenService  {

	@Value("${api.security.token.secret}")	
	private String secret;
	
	public String generateToken(String user) {
		try {
	            var algorithm = Algorithm.HMAC256(secret);
	            var jwt = JWT.create()
	                .withIssuer("API Template")
	                .withSubject(user)
	                .withExpiresAt(expirationToken())
	                .sign(algorithm);

	    		TokenDto userFromJson = new TokenDto();
	    		userFromJson.setToken(jwt);
	    		userFromJson.setDataExpiration(expirationToken().toString());
	    		
	    		return new Gson().toJson(userFromJson);
		 
		 } catch (JWTCreationException exception){
	            throw new RuntimeException("erro ao gerrar token jwt", exception);
	        }        
	}
	
	public String getSubject(String token) {
		try {
		    Algorithm algorithm = Algorithm.HMAC256(secret);
		    return JWT.require(algorithm)
		    		.withIssuer("API Template")
		    		.build()
		    		.verify(token)
		    		.getSubject();

		} catch (JWTVerificationException exception){
			throw new RuntimeException("Token JWT invalido ou expirado");
		}
	}
	
	public Instant expirationToken() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
