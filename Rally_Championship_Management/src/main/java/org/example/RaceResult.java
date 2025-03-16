package org.example;

import java.util.List;

public interface RaceResult {
    public void recordResult(Driver driver, int position, int points);
    public int getDriverPoints(int driver);
    List<Driver> getResults();
}
