package com.todo.todo.JPA_Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo")

public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Task Name")
    private String taskname;
    
    @Column(name = "Task Deadline")
    private LocalDate taskdeadline;
    
    @Column(name = "Task Completion Status")
    private String completionstatus;

    @Column(name = "Task Completion Date")
    private LocalDate completiondate;

    @PrePersist
    private void prePersist() {
        if (this.completionstatus == null) {
            this.completionstatus = "Not done";
        }
    }
}
