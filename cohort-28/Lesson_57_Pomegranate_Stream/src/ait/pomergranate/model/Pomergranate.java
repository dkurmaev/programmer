package ait.pomergranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pomergranate implements Iterable<Seed> {
    List<Seed> seeds;

    public Pomergranate() {
        seeds = new ArrayList<>();
    }

    public Pomergranate(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public void setSeeds(List<Seed> seeds) {
        this.seeds = seeds;
    }

    public boolean addSeed(Seed seed) {
        return seeds.add(seed);
    }

    public int quantity() {
        return seeds.size();
    }

    public double weight() {
        return seeds.stream()
                .map(s -> s.getWeight())
                .reduce(0.0, (accum, item) -> accum + item);
    }

    @Override
    public Iterator<Seed> iterator() {
        return seeds.iterator();
    }
}
