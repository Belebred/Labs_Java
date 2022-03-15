package ru.lab1;

public class NewspaperDemo {

    public static void main(String[] args) {
        // set password for newspapers
        Newspaper.setPassword();

        // creating owners
        Owner firstOwner = new Owner("Valeriy", "Bobi-boba");
        Owner secondOwner = new Owner("Vladimir", "Selivanov");

        // trying to set owner of newspapers
        Newspaper.setOwner(firstOwner, "123");
        Newspaper.setOwner(secondOwner, "231");

        System.out.println("\n");

        // creating array of newspapers
        Newspaper[] news = {
        new Newspaper("NY Times", "New-York", 15),
        new Newspaper("Washington Post", "Washington DC", 15000),
        new Newspaper("Moscow Comsomoletz", "Moscow", 200),
        new Newspaper("Novaya Gazeta", "Moscow", 345),
        };

        // printing array of newspapers in console
        for (Newspaper newspaper: news
             ) {
            System.out.println("Your news: " + newspaper.getName() + "\nby: " + Newspaper.getOwner().getName().toCharArray()[0] + "."
                    + Newspaper.getOwner().getSurname() + "\n * * *");
        }
    }
}
