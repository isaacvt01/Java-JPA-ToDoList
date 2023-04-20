package edu.craptocraft.DatabaseJPA.controller;

import edu.craptocraft.DatabaseJPA.model.Task;
import edu.craptocraft.DatabaseJPA.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ViewController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/allTasks")
    public String list(Model model) {
        List<Task> tasks  = toDoRepository.findAll();
        model.addAttribute("title", "All tasks");
        model.addAttribute("tasks", tasks);
        return "list";
    }
    @GetMapping("/addTask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("title", "Add task");
        return "addTask";
    }
    @PostMapping("/addTask")
    public String addTask(Task task) {
        toDoRepository.save(task);
        return "redirect:/allTasks";
    }
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        toDoRepository.deleteById(id);
        return "redirect:/allTasks";
    }
    @GetMapping("/editTask/{id}")
    public String editTask(@PathVariable("id") long id, Model model) {
        Task task = toDoRepository.findById(id).orElse(new Task());
        model.addAttribute("task", task);
        model.addAttribute("title", "Edit task");
        return "addTask";
    }
}
