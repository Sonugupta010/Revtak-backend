package com.revtaskmanagement.RevTask.Controller;

import com.revtaskmanagement.RevTask.DTO.TaskDTO;
import com.revtaskmanagement.RevTask.DTO.TaskDetailDTO;
import com.revtaskmanagement.RevTask.Entity.Task;
import com.revtaskmanagement.RevTask.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDetailDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskDetailDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }


    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/task/{projectId}")
    public List<TaskDetailDTO> getTasksByProjectId(@PathVariable Long projectId) {
        return taskService.getTasksByProjectId(projectId);
    }

    // praveena edit
    @PostMapping("/createTasks")
    public Task createTask1(@RequestBody Task task, @RequestParam Long memberId) {
        return taskService.createTask1(task, memberId);
    }
}
