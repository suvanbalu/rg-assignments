import java.util.ArrayList;
import java.util.List;

public class EmployeeCrud {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, String name, String department) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(name);
                employee.setDepartment(department);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }

    public static void main(String[] args) {
        EmployeeCrud crud = new EmployeeCrud();
        crud.addEmployee(new Employee(1, "Suvan", "SDE"));
        crud.addEmployee(new Employee(2, "Balu", "Marketing"));

        System.out.println("Initially:");
        for (Employee emp : crud.employees) {
            System.out.println(emp.getName() + " in " + emp.getDepartment());
        }

        crud.updateEmployee(1, "Suvan", "Finance");
        System.out.println("\nAfter Update:");
        for (Employee emp : crud.employees) {
            System.out.println(emp.getName() + " in " + emp.getDepartment());
        }

        crud.deleteEmployee(1);
        System.out.println("\nAfter Deletion:");
        for (Employee emp : crud.employees) {
            System.out.println(emp.getName() + " in " + emp.getDepartment());
        }
    }
}