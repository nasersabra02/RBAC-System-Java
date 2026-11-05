
import java.util.*;

public class Main {

    // Check whether a user has permission to perform an action
    public static boolean checkPermission(
            Map<String, String> users,
            Map<String, Set<String>> roles,
            String username,
            String permission) {

        // Get the user's role
        String role = users.get(username);

        if (role == null) {
            return false;
        }

        // Get permissions assigned to the role
        Set<String> permissions = roles.get(role);

        if (permissions == null) {
            return false;
        }

        // Check if the permission exists
        return permissions.contains(permission);
    }

    public static void main(String[] args) {

        // 1. Create users and assign roles
        Map<String, String> users = new HashMap<>();

        users.put("Ali", "Admin");
        users.put("Omar", "Manager");
        users.put("Sara", "Customer");

        // 2. Create roles and assign permissions
        Map<String, Set<String>> roles = new HashMap<>();

        roles.put("Admin", new HashSet<>(Arrays.asList(
                "Create", "View", "Update", "Delete"
        )));

        roles.put("Manager", new HashSet<>(Arrays.asList(
                "View", "Update"
        )));

        roles.put("Customer", new HashSet<>(Arrays.asList(
                "View"
        )));

        // 3. Display available users
        System.out.println("===== RBAC System =====");
        System.out.println("Available Users: Ali, Omar, Sara");

        // 4. Get user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter username: ");
        String username = scanner.nextLine().trim();

        System.out.println(
                "Available Permissions: Create, View, Update, Delete"
        );

        System.out.print("Enter permission: ");
        String permission = scanner.nextLine().trim();

        // 5. Check access permission
        if (checkPermission(users, roles, username, permission)) {

            System.out.println("\n===== Access Granted =====");

            System.out.println(
                    "User: " + username
            );

            System.out.println(
                    "Role: " + users.get(username)
            );

            System.out.println(
                    "Action: " + permission
            );

            System.out.println(
                    "Object: Account"
            );

            System.out.println(
                    username + " is allowed to "
                    + permission + " the Account."
            );

        } else {

            System.out.println("\n===== Access Denied =====");

            System.out.println(
                    "User " + username
                    + " is not allowed to perform "
                    + permission + " on the Account."
            );
        }

        scanner.close();
    }
}
