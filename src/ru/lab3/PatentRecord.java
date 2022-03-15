package ru.lab3;

import java.util.Comparator;

public record PatentRecord(int number, String topic, Inventor inventor) implements Comparable<PatentRecord>{

    @Override
    public int compareTo(PatentRecord o) {
        return topic.compareTo(o.topic);
    }
    static class NumberComparator implements Comparator<PatentRecord> {

        @Override
        public int compare(PatentRecord o1, PatentRecord o2) {
            return o1.number() - o2.number();
        }
    }

    static class InventorComparator implements Comparator<PatentRecord>{

        @Override
        public int compare(PatentRecord o1, PatentRecord o2) {
            return o1.inventor().getName().compareTo(o2.inventor().getName());
        }
    }
}
