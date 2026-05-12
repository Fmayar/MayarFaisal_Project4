import java.io.*;
import java.util.*;

public class WardenService {
    private static final String CSV_FILE = "wardens.csv";

    public List<Warden> loadWardens() {
        List<Warden> wardens = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", -1);

                if (data.length == 10) {
                    wardens.add(new Warden(
                            data[0], data[1], data[2], data[3], data[4],
                            data[5], data[6], data[7], data[8], data[9]
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: Could not read wardens.csv. Please make sure the file exists in this folder.");
        }

        return wardens;
    }

    public void viewAllWardens() {
        List<Warden> wardens = loadWardens();

        System.out.println();
        System.out.println("VIEW ALL WARDENS");
        System.out.println("This data is loaded from wardens.csv as a read-only database snapshot.");
        System.out.println("No records are changed, added, or deleted.");
        System.out.println();

        System.out.printf("%-8s %-12s %-12s %-30s %-14s %-22s %-12s %-12s %-10s %-18s%n",
                "ID", "FIRST", "LAST", "EMAIL", "PHONE", "ROLE", "STATUS",
                "HIRE_DATE", "CLEARANCE", "SECTOR");

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Warden warden : wardens) {
            warden.printRow();
        }

        System.out.println();
        System.out.println("Result: SUCCESS — All Warden records displayed across all statuses.");
    }

    public boolean identityExists(String wardenId, String email) {
        List<Warden> wardens = loadWardens();

        for (Warden warden : wardens) {
            if (warden.getWardenId().equalsIgnoreCase(wardenId)
                    || warden.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    public void addNewWarden(Scanner scanner) {
        System.out.println();
        System.out.println("ADD NEW WARDEN");
        System.out.println("This action validates input and prints a simulated outbound request.");
        System.out.println("No data will be written to wardens.csv.");
        System.out.println();

        String wardenId;
        String email;

        while (true) {
            wardenId = ValidationUtil.promptRequired(scanner, "Warden ID");
            email = ValidationUtil.promptRequired(scanner, "Email");

            if (!identityExists(wardenId, email)) {
                break;
            }

            System.out.println("ERROR: Duplicate identity found. Warden ID or email already exists in the read-only seed data.");
            System.out.println("Please enter a unique Warden ID and email.");
        }

        String firstName = ValidationUtil.promptRequired(scanner, "First Name");
        String lastName = ValidationUtil.promptRequired(scanner, "Last Name");
        String phone = ValidationUtil.promptOptional(scanner, "Phone");

        String role = ValidationUtil.promptFromList(scanner, "Role",
                new String[]{"Containment Warden", "Field Warden", "Training Warden", "Research Warden", "Senior Warden"});

        String status = ValidationUtil.promptFromList(scanner, "Status",
                new String[]{"Active", "Inactive", "Terminated"});

        String hireDate = ValidationUtil.promptDate(scanner, "Hire Date");

        String clearanceLevel = ValidationUtil.promptFromList(scanner, "Clearance Level",
                new String[]{"Level 1", "Level 2", "Level 3", "Level 4", "Level 5"});

        String assignedSector = ValidationUtil.promptFromList(scanner, "Assigned Sector",
                new String[]{"North Habitat", "South Habitat", "East Range", "West Range", "Training Wing", "Research Lab", "Central Command"});

        System.out.println();
        System.out.println("WOULD SEND:");
        System.out.println("POST /api/wardens");
        System.out.println();
        System.out.println("BRIEF DESCRIPTION:");
        System.out.println("Create a new Warden onboarding request after front-end validation.");
        System.out.println();
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"wardenId\": \"" + wardenId + "\",");
        System.out.println("  \"firstName\": \"" + firstName + "\",");
        System.out.println("  \"lastName\": \"" + lastName + "\",");
        System.out.println("  \"email\": \"" + email + "\",");
        System.out.println("  \"phone\": \"" + phone + "\",");
        System.out.println("  \"role\": \"" + role + "\",");
        System.out.println("  \"status\": \"" + status + "\",");
        System.out.println("  \"hireDate\": \"" + hireDate + "\",");
        System.out.println("  \"clearanceLevel\": \"" + clearanceLevel + "\",");
        System.out.println("  \"assignedSector\": \"" + assignedSector + "\"");
        System.out.println("}");
        System.out.println();
        System.out.println("SIMULATED RESULT:");
        System.out.println("SUCCESS — Request accepted by the boundary console. No permanent data was saved.");
    }
}
