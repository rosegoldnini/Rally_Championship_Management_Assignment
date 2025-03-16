package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ChampionshipManager {
    private static ChampionshipManager instance;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++; // in this case it uses and then increments (adds) the variable totalDrivers.
    }

    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() {
        List<Driver> standings = new ArrayList<>(drivers);

        standings.sort(new Comparator<Driver>() { //sorts through the points from largest to smallest
            @Override
            public int compare(Driver d1, Driver d2) {
                return Integer.compare(d2.getPoints(), d1.getPoints());
            }
        });

        return standings;
    }

    public static Driver getLeadingDriver() {
        if (instance == null || instance.drivers.isEmpty()) { // || = "or" operator
            return null;
        }
        List<Driver> standings = instance.getDriverStandings();
        return standings.get(0);
    }

    public static int getTotalChampionshipPoints() {
        int totalPoints = 0;
        if (instance != null) { //adds to driver points to get championship points
            for (Driver driver : instance.drivers) {
                totalPoints += driver.getPoints();
            }
        }
        return totalPoints;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

}


