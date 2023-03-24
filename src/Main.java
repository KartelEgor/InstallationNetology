import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> directory = new ArrayList<>(List.of("C:/Users/Ksesh/Desktop/Games", "C:/Users/Ksesh/Desktop/Games/src",
            "C:/Users/Ksesh/Desktop/Games/res", "C:/Users/Ksesh/Desktop/Games/savegames", "C:/Users/Ksesh/Desktop/Games/temp",
            "C:/Users/Ksesh/Desktop/Games/src/main", "C:/Users/Ksesh/Desktop/Games/src/test", "C:/Users/Ksesh/Desktop/Games/res/drawables",
            "C:/Users/Ksesh/Desktop/Games/res/icons", "C:/Users/Ksesh/Desktop/Games/res/vectors"));

    public static List<String> files = new ArrayList<>(List.of("C:/Users/Ksesh/Desktop/Games/src/main/Main.java",
            "C:/Users/Ksesh/Desktop/Games/src/main/Utils.java", "C:/Users/Ksesh/Desktop/Games/temp/temp.txt"));

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        createDirectory(directory);
        createFiles(files);
        log();

    }

    //------------------------------------Метод создания папок-------------------------------------------
    public static void createDirectory(List<String> directoryPath) {
        for (String directory : directoryPath) {
            File file = new File(directory);
            if (!file.exists()) {
                file.mkdir();
            } else System.out.println(file + " папка уже существует");
            sb.append("Директория " + file.getName() + " успешно создана " + file.exists() + "\n");
        }
    }

    //-----------------------------------Метод создания файлов-------------------------------------------
    public static void createFiles(List<String> filesPath) {
        for (String files : filesPath) {
            File file = new File(files);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else System.out.println(file + " файл существует");
            sb.append("Файл " + file.getName() + " успешно создан " + file.exists() + "\n");
        }
    }

    //------------------------------------Метод сохраняющий лог в файл------------------------------------
    public static void log() {
        try {
            FileWriter writer = new FileWriter("C:/Users/Ksesh/Desktop/Games/temp/temp.txt");
            writer.write(String.valueOf(sb));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}