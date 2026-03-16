package jdbcpractice;

import java.sql.*;
import java.util.*;

public class JDBCdemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection conn = EmployeeDAO.getConnection();

            while (true) {

                System.out.println("\nChoose an operation:");
                System.out.println("1. Create Employee Table");
                System.out.println("2. View All Employees");
                System.out.println("3. View Employee By ID");
                System.out.println("4. Insert Employee");
                System.out.println("5. Update Employee");
                System.out.println("6. Delete Employee");
                System.out.println("7. Drop Table");
                System.out.println("8. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        EmployeeDAO.createTable(conn);
                        System.out.println("Employee table ensured.");
                        break;

                    case 2:

                        List<Employee> list = EmployeeDAO.readAll(conn);

                        if (list.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            for (Employee e : list) {
                                System.out.println(e);
                            }
                        }

                        break;

                    case 3:

                        System.out.print("Enter Employee ID: ");
                        int rid = sc.nextInt();

                        Employee emp = EmployeeDAO.readById(conn, rid);

                        if (emp == null)
                            System.out.println("Employee not found");
                        else
                            System.out.println(emp);

                        break;

                    case 4:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        int salary = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();

                        Employee newEmp = new Employee(id, name, salary, dept, phone);

                        Employee inserted = EmployeeDAO.insert(conn, newEmp);

                        if (inserted != null)
                            System.out.println("Inserted: " + inserted);
                        else
                            System.out.println("Insertion failed");

                        break;

                    case 5:

                        System.out.print("Enter Employee ID to update: ");
                        int uid = sc.nextInt();

                        System.out.print("Enter new Salary: ");
                        int newSalary = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Department: ");
                        String newDept = sc.nextLine();

                        Employee updateEmp = new Employee(uid, "", newSalary, newDept, "0");

                        Employee updated = EmployeeDAO.update(conn, uid, updateEmp);

                        if (updated != null)
                            System.out.println("Updated: " + updated);
                        else
                            System.out.println("Employee not found");

                        break;

                    case 6:

                        System.out.print("Enter Employee ID to delete: ");
                        int did = sc.nextInt();

                        Employee deleted = EmployeeDAO.delete(conn, did);

                        if (deleted != null)
                            System.out.println("Deleted: " + deleted);
                        else
                            System.out.println("Employee not found");

                        break;

                    case 7:

                        EmployeeDAO.dropTable(conn);
                        System.out.println("Employee table dropped.");

                        break;

                    case 8:

                        conn.close();
                        System.out.println("Program terminated.");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Employee {

    private int id;
    private String name;
    private int salary;
    private String department;
    private String phoneNo;

    public Employee(int id, String name, int salary, String department, String phoneNo) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.phoneNo = phoneNo;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getSalary() { return salary; }

    public String getDepartment() { return department; }

    public String getPhoneNo() { return phoneNo; }

    public void setSalary(int salary) { this.salary = salary; }

    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | " + department + " | " + phoneNo;
    }
}

class EmployeeDAO {

    public static Connection getConnection() throws Exception {

        return java.sql.DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/EmployeeDB",
                "postgres",
                "tiger"
        );
    }


    public static void createTable(Connection conn) throws Exception {

        String sql = """
                CREATE TABLE IF NOT EXISTS employee(
                id INT PRIMARY KEY,
                name VARCHAR(50),
                salary INT,
                department VARCHAR(50),
                phoneno BIGINT)
                """;

        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        stmt.close();
    }


    public static Employee insert(Connection conn, Employee emp) throws Exception {

        PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO employee VALUES (?, ?, ?, ?, ?)"
        );

        pstmt.setInt(1, emp.getId());
        pstmt.setString(2, emp.getName());
        pstmt.setInt(3, emp.getSalary());
        pstmt.setString(4, emp.getDepartment());
        pstmt.setString(5, emp.getPhoneNo());

        int rows = pstmt.executeUpdate();
        pstmt.close();

        if (rows > 0)
            return emp;

        return null;
    }


    public static List<Employee> readAll(Connection conn) throws Exception {

        List<Employee> list = new ArrayList<>();

        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee");

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("salary"),
                    rs.getString("department"),
                    rs.getString("phoneno")
            );

            list.add(emp);
        }

        rs.close();
        pstmt.close();

        return list;
    }


    public static Employee readById(Connection conn, int id) throws Exception {

        PreparedStatement pstmt = conn.prepareStatement(
                "SELECT * FROM employee WHERE id=?"
        );

        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {

            Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("salary"),
                    rs.getString("department"),
                    rs.getString("phoneno")
            );

            rs.close();
            pstmt.close();
            return emp;
        }

        rs.close();
        pstmt.close();
        return null;
    }


    public static Employee update(Connection conn, int id, Employee emp) throws Exception {

        Employee existing = readById(conn, id);

        if (existing == null)
            return null;

        PreparedStatement pstmt = conn.prepareStatement(
                "UPDATE employee SET salary=?, department=? WHERE id=?"
        );

        pstmt.setInt(1, emp.getSalary());
        pstmt.setString(2, emp.getDepartment());
        pstmt.setInt(3, id);

        pstmt.executeUpdate();
        pstmt.close();

        existing.setSalary(emp.getSalary());
        existing.setDepartment(emp.getDepartment());

        return existing;
    }


    public static Employee delete(Connection conn, int id) throws Exception {

        Employee existing = readById(conn, id);

        if (existing == null)
            return null;

        PreparedStatement pstmt = conn.prepareStatement(
                "DELETE FROM employee WHERE id=?"
        );

        pstmt.setInt(1, id);

        pstmt.executeUpdate();
        pstmt.close();

        return existing;
    }


    public static void dropTable(Connection conn) throws Exception {

        Statement stmt = conn.createStatement();

        stmt.execute("DROP TABLE IF EXISTS employee");

        stmt.close();
    }
}