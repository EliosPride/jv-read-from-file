package core.basesyntax;

import java.io.FileInputStream;
import java.util.Arrays;

public class FileWork {
    private static final String FIRST_LETTER_W = "w";

    public String[] readFromFile(String fileName) {
        StringBuilder builder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            while (fileInputStream.available() > 0) {
                char letter = (char) fileInputStream.read();
                builder.append(letter);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception catched during the file reading.");
            return new String[0];
        }
        String charArray = builder.toString().toLowerCase().trim();
        builder.delete(0, builder.length());
        String[] newArray = charArray.split(" ");
        for (String wLetter : newArray) {
            if (wLetter.startsWith(FIRST_LETTER_W)) {
                builder.append(wLetter.replaceAll("\\W", "")).append(" ");
            }
        }
        String replacedString = builder.toString().trim();
        if (replacedString.length() == 0) {
            return new String[0];
        }
        String[] wArray = replacedString.split(" ");
        Arrays.sort(wArray);
        return wArray;
    }
}
