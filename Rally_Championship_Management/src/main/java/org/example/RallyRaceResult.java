package org.example;

import java.util.*;

class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new HashMap<>();
    private Map<Driver, Integer> positions = new HashMap<>();

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        positions.put(driver, position);
        driver.addPoints(points);
    }

    @Override
    public int getDriverPoints(int driver) {
        return results.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults() { //sorting list
        List<Driver> sortedDrivers = new ArrayList<>(results.keySet());
        sortedDrivers.sort(new Comparator<Driver>() {
            @Override
            public int compare(Driver d1, Driver d2) {
                return results.get(d1).compareTo(results.get(d2));
            }
        });
        return sortedDrivers;
    }
}