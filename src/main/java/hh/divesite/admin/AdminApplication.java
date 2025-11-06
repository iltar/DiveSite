package hh.divesite.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.divesite.admin.domain.Divelog;
import hh.divesite.admin.domain.User;
import hh.divesite.admin.domain.UserRepository;

@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	CommandLineRunner testData (UserRepository userRep) {
		return (args) -> {
			//admin - salasana, user - salasana
			List<Divelog> ls = new ArrayList<Divelog>();
			User u1 = new User("admin", "$2a$10$gVT3OCW85KDXwSNgJdU5nOnCri4QHS1izB8gLcQr0lP7CFOD05cT6", "admin@divesite.com", "ADMIN");
			User u2 = new User("example", "$2a$10$gVT3OCW85KDXwSNgJdU5nOnCri4QHS1izB8gLcQr0lP7CFOD05cT6", "example@divesite.com", "USER");
			u1.setDivelogs(ls);
			u2.setDivelogs(ls);

			userRep.save(u1);
			userRep.save(u2);
			
		};
	}
}
