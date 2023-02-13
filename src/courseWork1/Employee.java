package courseWork1;

public class Employee {
    private int id;
    private String name;
    private int department;
    private int salary;
    private static int i = 0;

    public Employee(String name, int department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        i++;
        id = i;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int dep) {
        department = dep;
    }

    public void setSalary(int sal) {
        salary = sal;
    }

@Override
    public String toString() {
        return "Сотрудник " + id + " отдела " + department + " " + name + ", зарплата " + salary;
    }

}