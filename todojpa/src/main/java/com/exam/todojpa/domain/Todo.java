package com.exam.todojpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@Entity
public class Todo {
	@Id
	@GeneratedValue
	private Long id;
	private String todo;
	private boolean done;
	
	public Todo(){
        this.done = false;
    }

    @ApiModelProperty(
            name = "id"
            , example = "1"
        )
    @ApiParam(value = "ToDo ID", required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    
    @ApiModelProperty(
            name = "todo"
            , example = "visit hospital"
        )
    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isDone() {
        return done;
    }

    @ApiModelProperty(
            name = "done"
            , example = "false"
        )
    public void setDone(boolean done) {
        this.done = done;
    }
	
	
}