package lab9.e1;


import java.io.*;
import java.net.Socket;


public class WorkerRunnable implements Runnable{

    protected Socket clientSocket = null;
    protected String serverText   = null;

    public WorkerRunnable(Socket clientSocket, String serverText) {
        this.clientSocket = clientSocket;
        this.serverText   = serverText;
    }

    @Override
    public void run() {
        try {
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String inputLine;
            if((inputLine = input.readLine()) != null) {
                output.println("Your command is " + inputLine);
            } else {
                output.println("NO");
            }

            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}