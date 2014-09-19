package de.cofinpro.codingdojo.client;

import java.util.Random;
import javax.inject.Singleton;

public class EvoteService {
    private Random rnd = new Random();

    public int nextInt() {
        return rnd.nextInt();
    }
}