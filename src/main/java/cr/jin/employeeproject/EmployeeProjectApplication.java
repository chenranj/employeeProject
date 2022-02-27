package cr.jin.employeeproject;

import cr.jin.employeeproject.service.EmployeeService;
import cr.jin.employeeproject.service.EmployeeServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;


@SpringBootApplication
public class EmployeeProjectApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmployeeProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeServiceImpl employeeService) {
        return (args) -> {
            employeeService.createNewEmployee("Chenran Jin", 25);
            employeeService.createNewEmployee("John Doe", 71);
            for (int i = 1; i < 101; i++) {
                employeeService.createNewEmployee(String.valueOf(i), new Random().ints(18, 80).findFirst().getAsInt());
            }
            employeeService.deleteEmployee(Long.valueOf(50));
        };
    }
}
