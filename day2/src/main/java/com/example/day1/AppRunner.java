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
public class AppRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(AppRunner.class);
    @Override
    public void run(String... strings) throws Exception {
        final URI path = new ClassPathResource("input.txt").getURI();
        log.debug("URI: " + path);
        String content = new String(Files.readAllBytes(Paths.get(path)));
        log.debug("CONTENT: " + content);
        final int solution = new Checksum().calculate(content);
        log.info("solution: " + solution);
        final int solution2 = new DivisibleChecksum().calculate(content);
        log.info("solution2: " + solution2);
    }
}
