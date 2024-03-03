import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageReceiver implements Runnable{
    private final Socket socket;

    public MessageReceiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            var socketInputStream = socket.getInputStream();
            var bufferedReader = new BufferedReader(new InputStreamReader(socketInputStream));

            while(true) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
}
