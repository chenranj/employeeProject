package cr.jin.employeeproject.controller;

import cr.jin.employeeproject.entity.Employee;
import cr.jin.employeeproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceImpl") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "getAgeOver/{age}")
    public ResponseEntity<List<Employee>> getEmployeeByAgeOver(@PathVariable(name = "age") Integer age) {
        return new ResponseEntity<List<Employee>>(employeeService.getEmployeesOverAge(age), HttpStatus.OK);
    }

    @PostMapping
    public void createNewEmployee(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        employeeService.createNewEmployee(name, age);
    }

    @GetMapping
    public List<Employee> getALlEmployee() {
        return employeeService.getAllEmployee();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
