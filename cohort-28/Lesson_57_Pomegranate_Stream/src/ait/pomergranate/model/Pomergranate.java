package ait.pomergranate.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pomergranate implements Iterable<Seed> {
    private List<Seed> seeds;

    public Pomergranate(int numSeeds) {
        seeds = Stream.generate(Seed::new).limit(numSeeds).collect(Collectors.toList());
    }
    @Override
    public Iterator<Seed> iterator() {
        return seeds.iterator();
    }
    public int getNumSeeds(){
        return seeds.size();
    }
}
