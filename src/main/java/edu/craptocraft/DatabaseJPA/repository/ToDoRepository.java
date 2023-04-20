package edu.craptocraft.DatabaseJPA.repository;

import edu.craptocraft.DatabaseJPA.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ToDoRepository extends JpaRepository<Task, Long>{
}
