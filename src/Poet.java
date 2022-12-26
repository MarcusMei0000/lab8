import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Poet extends Thread {
    private final StringBuilder canvas;
    private final List<String> poem;

    public Poet(String path, StringBuilder canvas) throws IOException {
        this.canvas = canvas;

        try (var lines = Files.lines(Paths.get(path))) {
            poem = lines.toList();
        }
    }

    @Override
    public void run() {
        for (String line : poem) {
            synchronized (canvas) {
                canvas.append(line).append("\n");
            }
            try {
                Thread.sleep((long) ((Math.random() * 100) + 300));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
