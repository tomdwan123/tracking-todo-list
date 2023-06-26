package com.lifung.trackingtask.tracking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Task> tasks = taskService.findAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Task task) {
        taskService.add(task);
        return new ResponseEntity<>("Created new Task successfully!", HttpStatus.CREATED);
    }
}
