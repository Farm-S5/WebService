package farm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import connect.*;
import java.sql.*;
import personne.*;
@SpringBootApplication
public class FarmcityApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(FarmcityApplication.class, args);
		// Personne p = new Personne("Loick","123");
		// boolean i = p.loginPersonne(p);
		System.out.println("test");
	}

}
