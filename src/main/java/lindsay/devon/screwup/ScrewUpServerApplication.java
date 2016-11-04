package lindsay.devon.screwup;

import lindsay.devon.screwup.Repository.UserRepository;
import lindsay.devon.screwup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrewUpServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrewUpServerApplication.class, args);
	}

	@Autowired
	UserRepository repo;

	@Override
	public void run(String...args) throws Exception {
		User user1 = new User("Devon", "111", "5000");
		User user2 = new User("Zac", "222", "10000");
		repo.save(user1);
		repo.save(user2);
	}
}
