package edu.craptocraft.DatabaseJPA.controller;

import edu.craptocraft.DatabaseJPA.model.Task;
import edu.craptocraft.DatabaseJPA.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable("id") long id) {
        return toDoRepository.findById(id).orElse(new Task());
    }
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return toDoRepository.findAll();
    }

    @PostMapping("/savetask")
    public String saveTask(@RequestBody Task task) {
        toDoRepository.save(task);
        return "Task saved";
    }

    @PutMapping("/update/{id}")
    public String updateTask(@PathVariable("id") long id, @RequestBody Task task) {
        Task task1 = toDoRepository.findById(id).orElse(new Task());
        task1.setTitle(task.getTitle());
        task1.setDescription(task.getDescription());
        toDoRepository.save(task1);
        return "Task updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        toDoRepository.deleteById(id);
        return "Task deleted";
    }
}
