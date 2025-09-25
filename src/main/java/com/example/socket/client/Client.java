package com.example.socket.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Client implements Runnable {

    private static final Logger log = Logger.getLogger(Client.class.getName());
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final String QUIT_OPTION = "q";

    @Override
    public void run() {
        // 1. create client socket
        // 2. create inputstream, outputstream for data transmission/reception
        try(Socket socket = new Socket(HOST, PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in)) {

            log.info("[Client]: connect to server - IP : " + HOST + ", port : " + PORT);

            while(true) {
                // 3. send client message
                log.info("[Client]: send message to server");

                String sendMessage = scanner.nextLine();

                if(sendMessage.equalsIgnoreCase(QUIT_OPTION)) {
                    log.info("[Client]: quit client socket communication");
                }

                out.write(sendMessage + "\n");
                out.flush();

                // 3. receive server message
                String message = in.readLine();
                log.info("[Client]: received message from server: " + message);

                if(!scanner.hasNextLine()) {
                    break;
                }
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.severe("I/O error occurred while socket connection");
            throw new RuntimeException(e);
        }
    }
}
