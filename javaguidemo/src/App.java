import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            // UIManager.put( "Button.arc", 999 );
            // UIManager.put( "Component.arc", 999 );
            // UIManager.put( "ProgressBar.arc", 999 );
            // UIManager.put( "TextComponent.arc", 999 );
            UIManager.put("Button.background", new Color(30, 144, 255));  // DodgerBlue
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("TextField.background", new Color(240, 240, 240));
            UIManager.put("TextField.foreground", Color.BLACK);
            UIManager.put("TextField.caretForeground", Color.RED);      // Caret (cursor) color
            UIManager.put("TextField.selectionBackground", Color.BLUE); // Text selection background
            UIManager.put("TextField.selectionForeground", Color.WHITE);
            UIManager.put("Label.foreground", Color.DARK_GRAY);
            UIManager.put("Panel.background", new Color(245, 245, 245));
            UIManager.put("RootPane.background", new Color(245, 245, 245)); // for JFrame content pane
            UIManager.put("Table.background", Color.WHITE);
            UIManager.put("Table.foreground", Color.BLACK);
            UIManager.put("Table.selectionBackground", new Color(0, 120, 215)); // Blue highlight
            UIManager.put("Table.selectionForeground", Color.WHITE);
            UIManager.put("Table.gridColor", new Color(200, 200, 200));         // Grid lines

            // Table header customization
            UIManager.put("TableHeader.background", new Color(230, 230, 230));
            UIManager.put("TableHeader.foreground", Color.BLACK);
            UIManager.put("TableHeader.font", new Font("SansSerif", Font.BOLD, 12));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}

