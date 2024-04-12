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
        int paymentCounter = 0;

        for (Employee employee : employees) {
            bankService.makePayment(employee.getBankId(),employee.getSalary());
            paymentCounter++;
        }

        return paymentCounter;
    }
}
