package lesson_04.code.annotation.selfMadeAnnotation2;

import java.lang.annotation.Annotation;

public class TestCustomAnnotationEmployee {
    public static void main(String[] args) {

        CustomAnnotationEmployee employee = new CustomAnnotationEmployee(1, "John");
        employee.getEmployeeDetails();

        Annotation companyAnnotation = employee
                .getClass()
                .getAnnotation(Company.class);

        Company company = (Company) companyAnnotation;

        System.out.println("Company name: " + company.name());
        System.out.println("Company city: " + company.city());


        CustomAnnotationEmployee2 employee2 = new CustomAnnotationEmployee2(2, "Bill");
        employee2.getEmployeeDetails();

        companyAnnotation = employee2
                .getClass()
                .getAnnotation(Company.class);

        company = (Company) companyAnnotation;

        System.out.println("Company name: " + company.name());
        System.out.println("Company city: " + company.city());

    }
}
