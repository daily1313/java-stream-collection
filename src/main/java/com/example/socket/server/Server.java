package com.example.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Logger;

public class Server implements Runnable {

    private static final Logger log = Logger.getLogger(Server.class.getName());
    private static final int PORT = 8000;
    private static final String QUIT_OPTION = "q";

    @Override
    public void run() {

        // 1. create serversocket (port binding)
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("[Server]: create server socket(port binding), port number : " + PORT);

            // 2. wait client connection
            Socket socket = serverSocket.accept();
            log.info("[Client]: connected - IP address : " + socket.getRemoteSocketAddress());

            // 3. create inputstream, outputstream for data transmission/reception
            try(Socket s = socket; Scanner scanner = new Scanner(System.in);
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()))) {

                while(true) {
                    // 4. receive client message
                    String message = in.readLine();
                    log.info("[Server]: received message from client: " + message);

                    if(message.equalsIgnoreCase(QUIT_OPTION)) {
                        log.info("[Server]: quit server by client");
                        break;
                    }

                    log.info("[Server]: send message to client");

                    // 5. send server message
                    String sendMessage = scanner.nextLine();
                    out.write(sendMessage + "\n");
                    out.flush();

                    if (sendMessage.equalsIgnoreCase(QUIT_OPTION)) {
                        log.info("[Server]: request stop");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            log.severe("I/O error occurred while socket connection");
            throw new RuntimeException(e);
        }
    }
}
