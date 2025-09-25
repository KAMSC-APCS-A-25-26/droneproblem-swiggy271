// DO NOT CHANGE THE CLASS NAME, IT WILL BREAK THE AUTO GRADER
public class DroneAssignment {
    public static void main(String[] args) {
        // Initial drone values
        double altitude = 150.7;
        double battery = 87.3;
        int photos = 0;
        
        System.out.println("=== Drone Flight Simulation ===");
        System.out.println("Initial Status:");
        System.out.println("Altitude: " + altitude + " meters");
        System.out.println("Battery: " + battery + "%");
        System.out.println("Photos: " + photos);
        System.out.println();
        
        // TODO: Part 1 - Casting
        // Cast altitude (double) to int called displayAltitude
        // Cast battery (double) to int called batteryRounded
        // Print them to check your work (optional)
        
        // TODO: Part 2 - Compound Assignment Operators
        // Altitude: Drone climbs 20 meters 
        // Battery: Battery drains 15% 
        // Photos: Drone takes 3 photos 
        // Altitude: Drone descends to half its current altitude 
        // use modulo to calculate storage slots used on photos to calculate storage slots used
        // Display "Photos: " + photos
        // Display "Storage slots used: " + photos + " out of 4"
    }
}
