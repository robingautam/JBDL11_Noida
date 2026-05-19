package org.gfg.JBDL11_EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Jbdl11EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jbdl11EurekaServerApplication.class, args);
	}

}
