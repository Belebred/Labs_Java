package ru.lab2;

import java.util.Arrays;
import java.util.Random;

public class Shooting implements Competition{
    private Athlete[] athletes;
    private int result;
    private Random random;

    public Shooting(int result) {
        this.result = result;
        this.random = new Random();
    }

    public Athlete[] getAthletes() {
        return athletes;
    }

    public void setAthletes(Athlete[] athletes) {
        this.athletes = athletes;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public Athlete[] Start(Athlete[] athletes) {
        for (Athlete athlete:athletes) {
        if (athlete.getReady()) {
            int res = random.nextInt(60);
            athlete.setReady(res <= result);
            athlete.setResult(res);
            }
        }
        System.out.println(Arrays.toString(athletes));
        return athletes;
    }

}
