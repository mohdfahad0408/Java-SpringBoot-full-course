import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingOnFiles_1108 {
    static void main(String[] args) {
        Path path=Path.of("student.txt");
        try{
            Files.writeString(path,"FHD");
            System.out.println("Data Written");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
