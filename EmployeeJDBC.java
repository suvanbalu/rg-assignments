import java.sql.*;

public class EmployeeJDBC {
    private Connection conn;

    public EmployeeJDBC(String url, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url,"root",password);
    }


    public void addEmployee(Employee emp) throws SQLException {
        String query = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, emp.getId());
            stmt.setString(2, emp.getName());
            stmt.setString(3, emp.getDepartment());
            stmt.executeUpdate();
        }
    }


    public Employee getEmployee(int id) throws SQLException {
        String query = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
                }
            }
        }
        return null;
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String query = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setInt(3, emp.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    public static void main(String[] args) {
        try {
            EmployeeJDBC employeeJDBC = new EmployeeJDBC("jdbc:mysql://localhost:3306/paypal_rg","tiger");

            Employee newEmployee = new Employee(1, "Suvan", "SDE");
            employeeJDBC.addEmployee(newEmployee);

            Employee readEmployee = employeeJDBC.getEmployee(1);
            System.out.println("Employee: " + readEmployee.getName());
            System.out.println(readEmployee.getDepartment());
            System.out.println(readEmployee.getId());

            newEmployee.setName("Balu");
            employeeJDBC.updateEmployee(newEmployee);
            Employee emp = employeeJDBC.getEmployee(1);

            System.out.println("Updated Record : "+ emp.getName());
            employeeJDBC.deleteEmployee(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
