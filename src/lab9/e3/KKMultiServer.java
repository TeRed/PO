package lab9.e3;

import java.net.*;
import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KKMultiServer {
    public static void main(String[] args) throws IOException {

        boolean listening = true;
        ExecutorService exec = Executors.newFixedThreadPool(2);

        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            while (listening) {
                exec.execute(new KKMultiServerThread(serverSocket.accept()));
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + 9000);
            System.exit(-1);
        }
    }
}