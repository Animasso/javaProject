package dev.asid.runnerz;

import dev.asid.runnerz.run.Location;
import dev.asid.runnerz.run.Run;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args){
		SpringApplication.run(RunnerzApplication.class,args);
	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1,"pontault", LocalDateTime.now(),LocalDateTime.now().plus(1, ChronoUnit.HOURS),3, Location.OUTDOOR);
			System.out.println(run);

		};
	}

}
