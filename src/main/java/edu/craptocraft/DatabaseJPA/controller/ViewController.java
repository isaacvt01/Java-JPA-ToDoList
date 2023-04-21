package edu.craptocraft.DatabaseJPA.controller;

import edu.craptocraft.DatabaseJPA.model.Task;
import edu.craptocraft.DatabaseJPA.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("task")
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
    public String addTask(Task task, SessionStatus status) {
        toDoRepository.save(task);
        status.setComplete();
        return "redirect:/allTasks";
    }
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        toDoRepository.deleteById(id);
        return "redirect:/allTasks";
    }
    @GetMapping("/addTask/{id}")
    public String editTask(@PathVariable("id") long id, Model model) {
        Task task = null;
        if (id > 0) {
            Optional<Task> optionalTask = toDoRepository.findById(id);
            if (optionalTask.isPresent()) {
                task = optionalTask.get();
            }
        }
        model.addAttribute("task", task);
        model.addAttribute("title", "Edit task");
        return "addTask";
    }
}
