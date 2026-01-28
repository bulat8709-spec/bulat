//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class TotientFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число N: ");
        int N = scanner.nextInt();

        if (N <= 0) {
            System.out.println("Число должно быть положительным!");
            return;
        }

        int result = eulerTotient(N);
        System.out.println("Количество чисел, меньших " + N + " и взаимно простых с ним: " + result);
        System.out.println("Результат гадания: " + result);

        scanner.close();
    }

    // Функция Эйлера (Euler's Totient Function)
    public static int eulerTotient(int n) {
        int result = n; // Изначально result = n

        // Проверяем все простые делители числа n
        for (int p = 2; p * p <= n; p++) {
            // Если p - простой делитель n
            if (n % p == 0) {
                // Учитываем формулу Эйлера: result = result * (1 - 1/p)
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }

        // Если остался простой делитель больше 1
        if (n > 1) {
            result -= result / n;
        }

        return result;
    }
}



