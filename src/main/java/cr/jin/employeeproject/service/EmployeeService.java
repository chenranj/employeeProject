package cr.jin.employeeproject.service;

import cr.jin.employeeproject.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployee();
    List<Employee> getEmployeesOverAge(Integer age);
    void createNewEmployee(String name, Integer age);
    void deleteEmployee(Long id);
}
