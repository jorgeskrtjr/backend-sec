package com.backendsec.projsec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		return "<h1>Public Router </h1>";
	}

	@GetMapping("/private")
	String privateRoute(){
		return "<h1>Private Router </h1>";
	}
}