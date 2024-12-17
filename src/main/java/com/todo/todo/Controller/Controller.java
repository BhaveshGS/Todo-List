package com.todo.todo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo.DtoClass.Dto;
import com.todo.todo.Service.TodoService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@AllArgsConstructor
@RestController
@RequestMapping(value = "api/todo")
public class Controller {
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<List<Dto>> createTodoList(@RequestBody List<Dto> dtoList) {
        List<Dto> dtosReceived = dtoList.stream().map(todoService::createTodo).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(dtosReceived);
    }

    @GetMapping
    public ResponseEntity<List<Dto>> getTaskList() {
        List<Dto> dtoreceive = todoService.gettasklist();
        return ResponseEntity.ok(dtoreceive);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Dto> updateTasks(@PathVariable("id") Long id, @RequestBody Dto dto){
        Dto dtoreceive = todoService.updatetasks(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoreceive);
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteAllTasks(){
        todoService.DeleteAllTasks();
        return ResponseEntity.ok("Deleted all tasks");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        todoService.DeleteById(id);
        return ResponseEntity.ok("Deleted Id:"+id);
    }
}
