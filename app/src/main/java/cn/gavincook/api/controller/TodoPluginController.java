package cn.gavincook.api.controller;

import cn.gavincook.api.request.AddTodoRequest;
import cn.gavincook.api.request.DeleteTodoRequest;
import cn.gavincook.api.response.TodosResponse;
import cn.gavincook.appservice.ToDoPluginApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gavincook
 * @since 2023-05-15
 */
@RestController
@RequiredArgsConstructor
public class TodoPluginController {

    private final ToDoPluginApplicationService toDoPluginApplicationService;

    @PostMapping("/todos/{username}")
    public void addTodo(@PathVariable String username, @RequestBody AddTodoRequest addTodoRequest) {
        toDoPluginApplicationService.addToDo(username, addTodoRequest);
    }

    @GetMapping("/todos/{username}")
    public TodosResponse getTodos(@PathVariable String username) {
        return toDoPluginApplicationService.getTodos(username);
    }

    @DeleteMapping("/todos/{username}")
    public void deleteTodo(@PathVariable String username, @RequestBody DeleteTodoRequest deleteTodoRequest) {
        toDoPluginApplicationService.deleteTodo(username, deleteTodoRequest);
    }
}
