package com.backendsec.projsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProjSecApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjSecApplication.class, args);
	}

}

@RestController
class HttpController {
	@GetMapping("/public")
	String publicRoute(){
		return "<h1>Public Router 🔐</h1>";
	}

	@GetMapping("/private")
	String privateRoute(){
		return "<h1>Private Router 🔐</h1>";
	}

	@GetMapping("/cookie")
	String cookie(@AuthenticationPrincipal OidcUser principal){
		return String.format("""
					<h1>Oauth2 🔐  </h1>
				<h3>Principal: %s</h3>
				<h3>Email attribute: %s</h3>
				<h3>Authorities: %s</h3>
				<h3>JWT: %s</h3>
				""", principal, principal.getAttribute("email"), principal.getAuthorities(),
				principal.getIdToken().getTokenValue());

	}

	@GetMapping("/jwt")
	String jwt(){
		return String.format("""
				<h1> JWT </h1>
				""");
	}

}
