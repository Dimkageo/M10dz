import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PhoneNumber {

    public static void main(String[] args) throws IOException {
        File file= new File("PhoneBook.txt");

        try (FileInputStream fileInputStream = new FileInputStream(file);
             Scanner scanner = new Scanner(fileInputStream)){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                validatePhoneNumber(line);
            }
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {

        String pattern1 = "\\(\\d{3}\\) \\d{3}-\\d{4}";

        String pattern2 = "\\d{3}-\\d{3}-\\d{4}";

        if (phoneNumber.matches(pattern1)||phoneNumber.matches(pattern2)) {
            System.out.println(phoneNumber);
        }
    }
}
