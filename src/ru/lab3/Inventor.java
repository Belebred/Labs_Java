package ru.lab3;

//TODO: 1. Напишите класс Inventor, имеющий нестатическое поле name.
//      Напишите класс Patent, имеющий нестатические поля
//      - number (номер патента),
//      - topic (тема изобретения),
//      - inventor (типа Inventor). Оба класса в виде POJO.
//
//TODO: 2. В классе PatentDemo создайте массив, содержащий 3 объекта класса Patent. Распечатайте в консоль этот массив,
//      отсортированный по номеру, теме изобретения, имени изобретателя,
//      используя интерфейсы Comparable<Patent> и Comparator<Patent>.
//
//TODO: 3. Выполните пп. 1 и 2, заменив обычный класс Patent на record класс PatentRecord.

import java.util.Comparator;
import java.util.Objects;

public class Inventor {
    private String name;

    public Inventor(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventor inventor = (Inventor) o;
        return name.equals(inventor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
