package ait.pomergranate.model;

import java.util.Iterator;
import java.util.List;

public class Pomergranate implements Iterable<Seed>{
    private List<Seed> seeds;
    private Pomergranate(List<Seed> seeds) {
        this.seeds = seeds;
    }
    @Override
    public Iterator<Seed> iterator() {
        return seeds.iterator();
    }
    public int getNumberOfSeeds() {
        return seeds.size();
    }

}
