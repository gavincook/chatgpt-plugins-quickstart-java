package cn.gavincook.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                );
    }

}
