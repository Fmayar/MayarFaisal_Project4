public class Warden {
    private String wardenId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private String status;
    private String hireDate;
    private String clearanceLevel;
    private String assignedSector;

    public Warden(String wardenId, String firstName, String lastName, String email,
                  String phone, String role, String status, String hireDate,
                  String clearanceLevel, String assignedSector) {
        this.wardenId = wardenId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.status = status;
        this.hireDate = hireDate;
        this.clearanceLevel = clearanceLevel;
        this.assignedSector = assignedSector;
    }

    public String getWardenId() { return wardenId; }
    public String getEmail() { return email; }

    public String toCsvRow() {
        return String.join(",", wardenId, firstName, lastName, email, phone,
                role, status, hireDate, clearanceLevel, assignedSector);
    }

    public void printRow() {
        System.out.printf("%-8s %-12s %-12s %-30s %-14s %-22s %-12s %-12s %-10s %-18s%n",
                wardenId, firstName, lastName, email, phone, role, status,
                hireDate, clearanceLevel, assignedSector);
    }
}
