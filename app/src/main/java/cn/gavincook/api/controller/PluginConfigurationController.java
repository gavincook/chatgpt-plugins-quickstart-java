package cn.gavincook.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Objects;

/**
 * @author gavincook
 * @since 2023-05-15
 */
@RestController
@RequiredArgsConstructor
public class PluginConfigurationController {

    @GetMapping("/logo.png")
    public ResponseEntity<InputStreamResource> getLogo() {
        InputStream logo = getClass().getClassLoader().getResourceAsStream("logo.png");
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(new InputStreamResource(Objects.requireNonNull(logo)));
    }

    @GetMapping("/.well-known/ai-plugin.json")
    public ResponseEntity<InputStreamResource> getAiPlugin() {
        InputStream pluginConfiguration = getClass().getClassLoader().getResourceAsStream("ai-plugin.json");
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new InputStreamResource(Objects.requireNonNull(pluginConfiguration)));
    }

    @GetMapping("/openapi.yaml")
    public ResponseEntity<InputStreamResource> getOpenApi() {
        InputStream openApi = getClass().getClassLoader().getResourceAsStream("openapi.yaml");
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("text/yaml"))
                .body(new InputStreamResource(Objects.requireNonNull(openApi)));
    }

}
