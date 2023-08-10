package Task1;

import java.util.Scanner;

/**
 * Класс PasswordVerifier выполняет проверку пароля на соответствие определенным правилам.
 */
public class PasswordVerifier {

    /**
     * Точка входа в программу. Запрашивает у пользователя пароль и проверяет его.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        try {
            verifyPassword(password); // Вызов метода для проверки пароля
            System.out.println("Пароль соответствует правилам.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage()); // Вывод сообщения об ошибке
        } finally {
            scanner.close(); // Закрытие Scanner для избежания утечек ресурсов
        }
    }

    /**
     * Проверяет пароль на соответствие заданным правилам.
     *
     * @param password пароль для проверки.
     * @throws IllegalArgumentException если пароль не соответствует правилам.
     */
    public static void verifyPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Пароль должен быть не менее 8 символов.");
        }

        boolean containsDigit = false;
        boolean containsUpperCase = false;

        // Проверка наличия цифр и заглавных букв в пароле
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                containsDigit = true;
            }
            if (Character.isUpperCase(ch)) {
                containsUpperCase = true;
            }
        }

        // Выброс исключения, если правила не выполняются
        if (!containsDigit) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну цифру.");
        }

        if (!containsUpperCase) {
            throw new IllegalArgumentException("Пароль должен содержать хотя бы одну заглавную букву.");
        }
    }
}



