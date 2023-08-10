package Task2;

import java.io.*;

/**
 * Класс FileManager предоставляет методы для выполнения операций с файлами: чтение, запись и копирование.
 */
public class FileManager {

    /**
     * Читает содержимое файла и возвращает его в виде строки.
     *
     * @param filePath путь к файлу для чтения.
     * @return содержимое файла в виде строки.
     * @throws FileNotFoundException если файл не найден.
     * @throws IOException           если произошла ошибка при чтении файла.
     */
    public static String readFile(String filePath) throws FileNotFoundException, IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }

        return content.toString();
    }

    /**
     * Записывает строку в файл.
     *
     * @param filePath путь к файлу для записи.
     * @param content  содержимое для записи.
     * @throws IOException если произошла ошибка при записи файла.
     */
    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    /**
     * Копирует содержимое одного файла в другой.
     *
     * @param sourcePath путь к исходному файлу.
     * @param destPath   путь к файлу, в который будет скопировано содержимое.
     * @throws FileNotFoundException если исходный файл не найден.
     * @throws IOException           если произошла ошибка при копировании файла.
     */
    public static void copyFile(String sourcePath, String destPath) throws FileNotFoundException, IOException {
        try (InputStream in = new FileInputStream(sourcePath);
             OutputStream out = new FileOutputStream(destPath)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }
}

