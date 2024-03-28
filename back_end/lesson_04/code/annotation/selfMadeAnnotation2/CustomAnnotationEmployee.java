package lesson_04.code.annotation.selfMadeAnnotation2;

@Company
public class CustomAnnotationEmployee {
    private int id;
    private String name;

    public CustomAnnotationEmployee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void getEmployeeDetails(){
        System.out.println("Employee Id = " + id);
        System.out.println("Employee Name = " + name);
    }
}
