package com.elias.Authenticationservice;

import com.elias.Authenticationservice.dao.TaskRepository;
import com.elias.Authenticationservice.model.AppRole;
import com.elias.Authenticationservice.model.AppUser;
import com.elias.Authenticationservice.model.Task;
import com.elias.Authenticationservice.service.AccountService;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthenticationServiceApplication implements CommandLineRunner{

    @Autowired
    private TaskRepository taskRepository;
    
    @Autowired
    private AccountService accountService;
    
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        taskRepository.deleteAll();
//        accountService.saveUser(new AppUser(null,"admin","1234",null));
//        accountService.saveUser(new AppUser(null,"user","1234",null));
//        accountService.saveRole(new AppRole(null,"Admin"));
//        accountService.saveRole(new AppRole(null,"USER"));
//        accountService.addRoleToUser("admin", "ADMIN");
//        accountService.addRoleToUser("user", "USER");
//        accountService.saveRole(new AppRole(null, "USER"));
//        accountService.saveRole(new AppRole(null, "ADMIN"));
//        Stream.of("user1","user2","user3","admin").forEach(u->{
//            accountService.saveUser(u,"1234","1234");
//        });
//        
//        accountService.addRoleToUser("admin", "ADMIN");
        
    }

    
    @Bean
    public BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
    
}

