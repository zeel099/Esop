package com.esop.Esop_management.controller;

import com.esop.Esop_management.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.esop.Esop_management.payload.JwtAuthRequest;
import com.esop.Esop_management.payload.JwtAuthResponse;
import com.esop.Esop_management.security.JwtTokenHelper;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@RestController
@RequestMapping("/api")
public class AuthController  {

//
//	@Autowired
//	private JwtTokenHelper jwtTokenHelper;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@PostMapping("/auth/login")
//	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
//
//		this.doAuthenticate(request.getUsername(),request.getPassword());
//
//		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
//		String token = this.jwtTokenHelper.generateToken(userDetails);
//
//		 JwtAuthResponse response = JwtAuthResponse.builder()
//				 	.jwtToken(token)
//	                .username(userDetails.getUsername()).build();
//	        return new ResponseEntity<>(response, HttpStatus.OK);
//		//return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
//
//	}
//
//	private void doAuthenticate(String username, String password) throws Exception {
//		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
//
//		try {
//			this.authenticationManager.authenticate(authenticationToken);
//		}
//		catch(BadCredentialsException e){
//			System.out.println("Invalid details");
//			throw new Exception("invalid username or password !!");
//		}
//
	//}
}
