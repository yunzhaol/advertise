public class App {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.registerDefaultUsers(); // For testing
        javax.swing.SwingUtilities.invokeLater(() -> new LoginGUI(userService));
    }
}
