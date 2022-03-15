package ru.lab3;

//TODO: 2. В классе PatentDemo создайте массив, содержащий 3 объекта класса Patent.
//      Распечатайте в консоль этот массив, отсортированный
//      по номеру,
//      теме изобретения,
//      имени изобретателя,
//      используя интерфейсы Comparable<Patent> и Comparator<Patent>.

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Random;

public class PatentDemo {
    public static void main(String[] args) {

        Random rand = new Random();

        // inventors for patents
        Inventor SleepInventor = new Inventor("Sleeper");
        Inventor LongInventor = new Inventor("Long");

        //В классе PatentDemo создайте массив, содержащий 3 объекта класса Patent
        Patent[] patents =
                {
                new Patent(2, "GetOver", SleepInventor),
                new Patent(4, "Well Enough", LongInventor),
                new Patent(5, "Aurelio", SleepInventor)
        };

        System.out.println("\nDefault compare by topic:");
        Arrays.sort(patents);
        System.out.println(Arrays.toString(patents));
        System.out.println();

        System.out.println("Custom compare by number:");
        Arrays.sort(patents, new Patent.NumberComparator());
        System.out.println(Arrays.toString(patents));

        System.out.println("\nCustom compare by Inventor:");
        Arrays.sort(patents, new Patent.InventorComparator());
        System.out.println(Arrays.toString(patents));

        PatentRecord[] patentRecords =
                {
                        new PatentRecord(1, "Warum", LongInventor),
                        new PatentRecord(3, "Es geht", LongInventor),
                        new PatentRecord(6, "Argenio", SleepInventor)
                };

        System.out.println("\n***\nRecord objects");

        System.out.println("\nDefault compare by topic:");
        Arrays.sort(patentRecords);
        System.out.println(Arrays.toString(patentRecords));
        System.out.println();

        System.out.println("Custom compare by number:");
        Arrays.sort(patentRecords, new PatentRecord.NumberComparator());
        System.out.println(Arrays.toString(patentRecords));

        System.out.println("\nCustom compare by Inventor:");
        Arrays.sort(patentRecords, new PatentRecord.InventorComparator());
        System.out.println(Arrays.toString(patentRecords));
    }
}
