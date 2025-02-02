package GUI;

import Data.Constants;
import FakeServer.FakePlayerServer;
import Sockets.Cliente;
import Sprites.Player;

import javax.swing.*;
import java.awt.*;

/**
 * This class creates the window for the game
 */
public class PlayerWindow extends JFrame {

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            JFrame frame = new PlayerWindow();
            frame.setVisible(true);
        });
    }

    /**
     * Constructor
     */
    public PlayerWindow() {
        initWindow();
    }

    /**
     * Initialize all the window and creates the player
     */
    private void initWindow() {
        this.setTitle("PaCEman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.WIDTH, Constants.HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(true);

        Player player = new Player();
        Cliente c = new Cliente(player);
        c.start();
        FakePlayerServer fakePlayerServer = new FakePlayerServer(player);
        fakePlayerServer.setVisible(true);

        this.add(player);
    }
}
