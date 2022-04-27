package com.project.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude= MongoAutoConfiguration.class)
public class DashboardApplication  {

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DashboardApplication.class);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DashboardApplication.class, args);
	}

}
