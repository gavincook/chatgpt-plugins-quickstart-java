package cn.gavincook.appservice;

import cn.gavincook.api.request.AddTodoRequest;
import cn.gavincook.api.request.DeleteTodoRequest;
import cn.gavincook.api.response.TodosResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gavincook
 * @since 2023-05-15
 */
@Service
public class ToDoPluginApplicationService {
    private final Map<String, List<String>> todos = new ConcurrentHashMap<>();

    public void addToDo(String username, AddTodoRequest addTodoRequest) {
        if (!todos.containsKey(username)) {
            todos.put(username, new ArrayList<>());
        }
        todos.get(username).add(addTodoRequest.getTodoItem());
    }

    public TodosResponse getTodos(String username) {
        return new TodosResponse(todos.getOrDefault(username, Collections.emptyList()));
    }

    public void deleteTodo(String username, DeleteTodoRequest deleteTodoRequest) {
        List<String> todos = this.todos.get(username);
        if (todos != null) {
            todos.remove(deleteTodoRequest.getTodoIdx().intValue());
        }
    }
}
