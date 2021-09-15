package pe.com.bcp.jms.colasMQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MainMQApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainMQApplication.class, args);
	}

}
