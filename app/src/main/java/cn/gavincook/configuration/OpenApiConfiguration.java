package cn.gavincook.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author gavincook
 * @since 2023-05-15
 */
@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TODO Plugin")
                        .description("A plugin that allows the user to create and manage a TODO list using ChatGPT. ")
                        .version("v1.0")
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local server"),
                        new Server().url("https://gpt-plugin.gavincook.cn").description("Production server")
                ))
                ;
    }

}
