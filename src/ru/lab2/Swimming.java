package ru.lab2;

import java.util.Arrays;
import java.util.Random;

public class Swimming implements Competition{
    private Athlete[] athletes;
    private int distance;
    private final Random random;

    public Swimming() {
        this.random = new Random();
        this.distance = random.nextInt(50);
    }

    @Override
    public Athlete[] Start(Athlete[] athletes) {
        for (Athlete athlete:athletes
             ) {
            if (athlete.getReady()){
                int res = random.nextInt(50);
                athlete.setReady(random.nextInt(50) <= distance);
                athlete.setResult(res);
            }
        }
        System.out.println(Arrays.toString(athletes));
        return athletes;
    }


    public Athlete[] getAthletes() {
        return athletes;
    }

    public void setAthletes(Athlete[] athletes) {
        this.athletes = athletes;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
