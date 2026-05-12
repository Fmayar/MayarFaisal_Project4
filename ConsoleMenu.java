import java.util.Scanner;

public class ConsoleMenu {
    private Scanner scanner;
    private WardenService wardenService;

    public ConsoleMenu() {
        scanner = new Scanner(System.in);
        wardenService = new WardenService();
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    wardenService.addNewWarden(scanner);
                    pause();
                    break;
                case "2":
                    viewWardensMenu();
                    break;
                case "3":
                    updateWardenMenu();
                    break;
                case "4":
                    manageCertificationsMenu();
                    break;
                case "5":
                    deactivateTerminateMenu();
                    break;
                case "6":
                    System.out.println("Exiting Neon Ark Admin Warden Onboarding Console.");
                    running = false;
                    break;
                default:
                    System.out.println("ERROR: Invalid menu option. Please choose 1 through 6.");
            }
        }
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println("=========================================================");
        System.out.println("        NEON ARK — ADMIN WARDEN ONBOARDING CONSOLE");
        System.out.println("=========================================================");
        System.out.println("[ MAIN MENU ]");
        System.out.println("---------------------------------------------------------");
        System.out.println("1. Add New Warden");
        System.out.println("2. View Wardens");
        System.out.println("3. Update Warden");
        System.out.println("4. Manage Certifications");
        System.out.println("5. Deactivate / Terminate Warden");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    private void viewWardensMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("[ VIEW WARDENS MENU ]");
            System.out.println("1. View All Wardens");
            System.out.println("2. Search Warden by ID (simulated)");
            System.out.println("3. Filter Wardens by Status (simulated)");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    wardenService.viewAllWardens();
                    pause();
                    break;
                case "2":
                    simulateSearchWardenById();
                    pause();
                    break;
                case "3":
                    simulateFilterWardensByStatus();
                    pause();
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR: Invalid option. Please choose 1 through 4.");
            }
        }
    }

    private void updateWardenMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("[ UPDATE WARDEN MENU ]");
            System.out.println("1. Update Warden Role (simulated)");
            System.out.println("2. Update Assigned Sector (simulated)");
            System.out.println("3. Update Employment Status (simulated)");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    simulateUpdateRole();
                    pause();
                    break;
                case "2":
                    simulateUpdateSector();
                    pause();
                    break;
                case "3":
                    simulateUpdateStatus();
                    pause();
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR: Invalid option. Please choose 1 through 4.");
            }
        }
    }

    private void manageCertificationsMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("[ MANAGE CERTIFICATIONS MENU ]");
            System.out.println("1. Add Certification (simulated)");
            System.out.println("2. View Certifications (simulated)");
            System.out.println("3. Renew Certification (simulated)");
            System.out.println("4. Return to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    simulateAddCertification();
                    pause();
                    break;
                case "2":
                    simulateViewCertification();
                    pause();
                    break;
                case "3":
                    simulateRenewCertification();
                    pause();
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR: Invalid option. Please choose 1 through 4.");
            }
        }
    }

    private void deactivateTerminateMenu() {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("[ DEACTIVATE / TERMINATE WARDEN MENU ]");
            System.out.println("1. Deactivate Warden (simulated)");
            System.out.println("2. Terminate Warden (simulated)");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    simulateDeactivateWarden();
                    pause();
                    break;
                case "2":
                    simulateTerminateWarden();
                    pause();
                    break;
                case "3":
                    back = true;
                    break;
                default:
                    System.out.println("ERROR: Invalid option. Please choose 1 through 3.");
            }
        }
    }

    private void simulateSearchWardenById() {
        System.out.println();
        System.out.println("Action: Search Warden by ID");
        System.out.println("Inputs required: wardenId");
        System.out.println("Validation: Warden ID must not be blank and must match an existing record.");
        System.out.println("WOULD SEND: GET /api/wardens/{wardenId}");
        System.out.println("Expected result: Display one matching Warden record if found.");
        System.out.println("Result: SUCCESS (simulated).");
    }

    private void simulateFilterWardensByStatus() {
        System.out.println();
        System.out.println("Action: Filter Wardens by Status");
        System.out.println("Inputs required: status");
        System.out.println("Validation: Status must be Active, Inactive, or Terminated.");
        System.out.println("WOULD SEND: GET /api/wardens?status={status}");
        System.out.println("Expected result: Display all Wardens matching the selected status.");
        System.out.println("Result: SUCCESS (simulated).");
    }

    private void simulateUpdateRole() {
        System.out.println();
        System.out.println("Action: Update Warden Role");
        System.out.println("Inputs required: wardenId, newRole");
        System.out.println("Validation: Warden ID must exist. Role must be one of the approved database values.");
        System.out.println("WOULD SEND: PUT /api/wardens/{wardenId}/role");
        System.out.println("BRIEF DESCRIPTION: Update a Warden role without changing identity fields.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"role\": \"Field Warden\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void simulateUpdateSector() {
        System.out.println();
        System.out.println("Action: Update Assigned Sector");
        System.out.println("Inputs required: wardenId, assignedSector");
        System.out.println("Validation: Warden ID must exist. Sector must be one of the approved sectors.");
        System.out.println("WOULD SEND: PUT /api/wardens/{wardenId}/sector");
        System.out.println("BRIEF DESCRIPTION: Update Warden sector assignment.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"assignedSector\": \"North Habitat\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void simulateUpdateStatus() {
        System.out.println();
        System.out.println("Action: Update Employment Status");
        System.out.println("Inputs required: wardenId, newStatus");
        System.out.println("Validation: Warden ID must exist. Status must be Active, Inactive, or Terminated.");
        System.out.println("WOULD SEND: PUT /api/wardens/{wardenId}/status");
        System.out.println("BRIEF DESCRIPTION: Update employment status while preserving historical record behavior.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"status\": \"Inactive\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void simulateAddCertification() {
        System.out.println();
        System.out.println("Action: Add Certification");
        System.out.println("Inputs required: wardenId, certificationName, earnedDate, expirationDate");
        System.out.println("Validation: Warden ID must exist. Dates must use YYYY-MM-DD. Expiration date may be optional.");
        System.out.println("WOULD SEND: POST /api/wardens/{wardenId}/certifications");
        System.out.println("BRIEF DESCRIPTION: Create a new certification record and associate it with an existing Warden.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"name\": \"Rift Safety Level 1\",");
        System.out.println("  \"earnedDate\": \"2026-02-03\",");
        System.out.println("  \"expirationDate\": \"2027-02-03\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void simulateViewCertification() {
        System.out.println();
        System.out.println("Action: View Certifications");
        System.out.println("Inputs required: wardenId");
        System.out.println("Validation: Warden ID must not be blank and must match an existing Warden.");
        System.out.println("WOULD SEND: GET /api/wardens/{wardenId}/certifications");
        System.out.println("Expected result: Display certification records linked to the Warden.");
        System.out.println("Result: SUCCESS (simulated).");
    }

    private void simulateRenewCertification() {
        System.out.println();
        System.out.println("Action: Renew Certification");
        System.out.println("Inputs required: wardenId, certificationId, newExpirationDate");
        System.out.println("Validation: IDs must exist. New expiration date must use YYYY-MM-DD.");
        System.out.println("WOULD SEND: PUT /api/wardens/{wardenId}/certifications/{certificationId}");
        System.out.println("BRIEF DESCRIPTION: Renew an existing certification without deleting certification history.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"expirationDate\": \"2027-02-03\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void simulateDeactivateWarden() {
        System.out.println();
        System.out.println("Action: Deactivate Warden");
        System.out.println("Inputs required: wardenId, effectiveDate, reason");
        System.out.println("Validation: Warden ID must exist. Effective date must use YYYY-MM-DD. Reason cannot be blank.");
        System.out.println("WOULD SEND: PUT /api/wardens/{wardenId}/deactivate");
        System.out.println("BRIEF DESCRIPTION: Mark a Warden as inactive without deleting the record.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"status\": \"Inactive\",");
        System.out.println("  \"effectiveDate\": \"2026-05-12\",");
        System.out.println("  \"reason\": \"Temporary reassignment\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void simulateTerminateWarden() {
        System.out.println();
        System.out.println("Action: Terminate Warden");
        System.out.println("Inputs required: wardenId, terminationDate, reason");
        System.out.println("Validation: Warden ID must exist. Termination date must use YYYY-MM-DD. Reason cannot be blank.");
        System.out.println("WOULD SEND: PUT /api/wardens/{wardenId}/terminate");
        System.out.println("BRIEF DESCRIPTION: Mark a Warden as terminated while preserving the historical record.");
        System.out.println("PAYLOAD (JSON):");
        System.out.println("{");
        System.out.println("  \"status\": \"Terminated\",");
        System.out.println("  \"terminationDate\": \"2026-05-12\",");
        System.out.println("  \"reason\": \"Employment ended\"");
        System.out.println("}");
        System.out.println("Result: SUCCESS (simulated). No seed data was changed.");
    }

    private void pause() {
        System.out.println();
        System.out.print("Press Enter to return to the menu...");
        scanner.nextLine();
    }
}
