package ru.lab3;

//TODO: 1. Напишите класс Inventor, имеющий нестатическое поле name.
//      Напишите класс Patent, имеющий нестатические поля
//      - number (номер патента),
//      - topic (тема изобретения),
//      - inventor (типа Inventor). Оба класса в виде POJO.

import java.util.Comparator;
import java.util.Objects;

public class Patent implements Comparable<Patent> {
    private int number;
    private String topic;
    private Inventor inventor;

    public Patent(int number, String topic, Inventor inventor) {
        this.number = number;
        this.topic = topic;
        this.inventor = inventor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patent patent = (Patent) o;
        return number == patent.number && topic.equals(patent.topic) && inventor.equals(patent.inventor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, topic, inventor);
    }

    @Override
    public String toString() {
        return "Patent with " +
                "number: " + number +
                ", topic: " + topic  +
                "; by " + inventor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Inventor getInventor() {
        return inventor;
    }

    public void setInventor(Inventor inventor) {
        this.inventor = inventor;
    }

    @Override
    public int compareTo(Patent o) {
        return this.getTopic().compareTo(o.getTopic());
    }

    static class NumberComparator implements Comparator<Patent>{

        @Override
        public int compare(Patent o1, Patent o2) {
            return o1.getNumber() - o2.getNumber();
        }
    }

    static class InventorComparator implements Comparator<Patent>{

        @Override
        public int compare(Patent o1, Patent o2) {
            return o1.getInventor().getName().compareTo(o2.getInventor().getName());
        }
    }
}
