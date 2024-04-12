package org.testspringboot.mockitoTest2;

import java.util.List;

public class PayRoll {

    private EmployeeDB employeeDB;
    private BankService bankService;

    public PayRoll(EmployeeDB employeeDB, BankService bankService) {
        this.employeeDB = employeeDB;
        this.bankService = bankService;
    }

    public int monthlyPayment() {
        List<Employee> employees = employeeDB.getAllEmployees();

//        for (int i = 0; i < employees.size(); i++) {
//            bankService.makePayment(employees.get(i).getBankId(), employees.get(i).getSalary());
//        }
//
        for (Employee employee : employees) {
            bankService.makePayment(employee.getBankId(),employee.getSalary());
        }

        return employees.size();
    }
}
