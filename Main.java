/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "Lacshini@4326"
            );

            Statement stmt = con.createStatement();

            String query = "INSERT INTO employee (name, department, salary) VALUES ('Lakshu', 'IT', 50000)";
            stmt.executeUpdate(query);

            System.out.println("Employee Inserted Successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "Lacshini@4326"
            );

            String query = "INSERT INTO employee (name, department, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setDouble(3, salary);

            ps.executeUpdate();

            System.out.println("Employee Inserted Successfully!");
            // VIEW ALL EMPLOYEES
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            System.out.println("\nEmployee List:");
            while (rs.next()) {
                System.out.println(
                rs.getInt("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("department") + " | " +
                rs.getDouble("salary")
            );
}
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/* */

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db",
                "root",
                "Lacshini@4326"
            );

            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO employee(name, department, salary) VALUES (?, ?, ?)"
                        );
                        ps.setString(1, name);
                        ps.setString(2, dept);
                        ps.setDouble(3, salary);
                        ps.executeUpdate();

                        System.out.println("Employee Inserted Successfully!");
                        break;

                    case 2:
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

                        System.out.println("\nEmployee List:");
                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("department") + " | " +
                                rs.getDouble("salary")
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Enter Employee ID to Update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        PreparedStatement psUpdate = con.prepareStatement(
                            "UPDATE employee SET salary=? WHERE id=?"
                        );
                        psUpdate.setDouble(1, newSalary);
                        psUpdate.setInt(2, updateId);
                        psUpdate.executeUpdate();

                        System.out.println("Employee Updated Successfully!");
                        break;

                    case 4:
                        System.out.print("Enter Employee ID to Delete: ");
                        int deleteId = sc.nextInt();

                        PreparedStatement psDelete = con.prepareStatement(
                            "DELETE FROM employee WHERE id=?"
                        );
                        psDelete.setInt(1, deleteId);
                        psDelete.executeUpdate();

                        System.out.println("Employee Deleted Successfully!");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}