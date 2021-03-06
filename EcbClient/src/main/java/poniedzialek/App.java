package poniedzialek;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class App {
    /**
     * Runs the client as an application.  First it displays a dialog
     * box asking for the IP address or hostname of a host running
     * the date server, then connects to it and displays the date that
     * it serves.
     */
    public static void main( String[] args ) throws IOException {
        /*String serverAddress = JOptionPane.showInputDialog(
                "Enter IP Address of a machine that is\n" +
                        "running the date service on port 9090:");*/
        String serverAddress = "150.254.79.94";
        int serverPort = 9090;
        Socket s = new Socket(serverAddress, serverPort);
        BufferedReader input =
                new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);
        System.exit(0);
    }
}
