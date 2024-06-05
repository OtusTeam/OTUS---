package ru.otus.java.basic.emp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeService {
    public static void main(String[] args) {
        List<Employee> employees = generateData();

        System.out.println("Выведите всех мэнеджеров(ФИО) из списка сотрудников: ");
        System.out.println("Managers: ");
        System.out.println();

        System.out.println("Расчитайте суммарную зп всех сотрудников: ");
        System.out.println("Суммарная зп = : ");
        System.out.println();

        System.out.println("Распечатайте сотрудника с самой высокой зп: ");
        System.out.println("сотрудник: ");
        System.out.println();

        System.out.println("Сгруппируйте сотрудников по должности: ");
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

    private static List<Employee> generateData() {
        return Arrays.asList(
                new Employee("Alice", LocalDate.of(1985, 6, 15), "Manager", 5000.0),
                new Employee("Bob", LocalDate.of(1990, 8, 22), "Developer", 4000.0),
                new Employee("Charlie", LocalDate.of(1988, 11, 10), "Manager", 4500.0)
        );
    }
}
