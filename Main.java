
import java.util.*;

public class Main {

    public static boolean checkPermission(
            Map<String, String> users,
            Map<String, Set<String>> roles,
            String username,
            String permission) {

        String role = users.get(username);

        if (role == null) {
            return false;
        }

        Set<String> permissions = roles.get(role);

        if (permissions == null) {
            return false;
        }

        return permissions.contains(permission);
    }

    public static void main(String[] args) {

        Map<String, String> users = new HashMap<>();

        users.put("Ali", "Admin");
        users.put("Omar", "Manager");
        users.put("Sara", "Customer");

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

        System.out.println("===== RBAC System =====");
        System.out.println("Available Users: Ali, Omar, Sara");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter username: ");
        String username = scanner.nextLine().trim();

        System.out.println(
                "Available Permissions: Create, View, Update, Delete"
        );

        System.out.print("Enter permission: ");
        String permission = scanner.nextLine().trim();

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
