package co.za.projectl.resource.repository;

import org.springframework.data.repository.CrudRepository;

import co.za.projectl.resource.jpa.Task;


public interface TaskRepository extends CrudRepository<Task, Long>{

	public Task findByDescription(String description);

}
