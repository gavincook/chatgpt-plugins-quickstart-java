package cn.gavincook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author gavincook
 * @since 2023-05-15
 */
@Slf4j
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        StopWatch watch = new StopWatch("【chatgpt plugins quick start】 Application startup");
        watch.start();
        ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        watch.stop();
        if (context.isRunning()) {
            log.info(watch.prettyPrint());
        }
    }
}
