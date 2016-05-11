package co.za.projectl.resource;

import java.util.Calendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.za.projectl.resource.jpa.Task;
import co.za.projectl.resource.repository.TaskRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProjectLApplication {
	private static final Logger log = LoggerFactory.getLogger(ProjectLApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectLApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TaskRepository repository) {
		return (args) -> {
			// save a couple of Tasks
			repository.save(new Task("Do Maths", "This is my comment", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(),1L,2L));
			repository.save(new Task("Do Science", "This is my comment2", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(),1L,2L));
			repository.save(new Task("Do Sports", "This is my comment3", Calendar.getInstance().getTime(), Calendar.getInstance().getTime(),1L,2L));

			// fetch all Tasks
			log.info("Tasks found with findAll():");
			log.info("-------------------------------");
			for (Task Task : repository.findAll()) {
				log.info(Task.toString());
			}
            log.info("");

			// fetch Tasks by last name
			log.info("Task found with findByDescription('Do Maths'):");
			log.info("--------------------------------------------");
			Task bauer = repository.findByDescription("Do Maths");
			log.info(bauer.toString());
            log.info("");
		};
	}
}
