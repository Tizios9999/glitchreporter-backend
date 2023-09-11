package com.ds.glitchreporter.security.jwt;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ds.glitchreporter.dto.response.JwtResponseDTO;
import com.ds.glitchreporter.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * This class provides methods to generate, validate and extract data from JWT token.
 */
@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${glitchreporter.app.jwtSecret}")
  private String jwtSecret;

  @Value("${glitchreporter.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  /**
   * Generates a JWT token from an authentication object.
   *
   * @param authentication Authentication object
   * @return JwtResponseDTO object containing the JWT token and the authenticated user data.
   */
  
  public JwtResponseDTO generateJwtResponse(Authentication authentication) {
	    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
	    Date expirationDate = new Date((new Date()).getTime() + jwtExpirationMs);

	    String token = Jwts.builder()
	        .setSubject((userPrincipal.getUsername()))
	        .setIssuedAt(new Date())
	        .setExpiration(expirationDate)
	        .signWith(key(), SignatureAlgorithm.HS256)
	        .compact();

	    return new JwtResponseDTO(token, userPrincipal.getId(), userPrincipal.getUsername(), userPrincipal.getEmail(), userPrincipal.getRoles(), expirationDate);
	  }
  
  /**
   * Generates a secret key based on a secret string.
   *
   * @return Secret key
   */
  
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  /**
   * Extracts the username from a JWT token.
   *
   * @param token JWT Token from which the username will be extracted
   * @return Username extracted from the JWT token.
   */
  
  public String getUserNameFromJwtToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
               .parseClaimsJws(token).getBody().getSubject();
  }
  
  /**
   * Validates a JWT Token.
   *
   * @param authToken JWT token to be validated
   * @return True if it's a valid token, false otherwise.
   */

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
