package courseWork1;

import courseWork1.Employee;

public class Main {

    private static Employee[] employeeBook = new Employee[10];

    public static void main(String[] args) {
        employeeBook[0] = new Employee("Антонов Кирилл Сергеевич", 2, 30000);
        employeeBook[1] = new Employee("Сергеев Иван Иванович", 3, 26000);
        employeeBook[2] = new Employee("Алексеева Зинаида Викторовна", 1, 42000);
        employeeBook[3] = new Employee("Татаринцев Антон Иванович", 5, 44000);
        employeeBook[4] = new Employee("Спарков Кеттлер Сяомович", 4, 41500);
        employeeBook[5] = new Employee("Маркова Алла Владимировна", 2, 48650);
        employeeBook[6] = new Employee("Завьялова Ирина Сергеевна", 1, 36400);
        employeeBook[7] = new Employee("Давлатов Константин Евгеньевич", 3, 39000);
        employeeBook[8] = new Employee("Пассатов Гольф Джеттович", 5, 41150);
        employeeBook[9] = new Employee("Скорпионов Игорь Михайлович", 4, 32500);
        printEmployeeBook();
        System.out.println("Сумма всех зарплат = " + calculateSum());
        System.out.println("Сотрудник с минимальной зарплатой - " + findEmployeeMinSalary().getName());
        System.out.println("Сотрудник с максимальной зарплатой - " + findEmployeeMaxSalary().getName());
        System.out.println("Средняя зарплата = " + calculateAverageSalary());
        printNames();
        //повышенная сложность
        int percent = 10;
        increaseSalary(percent);
        int department = 3;
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + department + " - " + findDepartmentMinSalary(department).getName());
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + department + " - " + findDepartmentMaxSalary(department).getName());
        System.out.println("Сумма зарплат в отделе 3 = " + calculateDepartmentSum(department));
        System.out.println("Средняя зарплата в отделе 3 = " + calculateDepartmentAverageSalary(department));
        percent = 5;
        increaseDepartmentSalary(department, percent);
        System.out.println("Сотрудники отдела 3:");
        printDepartmentNames(department);
        int salary = 40000;
        System.out.println("Сотрудники с зарплатой меньше " + salary + ":");
        printEmployeesLessSalary(salary);
        System.out.println("Сотрудники с зарплатой больше " + salary + ":");
        printEmployeesMoreSalary(salary);
    }

    private static void printEmployeeBook() {
        for (int i = 0; i < employeeBook.length; i++)
        System.out.println(employeeBook[i].toString());
    }

    private static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            sum = sum + employeeBook[i].getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeMinSalary() {
        int minSalary = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < minSalary) {
                minSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        return employeeBook[index];
    }

    private static Employee findEmployeeMaxSalary() {
        int maxSalary = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > maxSalary) {
                maxSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        return employeeBook[index];
    }

    private static double calculateAverageSalary() {
        return (double) calculateSum()/employeeBook.length;
    }

    private static void printNames() {
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println(employeeBook[i].getName());
        }
    }

    //повышенная сложность
    private static void increaseSalary(int arg) {
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i].setSalary(employeeBook[i].getSalary() + employeeBook[i].getSalary() * arg / 100);
        }
    }

    private static Employee findDepartmentMinSalary(int department) {
        int minSalary = 100000;
        int index = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < minSalary && employeeBook[i].getDepartment() == department) {
                minSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        return employeeBook[index];
    }

    private static Employee findDepartmentMaxSalary(int department) {
        int maxSalary = 0;
        int index = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > maxSalary && employeeBook[i].getDepartment() == department) {
                maxSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        return employeeBook[index];
    }

    private static int calculateDepartmentSum(int department) {
        int sum = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {sum = sum + employeeBook[i].getSalary();}
        }
        return sum;
    }

    private static int calculateDepartmentAverageSalary(int department) {
        int employeeQuantity = 0;
        int sum = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {
                sum = sum + employeeBook[i].getSalary();
                employeeQuantity++;
            }
        }
        return sum/employeeQuantity;
    }

    private static void increaseDepartmentSalary(int department, int arg) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {
                employeeBook[i].setSalary(employeeBook[i].getSalary() + employeeBook[i].getSalary() * arg / 100);
            }
        }
    }

    private static void printDepartmentNames(int department) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department)
                System.out.println("Сотрудник " + employeeBook[i].getId() + " " + employeeBook[i].getName()
                        + ", зарплата " + employeeBook[i].getSalary());
        }
    }

    private static void printEmployeesLessSalary(int number) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < number) {
                System.out.println(employeeBook[i].toString());
            }
        }
    }

    private static void printEmployeesMoreSalary(int number) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > number) {
                System.out.println(employeeBook[i].toString());
            }
        }
    }
}