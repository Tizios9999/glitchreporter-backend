package com.ds.glitchreporter.security.jwt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * This class implements the AuthenticationEntryPoint interface and serves as the
 * entry point for handling authentication errors.
 */

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

  private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

  /**
   * This method is called when an unauthenticated user tries to access a secured resource.
   * It sends an unauthorized error response with a status code and message.
   * @param request The HttpServletRequest object
   * @param response The HttpServletResponse object
   * @param authException The AuthenticationException that occurred
   * @throws IOException If an input or output exception occurs
   * @throws ServletException If a servlet related exception occurs
   */
  
  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
    logger.error("Unauthorized error: {}", authException.getMessage());
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
  }
}
