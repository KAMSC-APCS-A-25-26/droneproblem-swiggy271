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

        int displayAltitude = (int) altitude;
        int batteryRounded = (int) battery;

        System.out.println("\nDisplay altitude: " + displayAltitude);
        System.out.println("Battery rounded: " + batteryRounded);

        displayAltitude += 20;

        System.out.println("\nAfter climbing 20m: " + displayAltitude);

        batteryRounded -= 15;

        System.out.println("After battery drain: " + batteryRounded);

        photos +=3;

        System.out.println("After taking 3 photos: " + photos);
        displayAltitude /= 2;

        System.out.println("After descending to half: " + displayAltitude);



        photos %= 4;
        System.out.println("Photos: " + photos);

        System.out.println("Storage slots used: " + photos + " out of 4");

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
