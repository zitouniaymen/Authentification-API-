package org.sid;

import org.sid.dao.TaskRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Task;
import org.sid.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JwtSpringApplication implements CommandLineRunner{
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(JwtSpringApplication.class, args);
		
System.out.println("L'application de la jwt fonctionne bien comme les autre l'application");
		
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
	try
	{
		
	
		taskRepository.save(new Task(null,"T1"));
		taskRepository.save(new Task(null,"T2"));
		taskRepository.save(new Task(null,"T3"));
		
		accountService.saveRole(new AppRole(null, "USER"));
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveUser(new AppUser(null, "user", "1234", null));
		accountService.saveUser(new AppUser(null, "admin", "1234", null));
		
		accountService.addRoleToUser("user", "USER");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("admin", "ADMIN");
	}catch (Exception e) {
	e.getMessage();
	}
	}
}
