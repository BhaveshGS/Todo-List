package com.todo.todo.DtoClass;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Dto {
    private Long id;
    private String taskname;
    private LocalDate taskdeadline;
    private String completionstatus;
    private LocalDate completiondate;
}
