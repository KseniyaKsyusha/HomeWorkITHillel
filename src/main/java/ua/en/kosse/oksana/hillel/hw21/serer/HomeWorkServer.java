package ua.en.kosse.oksana.hillel.hw21.server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.HashSet;


public class HomeWorkServer {

    private static final int PORT = 9001;

    public static HashSet<String> names = new HashSet<String>();

    public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    private static int clientCounter = 0;
    private static String namePrefix = "Client-";
    public static String storageName = "storage";

    public static void main(String[] args) throws Exception {

        // Write some log
        System.out.println("The chat server is running...");

        // Initiate socket and listening request from a client
        ServerSocket listener = new ServerSocket(PORT);

        // Infinite loop for listening port and managing connections
        try {
            while (true) {

                // Create a new instance for communicate
                // with just connected client
                new Handler(listener.accept(),
                        namePrefix + (++clientCounter))
                        .start();
            }
        } finally {
            listener.close();
        }
    }
}

