package com.hybernate_jpa.hibernate_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hybernate_jpa.hibernate_jpa.entidades.Persona;


import com.hybernate_jpa.hibernate_jpa.repositorios.Repo_Persona;

@SpringBootApplication
public class HibernateJpaApplication implements CommandLineRunner {

	@Autowired
	private Repo_Persona repositorio;

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Persona> personas = (List<Persona>) repositorio.findAll(); 
		personas.stream().forEach(persona -> System.out.println(persona));
	}

}
