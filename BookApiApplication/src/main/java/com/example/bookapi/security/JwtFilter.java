package com.example.bookapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//security/JwtFilter.java
@Component
public class JwtFilter extends OncePerRequestFilter {

 @Autowired
 private JwtUtil jwtUtil;

 @Autowired
 private UserDetailsServiceImpl userDetailsService;

 @Override
 protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
         throws ServletException, IOException, java.io.IOException {

     String authHeader = request.getHeader("Authorization");
     String username = null;
     String jwt = null;

     if (authHeader != null && authHeader.startsWith("Bearer ")) {
         jwt = authHeader.substring(7);
         username = jwtUtil.extractUsername(jwt);
     }

     if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
         UserDetails userDetails = userDetailsService.loadUserByUsername(username);
         if (jwtUtil.validateToken(jwt, userDetails)) {
             UsernamePasswordAuthenticationToken token =
                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

             token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
             SecurityContextHolder.getContext().setAuthentication(token);
         }
     }

     chain.doFilter(request, response);
 }
}
