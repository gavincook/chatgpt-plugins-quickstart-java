package cn.gavincook.api.response;

import lombok.Data;

import java.util.List;

/**
 * @author gavincook
 * @since 2023-05-15
 */
@Data
public class TodosResponse {
    private final List<String> todos;
}
