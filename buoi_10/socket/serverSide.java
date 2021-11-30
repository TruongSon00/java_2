package buoi_10.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class serverSide {
    public static void main(String[] args) throws IOException {
        System.out.println("server start");
        // ----------- dang ky ung dung ----------
        ServerSocket server = new ServerSocket(8888);
        Socket serverSocket = server.accept();
        System.out.println("Server chap nhan thanh cong");

        BufferedReader br = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        PrintWriter pw = new PrintWriter(serverSocket.getOutputStream());

        Scanner sc = new Scanner(System.in);
        try {

            while (true) {
                char[] chr = new char[1024];
                int isRead = br.read(chr);
                if (isRead != -1)
                    System.out.println("Client : " + String.valueOf(chr));

                System.out.print("Server : ");
                pw.write(sc.nextLine());

                pw.flush();

            }
        } catch (Exception e) {
        } finally {
            sc.close();
            serverSocket.close();
            server.close();
        }
        System.out.println("server end");
    }
}
