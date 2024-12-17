package com.todo.todo.Service;

import java.util.List;

import com.todo.todo.DtoClass.Dto;

public interface TodoService {

    Dto createTodo(Dto dto);

    List<Dto> gettasklist();

    Dto updatetasks(Long id, Dto dto);

    void DeleteAllTasks();

    void DeleteById(Long id);

}
