import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<String> poemsPathes = Arrays.asList(
            "data/ahmatova.txt",
            "data/esenin.txt",
            "data/mayakovskiy.txt",
            "data/nekrasov.txt"
    );

    public static void main(String[] args) throws IOException {
        StringBuilder canvas = new StringBuilder();
        List<Poet> poets = new ArrayList<>();
        for (String path : poemsPathes) {
            poets.add(new Poet(path, canvas));
        }

        poets.forEach(Poet::start);

        for (Poet poet : poets) {
            try {
                poet.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(canvas);
    }
}
