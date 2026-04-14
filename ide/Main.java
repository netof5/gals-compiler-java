import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompilerIDE ide = new CompilerIDE();
            ide.setVisible(true);
        });
    }
}