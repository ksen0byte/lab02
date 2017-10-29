import io.FileUtils;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<Integer> lastPos = FileUtils.
                lastPos("C:/Users/Admin/IdeaProjects/sherbak/2.txt", "python");

        if (lastPos.isPresent()) {
            System.out.println(lastPos.get());
        } else {
            System.out.println("No such string");
        }

    }
}