package cn.gavincook.api.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Objects;

/**
 * This controller is used to serve the plugin configuration, no need export as openapi.
 *
 * @author gavincook
 * @since 2023-05-15
 */
@RestController
@RequiredArgsConstructor
@Hidden
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

}
