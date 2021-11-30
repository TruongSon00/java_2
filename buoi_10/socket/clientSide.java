package buoi_10.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientSide {
    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
        System.out.println("client start");
        Thread.sleep(3000);
        Socket clientSocket = new Socket("localhost", 8888);
        System.out.println("client ket noi thanh cong");

        BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        try {

            while (true) {
                System.out.print("client: ");
                pw.write(sc.nextLine());
                pw.flush();
                char[] chr = new char[1024];
                int isRead = br.read(chr);
                if (isRead != -1) {
                    System.out.println("Server: " + String.valueOf(chr));
                }
            }
        } catch (Exception e) {
        } finally {
            sc.close();
            clientSocket.close();
        }

        System.out.println("client end");
    }
}
