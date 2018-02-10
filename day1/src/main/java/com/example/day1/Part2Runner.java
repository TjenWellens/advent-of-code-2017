package com.example.day1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Part2Runner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Part2Runner.class);
    @Override
    public void run(String... strings) throws Exception {
        final URI path = new ClassPathResource("input.txt").getURI();
        String content = new String(Files.readAllBytes(Paths.get(path)));
        final int solution = new VariableOffsetCaptchaSolver().solve(content);
        log.info("solution part 2: " + solution);
    }
}
