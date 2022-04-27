package ru.lab8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class HeadphonesDemo {
    public static void main(String[] args) {
        List<Headphone> headphones = List.of(
                new Headphone(1,"SVEN", "AP-010MV SVEN","серебристый",499,3.4),
                new Headphone(2,"Defender Warhead G-120", "Defender","оранжевый",799,4.1),
                new Headphone(4,"SVEN","AP-670MV SVEN","черный",1199,3.4),
                new Headphone(5,"Qumo Party Cat","Qumo","черный",	1499,	3.6),
                new Headphone(6	," Jet.A GHP-100"	,"DEXP"	,"желтый"	,1599	,4.1),
                new Headphone(7	,"Logitech H111"	,"Logitech"	,"серый"	,1799	,4.6),
                new Headphone(8	,"DEXP GH-400 Armor"	,"DEXP"	,"серый"	,1999	,4.2),
                new Headphone(9	,"JBL TUNE 560BT"	,"Logitech"	,"синий"	,2499	,4.6),
                new Headphone(10	,"SE-M531"	,"Logitech"	,"черный"	,2799	,4.2));

//        1.	Отсортируйте наушники по наименованию.
        System.out.println("Сортировка по наименованию:\n" + headphones.stream()
                .sorted(comparing(Headphone::name)).toList());

//        2.	Отсортируйте наушники по цене.
        System.out.println("\nСортировка по цене:\n" + headphones.stream()
                .sorted(comparing(Headphone::price)).toList());

//        3.	Найдите наушники с наименьшей оценкой покупателей.
        System.out.println("\nНаименьшая цена:\n" + headphones.stream()
                .min(comparing(Headphone::price)));

//        4.	Создайте коллекцию наушников не черного цвета.
        List<Headphone> notBlack = headphones.stream()
                .filter(x -> !x.colour().equals("чёрный")).toList();
        System.out.println("\nНе чёрные наушники\n" + notBlack);

//        5.	Рассчитайте среднюю оценку покупателей, используя числовой стрим.
        System.out.println("\nСредняя оценка покупателей: " + headphones.stream()
                .mapToDouble(Headphone::rate).average());

//        6.	Рассчитайте количество наушников стоимостью более 1000 руб.
        System.out.println("\nКоличество наушников дороже 1000р: " + headphones.stream()
                .filter(x -> x.price()<1000).count());

//        7.	Проверьте, у всех ли наушников оценка покупателей больше 4.
        System.out.println("\nУ всех наушников оценка больше 4: " + headphones.stream()
                .allMatch(x -> x.rate() > 4d));

//        8.	Проверьте, есть ли наушники марки Qumo.
        System.out.println("\nНаушники марки Qumo присутствуют: " + headphones.stream()
                .anyMatch(x -> x.mark().equals("Qumo")));

//        9.	Найдите самые дешёвые наушники, используя minBy().
        System.out.println("\nСамые дешёвые наушники: " + headphones.stream()
                .collect(minBy(comparing(Headphone :: price))));

//        10.	Разделите все наушники на 2 коллекции: с оценкой больше 4,5 и меньше 4,5.
        Map<Boolean, List<Headphone>> dividedHeadphones = headphones.stream()
                .collect(partitioningBy(x -> x.rate() > 4.5f));
        System.out.println("\nОценка больше 4.5:\n" + dividedHeadphones.get(true)
                + "\nОценка меньше 4.5\n" + dividedHeadphones.get(false));

//        11.	Для каждой марки посчитайте количество наушников и среднюю цену.
        System.out.println("\nКоличество у марки:\n" + headphones.stream()
                .collect(groupingBy(Headphone::mark, counting())));

        System.out.println("\nСредняя цена у марки:\n" + headphones.stream()
                .collect(groupingBy(Headphone::mark, averagingDouble(Headphone::price))));

//        12.	Сформируйте строку «Модели наушников марки Logitech: …, … .».
        System.out.println("\nМодели наушников марки Logitech: " + String.join(", ",
                headphones.stream()
                        .filter(x -> x.mark().equals("Logitech")).map(Headphone::name).toList()));
        System.out.println("\nThe end\n");
    }
}
