package org.acme.spsp;

import lombok.extern.slf4j.Slf4j;
import org.acme.spsp.service.HouseholdService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpspApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpspApplication.class, args);
        log.info("Found Result: {}", context.getBean(HouseholdService.class).findByEircodeWithPets("D02XY45").toString());
    }

}
