package ru.otus.java.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 17, 3, 19, 21, 7, 12, 1));
        List<Integer> res = list.stream().filter((elem) -> {
                    if (elem > 10) {
                        return true;
                    } else {
                        return false;
                    }
                }
        ).toList();
        System.out.println(res);

        System.out.println("Начальный список с данными: " + list);

        System.out.println("Значения больше Десяти: " + noStreamApiFilterMoreThanFive(list));
        System.out.println("Значения больше Десяти: " + streamApiFilterMoreThanFive(list));
        System.out.println("Количество нечетных элементов: " + noStreamApiNumberOfOddElement(list));
        System.out.println("Количество нечетных элементов: " + streamApiNumberOfOddElement(list));
        System.out.println("Отсортированный список: " + noStreamApiSort(list));
        System.out.println("Отсортированный список: " + streamApiSort(list));
        System.out.println("Получить 3 минимальных числа : " + noStreamApiThreeMinNumbers(list));
        System.out.println("Получить 3 минимальных числа : " + streamApiThreeMinNumbers(list));
        System.out.println("Получить отсортированный список без 4 самых минимальных чисел: " + noStreamApiSkipFourNumber(list));
        System.out.println("Получить отсортированный список без 4 самых минимальных чисел: " + streamApiSkipFourNumber(list));
        System.out.println("Получить список список уникальных чисел:" + noStreamApiDistinctList(list));
        System.out.println("Получить список список уникальных чисел:" + streamApiDistinctList(list));
        System.out.println("Вывести четное ли число или не четное в консоль:");
        noStreamApiPrintOddInfo(list);
        System.out.println();

        System.out.println("Вывести четное ли число или не четное в консоль:");
        streamApiPrintOddInfo(list);
        System.out.println();

        System.out.println("Увеличить числа меньше 13 на 7: " + noStreamApiIncreaseNumbers(list));
        System.out.println("Увеличить числа меньше 13 на 7: " + streamApiIncreaseNumbers(list));
        System.out.println("Найти среднее для списка чисел : " + noStreamApiAverage(list));
        System.out.println("Найти среднее для списка чисел : " + streamApiAverage(list));
        System.out.println("Сумма всех элементов списка  : " + noStreamApiSumNumbers(list));
        System.out.println("Сумма всех элементов списка  : " + streamApiSumNumbers(list));

        System.out.println("Проверим что все элементы <20 :" + noStreamApiAllMatchNumber(list));
        System.out.println("Проверим что все элементы <20 :" + streamApiAllMatchNumber(list));
        System.out.println("Проверим что Есть хотябы 1 элемент = 5 :" + noStreamApiAnyMatchNumber(list));
        System.out.println("Проверим что Есть хотябы 1 элемент = 5 :" + streamApiAnyMatchNumber(list));
        System.out.println("Проверим что нет ни 1 элемента равного 8 : " + noStreamApiNoneMatchNumber(list));
        System.out.println("Проверим что нет ни 1 элемента равного 8 : " + streamApiNoneMatchNumber(list));

        list.stream().mapToInt(el -> el).sum();
        System.out.println("У нас есть вложенные списки, необходимо распечатать удвоенные элементы: ");
        List<List<Integer>> l1 = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(2);
        one.add(3);

        List<Integer> two = new ArrayList<>();
        two.add(4);
        two.add(5);
        two.add(6);

        l1.add(one);
        l1.add(two);
        System.out.println("Результат: ");
        noStreamApiPrintMultiplyNumbersByTwo(l1);
        System.out.println();
        streamApiPrintMultiplyNumbersByTwo(l1);

    }


    private static void noStreamApiPrintMultiplyNumbersByTwo(List<List<Integer>> l1) {
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l1.get(i).size(); j++) {
                System.out.print(l1.get(i).get(j) * 2 + "; ");
            }
        }
    }
    private static void streamApiPrintMultiplyNumbersByTwo(List<List<Integer>> l1) {
        l1.stream()
                .flatMap(x-> x.stream())
                .map(el -> el*2)
                .forEach(x-> System.out.print(x+ "; "));
    }

    private static List<Integer> noStreamApiFilterMoreThanFive(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 5) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    private static List<Integer> streamApiFilterMoreThanFive(List<Integer> list) {
        return list.stream().filter(el -> el > 5).collect(Collectors.toList());
    }

    private static Integer noStreamApiNumberOfOddElement(List<Integer> list) {
        Integer result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private static Integer streamApiNumberOfOddElement(List<Integer> list) {
        return (int) list.stream().filter(el -> el % 2 == 0).count();
    }

    private static List<Integer> noStreamApiSort(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        for (int i = 0; i < result.size(); i++) {
            int minPosition = i;
            for (int j = i + 1; j < result.size(); j++) {
                if (result.get(j) < result.get(minPosition)) {
                    minPosition = j;
                }
            }
            if (minPosition != i) {
                int temp = result.get(i);
                result.set(i, result.get(minPosition));
                result.set(minPosition, temp);
            }
        }
        return result;
    }

    private static List<Integer> streamApiSort(List<Integer> list) {
        return list.stream().sorted().collect(Collectors.toList());
    }

    private static List<Integer> noStreamApiThreeMinNumbers(List<Integer> list) {
        List<Integer> orderList = noStreamApiSort(list);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            if (i < 3) {
                result.add(orderList.get(i));
            } else {
                return result;
            }
        }
        return result;
    }

    private static List<Integer> streamApiThreeMinNumbers(List<Integer> list) {
        return list.stream().sorted().limit(3).collect(Collectors.toList());
    }

    private static List<Integer> noStreamApiSkipFourNumber(List<Integer> list) {
        List<Integer> orderList = noStreamApiSort(list);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            if (i > 3) {
                result.add(orderList.get(i));
            }
        }
        return result;
    }

    private static List<Integer> streamApiSkipFourNumber(List<Integer> list) {
        return list.stream().sorted().skip(4).collect(Collectors.toList());
    }

    private static List<Integer> noStreamApiDistinctList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!result.contains(list.get(i))) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    private static List<Integer> streamApiDistinctList(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    private static void noStreamApiPrintOddInfo(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            String odd = "";
            if (list.get(i) % 2 == 0) {
                odd = " четное ";
            } else {
                odd = " нечетное ";
            }
            System.out.print(list.get(i) + odd + "число; ");
        }
    }

    private static void streamApiPrintOddInfo(List<Integer> list) {
        list.stream().peek((el) -> {
            System.out.print(el + (el % 2 == 0 ? " четное" : " нечетное") + " число; ");
        }).collect(Collectors.toList());
    }

    private static List<Integer> noStreamApiIncreaseNumbers(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) < 13) {
                result.set(i, result.get(i) + 7);
            }
        }
        return result;
    }

    private static List<Integer> streamApiIncreaseNumbers(List<Integer> list) {
        return list.stream().map(el -> el < 13 ? el + 7 : el).collect(Collectors.toList());
    }

    private static Double noStreamApiAverage(List<Integer> list) {
        Double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum / list.size();
    }

    private static Double streamApiAverage(List<Integer> list) {
        return list.stream().mapToInt(el -> el).average().orElse(0.0);
    }

    private static Integer noStreamApiSumNumbers(List<Integer> list) {
        Integer sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    private static Integer streamApiSumNumbers(List<Integer> list) {
        return list.stream().reduce(0, (el1, el2) -> el1 + el2);
    }

    private static boolean noStreamApiAllMatchNumber(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 20) {
                return false;
            }
        }
        return true;
    }

    private static boolean streamApiAllMatchNumber(List<Integer> list) {
        return list.stream().allMatch(el -> el < 20);
    }

    private static boolean noStreamApiAnyMatchNumber(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(5)) {
                return true;
            }
        }
        return false;
    }

    private static boolean streamApiAnyMatchNumber(List<Integer> list) {
        return list.stream().anyMatch(el -> el.equals(5));
    }


    private static boolean noStreamApiNoneMatchNumber(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(8)) {
                return false;
            }
        }
        return true;
    }

    private static boolean streamApiNoneMatchNumber(List<Integer> list) {
        return list.stream().noneMatch(el -> el.equals(8));
    }
}