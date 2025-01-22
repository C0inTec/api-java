package br.com.coin.domain.user;


public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


    public static UserRole fromValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        for (UserRole userRole : UserRole.values()) {
            if (userRole.role.equalsIgnoreCase(value.trim())) {
                return userRole;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + value + ". Allowed values are: admin, user.");
    }
}
