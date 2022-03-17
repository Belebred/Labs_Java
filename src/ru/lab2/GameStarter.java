package ru.lab2;

public class GameStarter {
    public static void main(String[] args) {
        Athlete[] athletes = {
                new Athlete("Al"),
                new Athlete("Bl"),
                new Athlete("Cl"),
                new Athlete("Dl")
        };

        Skiing skiing = new Skiing(10);
        Shooting shooting = new Shooting( 5);
        Swimming swimming = new Swimming();

        Game game = new Game(new Competition[]{skiing, shooting, swimming}, athletes);

        game.Start();
    }
}
