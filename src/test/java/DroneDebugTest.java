import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class DroneDebugTest {
    
    private String runProgramWithInput(String input) {
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", "DroneDebug");
            Process process = pb.start();
            
            // Send input to the process
            if (!input.isEmpty()) {
                OutputStreamWriter writer = new OutputStreamWriter(process.getOutputStream());
                writer.write(input);
                writer.close();
            }
            
            // Read output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            // Read error output
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder errorOutput = new StringBuilder();
            while ((line = errorReader.readLine()) != null) {
                errorOutput.append(line).append("\n");
            }
            
            int exitCode = process.waitFor();
            
            // If there are compilation errors, return the error output
            if (exitCode != 0) {
                return "COMPILATION_ERROR: " + errorOutput.toString();
            }
            
            return output.toString();
        } catch (Exception e) {
            return "ERROR: " + e.getMessage();
        }
    }
    
    private List<Integer> extractIntegers(String output) {
        List<Integer> integers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(output);
        while (matcher.find()) {
            try {
                integers.add(Integer.parseInt(matcher.group()));
            } catch (NumberFormatException e) {
                // Ignore parsing errors
            }
        }
        return integers;
    }
    
    @Test
    public void testCompilationSuccess() {
        String input = "";
        String output = runProgramWithInput(input);
        
        // The main test - program should compile and run without errors
        assertFalse(output.contains("COMPILATION_ERROR"), 
            "❌ Fix all syntax errors! The program should compile successfully.");
        
        // Should produce some output (not just empty)
        assertTrue(output.length() > 20, "❌ Program should produce output!");
    }
    
    @Test
    public void testProgramRuns() {
        String input = "";
        String output = runProgramWithInput(input);
        
        // Program should run without crashing
        assertFalse(output.contains("ERROR:"), 
            "❌ Program should run without errors!");
        
        // Should contain some drone-related output
        assertTrue(output.contains("Drone") || output.contains("Mission") || output.contains("Surveillance"), 
            "❌ Program should display drone mission information!");
    }
    
    @Test
    public void testBasicOutput() {
        String input = "";
        String output = runProgramWithInput(input);
        
        // Should display some numbers (any numbers are fine)
        List<Integer> integers = extractIntegers(output);
        assertTrue(integers.size() > 0, "❌ Program should display some numbers!");
        
        // Should have some text output
        assertTrue(output.contains(":") || output.contains("="), 
            "❌ Program should display formatted output!");
    }
}
