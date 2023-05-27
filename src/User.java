import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static void main(String[] args) {
        File file = new File("UserBook.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");

        String[] headers = lines.get(0).split(" ");

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(" ");

            if (values.length == headers.length) {
                jsonBuilder.append("    {\n");

                for (int j = 0; j < headers.length; j++) {
                    jsonBuilder.append("        \"").append(headers[j]).append("\": \"").append(values[j]).append("\"");
                    if (j != headers.length - 1) {
                        jsonBuilder.append(",\n");
                    } else {
                        jsonBuilder.append("\n");
                    }
                }

                jsonBuilder.append("    },\n");
            }
        }

        if (jsonBuilder.length() > 2) {
            jsonBuilder.delete(jsonBuilder.length() - 2, jsonBuilder.length());
        }

        jsonBuilder.append("\n]");

        String jsonString = jsonBuilder.toString();
        System.out.println(jsonString);

        // Записуємо рядок JSON у файл
        try (FileWriter fileWriter = new FileWriter("user.json")) {
            fileWriter.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
