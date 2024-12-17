package com.todo.todo.Mapper;

import com.todo.todo.DtoClass.Dto;
import com.todo.todo.JPA_Entity.Todo;

public class mapper {
    public static Dto maptoDto(Todo todo){
        return new Dto(
            todo.getId(),
            todo.getTaskname(),
            todo.getTaskdeadline(),
            todo.getCompletionstatus(),
            todo.getCompletiondate()
        );
    }

    public static Todo maptoTodo(Dto dto){
        return new Todo(
            dto.getId(),
            dto.getTaskname(),
            dto.getTaskdeadline(),
            dto.getCompletionstatus(),
            dto.getCompletiondate()
        );
    }
}
