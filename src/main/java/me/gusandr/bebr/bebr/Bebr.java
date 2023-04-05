package me.gusandr.bebr.bebr;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Bebr extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void getMultiplesNumber(int number) {
        // Проверяем, чтобы число было положительным и больше или равным 2
        if (number < 2) {
            System.out.println("Число должно быть больше или равно 2!");
            return;
        }

        // Создаем переменную для хранения суммы
        int sum = 0;

        // Находим все числа, кратные 2 и находящиеся в диапазоне от 2 до number
        for (int i = 2; i <= number; i += 2) {
            System.out.print(i + ", "); // Выводим число на экран
            sum += i; // Добавляем число к сумме
        }

        // Выводим сумму на экран
        System.out.println("\n" + sum);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("multiples")) {
            if (args.length < 1) {
                sender.sendMessage("Использование: /multiples <число>");
                return true;
            }

            // Преобразуем аргумент в число
            int number = 0;
            try {
                number = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                sender.sendMessage("Неверный формат числа!");
                return true;
            }

            // Вызываем метод getMultiplesNumber
            getMultiplesNumber(number);

            return true;
        }

        return false;
    }
}
