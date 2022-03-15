package ru.lab1;

import java.util.Date;
import java.util.Scanner;

//TODO: Напишите класс Newspaper (газета), имеющий поля:
// название,
// город,
// год основания,
// количество статей в одном выпуске.
//
//TODO: Напишите класс Owner (владелец), добавьте в класс Newspaper статическое поле Owner.
// Реализуйте основные принципы инкапсуляции, предусмотрите возможность смены владельца только по паролю.
// Напишите 2 параметризованных конструктора класса Newspaper.
//
//TODO: Напишите класс NewspaperDemo, создающий несколько объектов класса Newspaper и записывающий их в массив.
// Распечатайте массив в консоль, используя цикл foreach.
//
//TODO: Считайте с консоли любое предложение в переменную типа String.
// Отдельные слова этого предложения запишите в массив, не используя метод split()


public class Newspaper {
    private String name;
    private String city;
    private Date date;
    private int value;
//  same owner for all newspapers
    public static Owner owner;
    public static String password;

//  Constructor 1
    public Newspaper(String name, String city, Integer value){
        this.name = name;
        this.city = city;
        this.date = new Date();
        this.value = value;
    }
    // Constructor 2
    public Newspaper(String name, String city) {
        this.name = name;
        this.city = city;
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public Integer getValue() {
        return value;
    }

    public static Owner getOwner() {
        return owner;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public void setCity(String city, String password) {

        this.city = city;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setOwner(Owner owner, String password) {
        if(Newspaper.password.equals(password)) {
            Newspaper.owner = owner;
            System.out.println("The new owner is: " + owner.getName() + " " + owner.getSurname());
        }
        else System.out.println(">>>>> Error, wrong password");
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public static void setPassword() {

        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();

        if (Newspaper.password != null) {
            if (pass.equals(Newspaper.password)) {
                Newspaper.password = pass;
            }
            else System.out.println("WRONG PASSWORD");
        }

        Newspaper.password = pass;
    }
}
