package ru.lab2;

import java.util.Arrays;
import java.util.Random;

public class Skiing implements Competition{
    private Athlete[] athletes;
    private int distance;
    private Random random;

    public Skiing( int distance) {
        this.random = new Random();
        this.distance = random.nextInt(30,60);
    }

    @Override
    public Athlete[] Start(Athlete[] athletes) {
        for (Athlete athlete:athletes
        ) {
            if (athlete.getReady()){
                int res = random.nextInt(60);
                athlete.setReady(random.nextInt(60) <= distance);
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
