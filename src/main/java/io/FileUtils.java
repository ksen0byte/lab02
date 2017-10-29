package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

public class FileUtils {
    private FileUtils() {
    }

    public static void copyFile(Path from, Path to) {
        try {
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String from, String to) {
        copyFile(Paths.get(from), Paths.get(to));
    }

    public static Optional<Integer> lastPos(String path, String searchString) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            Integer lastIndexOf = 0;
            Integer lineIndex = 0;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(searchString);
                if (index != -1) {
                    lastIndexOf = index + lineIndex;
                }
                lineIndex += line.length();
            }

            if (lastIndexOf != 0) {
                return Optional.of(lastIndexOf);
            } else {
                return Optional.empty();
            }
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
