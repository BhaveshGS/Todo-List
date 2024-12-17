package com.todo.todo.Service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.todo.todo.DtoClass.Dto;
import com.todo.todo.Exception.ResourceNotFoundException;
import com.todo.todo.JPA_Entity.Todo;
import com.todo.todo.Mapper.mapper;
import com.todo.todo.Repository.Repository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class Serviceimpl implements com.todo.todo.Service.TodoService{
    private Repository repository;
    
    @Override
    public Dto createTodo(Dto dto) {
        Todo todo = mapper.maptoTodo(dto);
        Todo newtask = repository.save(todo);
        return mapper.maptoDto(newtask);
    }

    @Override
    public List<Dto> gettasklist() {
        List<Todo> getalltasks = repository.findAll();
        return getalltasks.stream().map((getonetask) -> mapper.maptoDto(getonetask)).toList();
    }

    @Override
    public Dto updatetasks(Long id, Dto updateddto) {
        Todo entitytobe = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id : " +id+ " is not found"));
        entitytobe.setCompletionstatus(updateddto.getCompletionstatus());
        entitytobe.setCompletiondate(updateddto.getCompletiondate());

        Todo updatedEntity = repository.save(entitytobe);
        return mapper.maptoDto(updatedEntity);
    }

    @Override
    public void DeleteAllTasks() {
        repository.deleteAll();
        repository.resetAutoIncrement();
    }

    @Override
    public void DeleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id : " +id+ " is not found"));
        repository.deleteById(id);
    }
}
