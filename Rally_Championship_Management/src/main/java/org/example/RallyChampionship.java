package org.example;

import java.util.*;

import static org.example.ChampionshipManager.*;

public class RallyChampionship {
    public static void main(String[] args) {
        //everything is made up
        ChampionshipManager championshipManager = getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France", new AsphaltCar("Citroen", "C4", 420, 0.2));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new GravelCar("Hyundai", "IONIQ 5", 400, 0.3));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Toyota", "Corolla", 380, 0.4));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Ford", "F-150", 360, 0.5));

        championshipManager.registerDriver(driver1);
        championshipManager.registerDriver(driver2);
        championshipManager.registerDriver(driver3);
        championshipManager.registerDriver(driver4);

        driver1.addPoints(50);
        driver2.addPoints(40);
        driver3.addPoints(30);
        driver4.addPoints(20);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");

        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);

        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);

        championshipManager.addRaceResult(race1);
        championshipManager.addRaceResult(race2);

        championshipManager.getDriverStandings();

        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        List<Driver> standings = championshipManager.getDriverStandings();
        for (int i = 0; i < standings.size(); i++) { //sort drivers by points
            Driver driver = standings.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====\n" + getLeadingDriver().getName() + " with " + getLeadingDriver().getPoints() + " points");

        Driver loser = standings.get(standings.size() - 1); //list is sorted from most to least points so -1 index indicates the last person on the list
        System.out.println("\n===== CHAMPIONSHIP LOSER =====\n" + loser.getName() + " with " + loser.getPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(standings));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(standings));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        List<RallyRaceResult> allResults = new ArrayList<>();
        allResults.add(race1);
        allResults.add(race2);

        for (RallyRaceResult race : allResults) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            List<Driver> results = race.getResults();

            results.sort((d1, d2) -> Integer.compare(d2.getPoints(), d1.getPoints()));
            for (int i = 0; i < results.size(); i++) {
                Driver driver = results.get(i);
                System.out.println("\tPosition " + (i + 1) + ": " + driver.getName() + " - " + driver.getPoints() + " points");
            }
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        for (Driver driver : standings) {
            RallyCar car = (RallyCar) driver.getCar();
            System.out.println(driver.getName() + ": " + car.getMake() + " " + car.getModel() +
                    " Performance: " + car.calculatePerfomance());
        }
    }
}

