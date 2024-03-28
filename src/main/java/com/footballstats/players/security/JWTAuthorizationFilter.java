
package com.footballstats.players.security;

import com.footballstats.players.service.IJWTUtilityService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;


public class JWTAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    IJWTUtilityService jwtUtilityService;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String header = request.getHeader("Authorization");
       
       if(header == null || !header.startsWith("Bearer ")){
           filterChain.doFilter(request, response);
           return;
       }
       
       String token = header.substring(7);
       
       try {
           JWTClaimsSet claims = jwtUtilityService.parseJWT(token);
       } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JWTAuthorizationFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(JWTAuthorizationFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JOSEException ex) {
            Logger.getLogger(JWTAuthorizationFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JWTAuthorizationFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
