import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DroneAssignmentTest {

    private String runProgramWithInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream origOut = System.out;
        java.io.InputStream origIn = System.in;

        System.setIn(in);
        System.setOut(new PrintStream(outBytes));
        try {
            DroneAssignment.main(new String[]{});
        } finally {
            System.setOut(origOut);
            System.setIn(origIn);
        }

        return outBytes.toString(StandardCharsets.UTF_8);
    }

    private static List<Double> extractDoubles(String output) {
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        Matcher m = p.matcher(output);
        List<Double> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Double.parseDouble(m.group(1)));
        }
        return numbers;
    }

    private static List<Integer> extractIntegers(String output) {
        Pattern p = Pattern.compile("\\b(\\d+)\\b");
        Matcher m = p.matcher(output);
        List<Integer> numbers = new ArrayList<>();
        while (m.find()) {
            numbers.add(Integer.parseInt(m.group(1)));
        }
        return numbers;
    }

    @Test
    public void testInitialValuesDisplayed() {
        String input = "";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("150.7"), "❌ Initial altitude 150.7 should be displayed!");
        assertTrue(output.contains("87.3"), "❌ Initial battery 87.3% should be displayed!");
        assertTrue(output.contains("Photos: 0"), "❌ Initial photos count 0 should be displayed!");
        assertTrue(output.contains("Initial Status:"), "❌ 'Initial Status:' header should be displayed!");
    }

    @Test
    public void testCastingPart1() {
        String input = "";
        String output = runProgramWithInput(input);

        List<Integer> integers = extractIntegers(output);
        
        boolean hasDisplayAltitude = integers.contains(150);
        assertTrue(hasDisplayAltitude, "❌ Part 1: Should cast altitude 150.7 to int 150!");
        
        boolean hasBatteryRounded = integers.contains(87);
        assertTrue(hasBatteryRounded, "❌ Part 1: Should cast battery 87.3 to int 87!");
    }

    @Test
    public void testCompoundAssignmentOperators() {
        String input = "";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        List<Integer> integers = extractIntegers(output);

        boolean hasClimbedAltitude = integers.contains(170) || integers.contains(85);
        assertTrue(hasClimbedAltitude, "❌ Part 2: Should climb altitude by 20m then descend to half!");
        
        boolean hasDrainedBattery = integers.contains(72);
        assertTrue(hasDrainedBattery, "❌ Part 2: Should drain battery by 15%!");
        
        boolean hasUpdatedPhotos = integers.contains(3);
        assertTrue(hasUpdatedPhotos, "❌ Part 2: Should take 3 photos!");
    }

    @Test
    public void testModuloStorageSlots() {
        String input = "";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Storage slots used") || output.contains("storage slots"), 
            "❌ Should display storage slots calculation!");
        
        assertTrue(output.contains("Storage slots used: 3") || output.contains("storage slots used: 3"), 
            "❌ Should show storage slots used as 3 (3 % 4 = 3)!");
        
        assertTrue(output.contains("Photos: 3") || output.contains("photos: 3"), 
            "❌ Should show photos as 3!");
    }

    @Test
    public void testModuloThreeFour() {
        String input = "";
        String output = runProgramWithInput(input);

        // This test specifically verifies that 3 % 4 = 3 is being used
        // We check that the final photos value is 3, which can only come from 3 % 4 = 3
        // If they used a different modulo operation, the result would be different
        
        // Extract the final photos value from output
        String[] lines = output.split("\n");
        int finalPhotos = -1;
        int storageSlots = -1;
        
        for (String line : lines) {
            if (line.contains("Photos:") && line.contains("3")) {
                // Extract the number after "Photos: "
                String[] parts = line.split("Photos:");
                if (parts.length > 1) {
                    String numberPart = parts[1].trim().split("\\s+")[0];
                    try {
                        finalPhotos = Integer.parseInt(numberPart);
                    } catch (NumberFormatException e) {
                        // Ignore parsing errors
                    }
                }
            }
            if (line.contains("Storage slots used:") && line.contains("3")) {
                // Extract the number after "Storage slots used: "
                String[] parts = line.split("Storage slots used:");
                if (parts.length > 1) {
                    String numberPart = parts[1].trim().split("\\s+")[0];
                    try {
                        storageSlots = Integer.parseInt(numberPart);
                    } catch (NumberFormatException e) {
                        // Ignore parsing errors
                    }
                }
            }
        }
        
        // Verify that both values are 3, which proves 3 % 4 = 3 was used
        assertTrue(finalPhotos == 3, "❌ Final photos should be 3 (result of 3 % 4)!");
        assertTrue(storageSlots == 3, "❌ Storage slots should be 3 (result of 3 % 4)!");
        
        // Additional check: verify the mathematical relationship
        assertTrue(finalPhotos == storageSlots, "❌ Photos and storage slots should be equal (both = 3 % 4)!");
    }

    @Test
    public void testModuloCompoundAssignment() {
        String input = "";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Photos: 3"), "❌ Should show Photos: 3 (result of photos %= 4)!");
        assertTrue(output.contains("Storage slots used: 3"), "❌ Should show Storage slots used: 3 (result of photos %= 4)!");

    }

    @Test
    public void testSummaryOutput() {
        String input = "";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Photos") || output.contains("photos"), "❌ Should display photos summary!");
        assertTrue(output.contains("Storage slots used"), "❌ Must display 'Storage slots used' exactly!");
        assertTrue(output.contains("out of 4"), "❌ Should show 'out of 4' for storage slots!");
    }

    @Test
    public void testSummaryValuesCorrect() {
        String input = "";
        String output = runProgramWithInput(input);

        List<Double> doubles = extractDoubles(output);
        List<Integer> integers = extractIntegers(output);

        boolean hasCorrectAltitude = integers.contains(85);
        assertTrue(hasCorrectAltitude, "❌ Summary altitude should be 85m!");

        boolean hasCorrectBattery = integers.contains(72);
        assertTrue(hasCorrectBattery, "❌ Summary battery should be 72%!");

        boolean hasCorrectPhotos = integers.contains(3);
        assertTrue(hasCorrectPhotos, "❌ Summary photos should be 3!");
    }

    @Test
    public void testProgramStructure() {
        String input = "";
        String output = runProgramWithInput(input);

        assertTrue(output.contains("Drone") || output.contains("drone"), "❌ Should display drone-related content!");
        assertTrue(output.length() > 50, "❌ Program should produce meaningful output!");
        
        assertTrue(output.contains("Status") || output.contains("status") || 
                   output.contains("Initial") || output.contains("Final"), 
            "❌ Program should display status information!");
    }

    @Test
    public void testAllOperationsPerformed() {
        String input = "";
        String output = runProgramWithInput(input);

        // Verify that all required operations are performed by checking for their results
        List<Double> doubles = extractDoubles(output);
        List<Integer> integers = extractIntegers(output);

        int operationCount = 0;
        if (integers.contains(150)) operationCount++; // Casting altitude
        if (integers.contains(87)) operationCount++;  // Casting battery
        if (integers.contains(170)) operationCount++; // Climbing
        if (integers.contains(72)) operationCount++;  // Battery drain
        if (integers.contains(3)) operationCount++;   // Photo taking
        if (integers.contains(85)) operationCount++;  // Descending
        if (output.contains("Storage slots used")) operationCount++; // Modulo operation

        assertTrue(operationCount >= 5, "❌ Should perform most of the required operations! Found evidence of " + operationCount + " operations.");
    }

    @Test
    public void testNoCompilationErrors() {
        String input = "";
        String output = runProgramWithInput(input);

        assertFalse(output.contains("Exception"), "❌ Program should not throw exceptions!");
        assertFalse(output.contains("Error"), "❌ Program should not display error messages!");
        assertTrue(output.length() > 50, "❌ Program should produce meaningful output!");
    }
}
