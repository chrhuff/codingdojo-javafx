package de.cofinpro.codingdojo.client;

import java.util.Random;
import javax.inject.Singleton;

/**
 * Dummy service. Implement backend calls here.
 */
public class EvoteService {
    private Random rnd = new Random();

    public int nextInt() {
        return rnd.nextInt();
    }
}