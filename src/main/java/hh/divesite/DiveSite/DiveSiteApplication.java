package hh.divesite.DiveSite;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.divesite.DiveSite.domain.Divelog;
import hh.divesite.DiveSite.domain.DivelogRepository;
import hh.divesite.DiveSite.domain.User;
import hh.divesite.DiveSite.domain.UserRepository;

@SpringBootApplication
public class DiveSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveSiteApplication.class, args);
	}

	@Bean
	CommandLineRunner testData(UserRepository userRep, DivelogRepository dlRep) {
		return (args) -> {
			User u1 = new User("admin", "$2a$10$gVT3OCW85KDXwSNgJdU5nOnCri4QHS1izB8gLcQr0lP7CFOD05cT6",
					"admin@divesite.com", "ADMIN");
			User u2 = new User("example", "$2a$10$gVT3OCW85KDXwSNgJdU5nOnCri4QHS1izB8gLcQr0lP7CFOD05cT6",
					"example@divesite.com", "USER");
			u2.setLevel("AOWD");
			u2.setDives(32);
			u2.setDescription("Example diver who dives");
			u2.setDivelogs(new ArrayList<Divelog>());
			userRep.save(u1);
			userRep.save(u2);
		};
	}
}
