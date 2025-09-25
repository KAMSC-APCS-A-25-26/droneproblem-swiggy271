[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Izywqebd)
# Drone Assignment - Casting & Compound Assignment Operators

## **Objective**
Practice Java casting and compound assignment operators by simulating a drone flight with changing altitude, battery, and photo count.

## **Requirements**

### **Initial Setup**
Your program starts with these drone values:
- **Altitude**: 150.7 meters (double)
- **Battery**: 87.3% (double)  
- **Photos**: 0 (int)

### **Part 1 – Casting**
The drone's display screen can only show whole numbers.

1. Cast the altitude (double) into an `int` called `displayAltitude`
2. Cast the battery (double) into an `int` called `batteryRounded`
3. Print them to check your work (optional)

### **Part 2 – Compound Assignment Operators**
Simulate changes during the flight using compound operators:

1. **Altitude**: Drone climbs 20 meters 
2. **Battery**: Battery drains 15 percentage points (subtract 15 from battery value)
3. **Photos**: Drone takes 3 photos 
4. **Altitude**: Drone descends to half its current altitude 
5. **Photos**: Use modulo to calculate storage slots used on photos

### **Part 3 – Display Results**
Display the final results with flexible wording, but must include:
- **Photos**: Show the final photo count
- **Storage slots used**: Show "Storage slots used: X out of 4" (exact phrase required)

## **Program Structure**
```java
// DO NOT CHANGE THE CLASS NAME, IT WILL BREAK THE AUTO GRADER
public class DroneAssignment {
    public static void main(String[] args) {
        // Initial drone values
        double altitude = 150.7;
        double battery = 87.3;
        int photos = 0;
        
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
```

**⚠️ Important**: Do not change the class name `DroneAssignment` as it will break the autograder!

## **Expected Output**
Your program should display something like:
```
=== Drone Flight Simulation ===
Initial Status:
Altitude: 150.7 meters
Battery: 87.3%
Photos: 0

Display Altitude: 150
Battery Rounded: 87

After climbing 20m: 170
After battery drain: 72
After taking 3 photos: 3
After descending to half: 85
Photos: 3
Storage slots used: 3 out of 4
```

