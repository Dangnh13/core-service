package jp.afterfit.core.api;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "jp.afterfit.core")
@MapperScan(basePackages = "jp.afterfit.core.persistence.dao")
@Slf4j
public class ApiApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }

}
