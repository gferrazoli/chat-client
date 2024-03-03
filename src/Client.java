import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws IOException {
        try(
            var executorService = Executors.newCachedThreadPool()
        ){
            var scanner = new Scanner(System.in);
            var socket = new Socket("localhost", 8080);

            System.out.print("Insert your nickname: ");
            var name = scanner.nextLine().concat(": ");

            executorService.execute(new MessageReceiver(socket));

            var messageSender = new MessageSender(socket.getOutputStream(), scanner, name);
            messageSender.startChatting();
        }
    }
}
