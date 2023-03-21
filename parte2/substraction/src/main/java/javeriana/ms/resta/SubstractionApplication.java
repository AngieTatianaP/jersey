package javeriana.ms.resta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubstractionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubstractionApplication.class, args);
	}

}
