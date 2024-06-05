package ru.otus.java.basic.emp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    public static void main(String[] args) {
        List<Employee> employees = generateData();

        System.out.println("Выведите всех мэнеджеров(ФИО) из списка сотрудников: ");
        System.out.println("Managers: " + getManagers(employees));
        System.out.println();

        System.out.println("Расчитайте суммарную зп всех сотрудников: ");
        System.out.println("Суммарная зп = : " + sumZpEmployees(employees));
        System.out.println();

        System.out.println("Распечатайте сотрудника с самой высокой зп: ");
        System.out.println("сотрудник: " + getMaxZpEmployee(employees));
        System.out.println();

        System.out.println("Сгруппируйте сотрудников по должности: ");
        Map<String, List<Employee>> employeeByJob = getEmployeeByJob(employees);
        employeeByJob.forEach((jobName, empList) ->
                System.out.println("Должность: " + jobName + " ; Список сотрудников: " + empList)
        );

        System.out.println();

        System.out.println("Проиндексируем ЗП всем сотрудникам на 10% ");
        System.out.println("Сотрудники после индексации: ");
        System.out.println();

        System.out.println("Вычислим среднее значения зп всех сотрудников: ");
        System.out.println("среднее значение : ");
        System.out.println();

        System.out.println("Вычислим среднее значения зп Мэнеджеров : ");
        System.out.println("среднее значение : ");
        System.out.println();

        System.out.println("Вычислим сотрудников у которых День рождения в тек. месяце: ");
        System.out.println("сотрудники : ");
        System.out.println();

    }

    private static Map<String, List<Employee>> getEmployeeByJob(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(employee -> employee.getJobName()));
    }

    private static Employee getMaxZpEmployee(List<Employee> employees) {
        return employees.stream().max(Comparator.comparing(el -> el.getSalary())).orElse(null);
    }

    private static Double sumZpEmployees(List<Employee> employees) {
        return employees.stream().mapToDouble(el -> el.getSalary()).sum();
    }

    private static List<String> getManagers(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getJobName().equals("Manager"))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    private static List<Employee> generateData() {
        return Arrays.asList(
                new Employee("Alice", LocalDate.of(1985, 6, 15), "Manager", 5000.0),
                new Employee("Bob", LocalDate.of(1990, 8, 22), "Developer", 4000.0),
                new Employee("Charlie", LocalDate.of(1988, 11, 10), "Manager", 4500.0)
        );
    }
}