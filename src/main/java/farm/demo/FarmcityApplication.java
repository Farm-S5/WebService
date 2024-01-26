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
		Connect c = new Connect();
		Connection con =c.conekta();
		System.out.println(con);
	}

}
