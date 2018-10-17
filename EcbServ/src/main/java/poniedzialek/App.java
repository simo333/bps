package poniedzialek;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static poniedzialek.Encryptor.encrypt;

/**
 * Hello world!
 */
public class App {
    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV

        String secret = encrypt(key, initVector, "Czesc Rafale, tu Szymon.");
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    //out.println(new Date().toString());
                    out.println(secret);
                } finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }
}