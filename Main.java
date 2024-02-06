import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных от пользователя
        System.out.print("Введите ваш вес в килограммах: ");
        double a = scanner.nextDouble();

        System.out.print("Введите ваш рост в метрах: ");
        double b = scanner.nextDouble();

        System.out.print("Введите ваш возраст: ");
        int c = scanner.nextInt();

        double bmi = calculateBMI(a, b);

        double idealWeight = calculateIdealWeight(b);

        double dailyCalories = calculateDailyCalories(a, b, c);

        System.out.println("\nРезультаты:");
        if (bmi > 24.9) {
            double norma = idealWeight-a;
            System.out.printf("Ваш ИМТ: %.2f.\n"+"Рекомендуется сбросить %.2f кило для достижения идеального веса.\n", bmi,norma);
            System.out.printf("Идеальный вес: %.2f кг\n", idealWeight);
            dailyCalories = dailyCalories-500;
            System.out.printf("Рекомендуемый дневной прием калорий: %.2f ккал\n", dailyCalories);}

        else  if(bmi < 18.5) {
            double norma = idealWeight-a;
            System.out.printf("Ваш ИМТ: %.2f.\n"+"Рекомендуется набрать %.2f кило для достижения идеального веса.\n", bmi,norma);
            System.out.printf("Идеальный вес: %.2f кг\n", idealWeight);
            dailyCalories = dailyCalories+500;
            System.out.printf("Рекомендуемый дневной прием калорий: %.2f ккал\n", dailyCalories);}
        else {
            System.out.printf("Ваш ИМТ: %.2f.\nВаш вес находится в пределах нормы.\n", bmi);
            System.out.printf("Идеальный вес: %.2f кг\n", idealWeight);
            System.out.printf("Рекомендуемый дневной прием калорий: %.2f ккал\n", dailyCalories);}

        scanner.close();
    }
    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    private static double calculateIdealWeight(double height) {
        return 24.9 * height * height;
    }
    private static double calculateDailyCalories(double weight, double height, int age) {
        return 655 + 9.6 * weight + 1.8 * height - 4.7 * age;
    }
}