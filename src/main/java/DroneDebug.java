// DO NOT CHANGE THE CLASS NAME, IT WILL BREAK THE AUTO GRADER
public class DroneDebug {
    public static void main(String[] args) {
        // Drone surveillance mission with syntax errors
        double flightHeight = 300.7;
        double fuelLevel = 78.2;
        int surveillancePhotos = 5;
        int missionTime = 0;
        
        System.out.println("=== Drone Surveillance Mission ===");
        System.out.println("Mission Status:");
        System.out.println("Flight Height: " + flightHeight + " meters");
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("Surveillance Photos: " + surveillancePhotos);
        System.out.println("Mission Time: " + missionTime + " minutes");
        System.out.println();
        
        // TODO: Fix the syntax errors below
        
        // Part 1 - Casting for drone display
        int displayHeight = (int) flightHeight
        
        int fuelRounded = (int) fuelLevel;
        int fuelRounded = (int) fuelLevel;
        
        int timeInt = int missionTime;
        
        // Part 2 - Mission operations
        flightHeight += 50
        
        fuelLevel -= 15
        
        surveillancePhotos += 8
        
        flightHeight *= 0.6
        
        surveillancePhotos %= 6
        
        missionTime += 45
        
        // Part 3 - Mission report
        System.out.println(Flight Height Display: + displayHeight);
        
        System.out.println("Fuel Level Rounded: " + fuelRounded);
        
        System.out.println("Surveillance Photos: " + surveillancePhotos)
        
        int dataSlots = surveillancePhotos % 6
        System.out.println("Data storage slots used: " + dataSlots + " out of 6");
        
        System.out.println("Mission Duration: " + missionTime + " minutes")
    }
