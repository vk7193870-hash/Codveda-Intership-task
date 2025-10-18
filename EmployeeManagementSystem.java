import java.util.ArrayList;
import java.util.Scanner;

// Employee class
class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display method
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Salary: ₹" + salary);
    }
}

// Main class
public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Method to add employee
    public static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        employees.add(new Employee(id, name, salary));
        System.out.println("✅ Employee added successfully!\n");
    }

    // Method to view all employees
    public static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employee records found.\n");
            return;
        }
        System.out.println("\n=== Employee List ===");
        for (Employee emp : employees) {
            emp.display();
        }
        System.out.println();
    }

    // Method to update employee details
    public static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                sc.nextLine();
                String newName = sc.nextLine();

                System.out.print("Enter new salary: ");
                double newSalary = sc.nextDouble();

                emp.setName(newName);
                emp.setSalary(newSalary);
                System.out.println("✅ Employee details updated successfully!\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Employee not found.\n");
        }
    }

    // Method to delete employee
    public static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        boolean removed = employees.removeIf(emp -> emp.getId() == id);

        if (removed) {
            System.out.println("✅ Employee deleted successfully!\n");
        } else {
            System.out.println("❌ Employee not found.\n");
        }
    }

    // Main menu
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        } while (choice != 5);

        sc.close();
    }
}
