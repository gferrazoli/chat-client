import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class MessageSender {
    private final OutputStream outputStream;
    private final Scanner scanner;
    private final String name;

    public MessageSender(OutputStream outputStream, Scanner scanner, String name) {
        this.outputStream = outputStream;
        this.scanner = scanner;
        this.name = name;
    }

    public void startChatting() throws IOException {
        while (true) {
            var lineRead = scanner.nextLine();

            if (!lineRead.isBlank()){
                outputStream.write(name.concat(lineRead).concat("\n").getBytes());
                outputStream.flush();
            }
        }
    }
}
