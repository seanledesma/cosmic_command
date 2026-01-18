package application;

/**
 * Launcher class to work around JavaFX module system restrictions
 * when running from a shaded JAR.
 */
public class Launcher {
    public static void main(String[] args) {
        Main.main(args);
    }
}
