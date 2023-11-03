import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.*;

public class Company {

    public static void main(String[] args) {


    // Load Initial Data Set
    {
        new Employee("John Carter", "Physics", 30, 3000);
        new Employee("Alice Johnson", "Engineering", 28, 3500);
        new Employee("Bob Smith", "Marketing", 32, 4000);
        new Employee("Eva Williams", "Human Resources", 25, 3200);
        new Employee("David Davis", "Finance", 29, 3900);
        new Employee("Sophia Miller", "Sales", 27, 3700);
        new Employee("Liam Wilson", "Information Technology", 31, 4200);
        new Employee("Olivia Brown", "Customer Support", 26, 3300);
        new Employee("Noah Moore", "Research and Development", 33, 4100);
        new Employee("Mia Taylor", "Operations", 30, 3600);
        new Employee("Jackson Evans", "Legal", 28, 3400);
        new Employee("Ava Martinez", "Product Management", 29, 3700);
        new Employee("Logan Anderson", "Quality Assurance", 27, 3200);
        new Employee("Emma Johnson", "Sales", 31, 3800);
        new Employee("Liam Thomas", "Engineering", 30, 3900);
        new Employee("Olivia White", "Human Resources", 32, 3500);
        new Employee("Mason Harris", "Finance", 29, 4200);
        new Employee("Sophia Martin", "Customer Support", 26, 3300);
        new Employee("Aiden Clark", "Research and Development", 33, 4100);
        new Employee("Chloe Baker", "Operations", 27, 3600);
        new Employee("Lucas Scott", "Legal", 28, 3400);
        new Employee("Madison Lewis", "Product Management", 30, 3700);
        new Employee("Ethan Walker", "Quality Assurance", 31, 3800);
        new Employee("Charlotte Hall", "Marketing", 29, 3900);
        new Employee("Aiden Davis", "Information Technology", 32, 3500);
        new Employee("Scarlett Harris", "Sales", 27, 3200);
        new Employee("Jackson Martin", "Engineering", 30, 3900);
        new Employee("Sophia Mitchell", "Human Resources", 28, 3300);
        new Employee("Lucas Johnson", "Finance", 33, 4100);
        new Employee("Emma Lee", "Customer Support", 26, 3600);
        new Employee("Noah Thomas", "Research and Development", 31, 4200);
        new Employee("Ava Hall", "Operations", 29, 3700);
        new Employee("Oliver Wilson", "Legal", 27, 3400);
        new Employee("Isabella Miller", "Product Management", 32, 3500);
        new Employee("Liam Jones", "Quality Assurance", 30, 3800);
        new Employee("Mia Davis", "Marketing", 33, 3900);
        new Employee("Ethan Martinez", "Information Technology", 26, 3600);
        new Employee("Ava Jackson", "Sales", 28, 3200);
        new Employee("Logan Harris", "Engineering", 31, 3900);
        new Employee("Charlotte Scott", "Human Resources", 27, 3300);
        new Employee("Olivia White", "Finance", 29, 4100);
        new Employee("Mason Taylor", "Customer Support", 32, 3700);
        new Employee("Sophia Davis", "Research and Development", 30, 3800);
        new Employee("Ethan Smith", "Operations", 28, 3600);
        new Employee("Aiden Wilson", "Legal", 33, 3500);
        new Employee("Liam Turner", "Product Management", 26, 3900);
        new Employee("Emma Lewis", "Quality Assurance", 27, 3200);
        new Employee("Olivia Brown", "Marketing", 31, 4100);
        new Employee("Noah Adams", "Information Technology", 29, 3300);
        new Employee("Ava Evans", "Sales", 32, 3700);
        new Employee("Lucas Moore", "Engineering", 30, 3600);
    }

    // Store all employees in a Collection
    ArrayList<Employee> allEmployees = Employee.getAllEmployees();

    // List of employees including Name and Department only.
    Function<Employee, String> getNameAndDepartment = employee -> "Name: " + employee.getName() + ", Department: " + employee.getDepartment() + "\n";

    List<String> namesAndDepartments = allEmployees.stream()
        .map(getNameAndDepartment)
        .collect(Collectors.toList());


    // Calculate the average salary of te company.
    Double averageSalary = allEmployees.stream()
        .mapToDouble(employee -> employee.getSalary())
        .reduce(0, (a, b) -> a + b) / Employee.getTotal();


    // Filter all employees older than 30 years old
    List<Employee> thirtyAndAbove = allEmployees.stream()
        .filter(employee -> employee.getAge() > 30)
        .collect(Collectors.toList());


    // Output Results
    System.out.println(namesAndDepartments);
    System.out.println(averageSalary);
    System.out.println(thirtyAndAbove);


    }

}

public class Employee {

    private static HashMap<Integer, Employee> allEmployees = new HashMap<>();
    private static int total = 0;

    private String name;
    private String department;
    private int age;
    private int salary;
    private final int id;


    // Constructor
    public Employee(String name, String department,int age, int salary) {

        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;

        total++;
        this.id = 100 + total;

        allEmployees.put(id, this);

    }

    public static ArrayList<Employee> getAllEmployees() {
        return new ArrayList<>(allEmployees.values());
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Name: " + this.getName());
        string.append(", Department: " + this.getDepartment());
        string.append(", Age: " + this.getAge());
        string.append(", Salary: " + this.getSalary());
        string.append(", ID: " + this.getId());

        return string.toString();
    }


    public static int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }


}
