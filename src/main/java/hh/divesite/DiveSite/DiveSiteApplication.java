package hh.divesite.DiveSite;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
			System.out.println("generating admin user");
			User u1 = new User("admin", "$2a$10$gVT3OCW85KDXwSNgJdU5nOnCri4QHS1izB8gLcQr0lP7CFOD05cT6",
					"admin@divesite.com", "ADMIN");

			System.out.println("generating example user");
			User u2 = new User("example", "$2a$10$gVT3OCW85KDXwSNgJdU5nOnCri4QHS1izB8gLcQr0lP7CFOD05cT6",
					"example@divesite.com", "USER");
			System.out.println("assigning example user's profile");
			u2.setLevel("AOWD");
			u2.setDives(32);
			u2.setDescription("Example diver who dives");
			u2.setDivelogs(new ArrayList<Divelog>());
			userRep.save(u1);
			userRep.save(u2);

			System.out.println("generating example divelogs");
			Divelog dl1 = new Divelog(LocalDateTime.now(), u2, 23, "Many colourful fish", LocalDate.of(2024, 12, 8), "10:21", "11:00", "Maldives", "South Male", "Aquarium", "Boat dive", 28, 16, 200, 60, 28, "calm", "great", 3, "2.5mm short", "Nitrox 32%");
			Divelog dl2 = new Divelog(LocalDateTime.now(), u2, 24, "Lots of sharks", LocalDate.of(2024, 12, 8), "14:29", "15:18", "Maldives", "South Male", "Shark tank", "Boat dive", 24, 12, 190, 70, 28, "calm", "okay", 3, "2.5mm short", "Nitrox 32%");
			dlRep.save(dl1);
			dlRep.save(dl2);
		};
	}
}
