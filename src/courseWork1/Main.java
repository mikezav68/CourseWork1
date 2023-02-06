package courseWork1;

import courseWork1.Employee;

public class Main {

    static Employee[] employeeBook = new Employee[10];

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
        increaseSalary(10);
        System.out.println("Сотрудник с минимальной зарплатой в отделе 3 - " + findDepartmentMinSalary(3).getName());
        System.out.println("Сотрудник с максимальной зарплатой в отделе 3 - " + findDepartmentMaxSalary(3).getName());
        System.out.println("Сумма зарплат в отделе 3 = " + calculateDepartmentSum(3));
        System.out.println("Средняя зарплата в отделе 3 = " + calculateDepartmentAverageSalary(3));
        increaseDepartmentSalary(3, 5);
        System.out.println("Сотрудники отдела 3:");
        printDepartmentNames(3);
        System.out.println("Сотрудники с зарплатой меньше 40000:");
        printEmployeesLessSalary(40000);
        System.out.println("Сотрудники с зарплатой больше 40000:");
        printEmployeesMoreSalary(40000);
    }

    public static void printEmployeeBook() {
        for (int i = 0; i < employeeBook.length; i++)
        System.out.println(employeeBook[i].toString());
    }

    public static int calculateSum() {
        int sum = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            sum = sum + employeeBook[i].getSalary();
        }
        return sum;
    }

    public static Employee findEmployeeMinSalary() {
        int minSalary = employeeBook[0].getSalary();
        int index = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < minSalary) {
                minSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        return employeeBook[index];
    }

    public static Employee findEmployeeMaxSalary() {
        int maxSalary = employeeBook[0].getSalary();
        int index = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > maxSalary) {
                maxSalary = employeeBook[i].getSalary();
                index = i;
            }
        }
        return employeeBook[index];
    }

    public static int calculateAverageSalary() {
        return calculateSum()/employeeBook.length;
    }

    public static void printNames() {
        for (int i = 0; i < employeeBook.length; i++) {
            System.out.println(employeeBook[i].getName());
        }
    }

    //повышенная сложность
    public static void increaseSalary(int arg) {
        for (int i = 0; i < employeeBook.length; i++) {
            employeeBook[i].setSalary(employeeBook[i].getSalary() + employeeBook[i].getSalary() * arg / 100);
        }
    }

    public static Employee findDepartmentMinSalary(int department) {
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

    public static Employee findDepartmentMaxSalary(int department) {
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

    public static int calculateDepartmentSum(int department) {
        int sum = 0;
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {sum = sum + employeeBook[i].getSalary();}
        }
        return sum;
    }

    public static int calculateDepartmentAverageSalary(int department) {
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

    public static void increaseDepartmentSalary(int department, int arg) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department) {
                employeeBook[i].setSalary(employeeBook[i].getSalary() + employeeBook[i].getSalary() * arg / 100);
            }
        }
    }

    public static void printDepartmentNames(int department) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getDepartment() == department)
                System.out.println("Сотрудник " + employeeBook[i].getId() + " " + employeeBook[i].getName()
                        + ", зарплата " + employeeBook[i].getSalary());
        }
    }

    public static void printEmployeesLessSalary(int number) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() < number) {
                System.out.println(employeeBook[i].toString());
            }
        }
    }

    public static void printEmployeesMoreSalary(int number) {
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i].getSalary() > number) {
                System.out.println(employeeBook[i].toString());
            }
        }
    }
}