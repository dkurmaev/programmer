//Задача про поиск "счастливого пельменя". Хозяйка налепила для гостей 30 пельменей.
// В один из пельменей она положила монету, которая увеличивает вес пельменя на 15 грамм.
// Напишите программу, которая ищет счастливый пельмень.

public class HappyDumpling {
    public static void main(String[] args) {

        //Алгоритм программы "HappyDumpling" следующий:

        //Инициализация переменных:

        //totalDumpling - общее количество пельменей (в данном случае 30).
        //baseWeight - базовый вес одного пельменя (в данном случае 50 грамм)
        //coinWeight - вес монеты, которая увеличивает вес пельменя (в данном случае 15 грамм).
        //Генерация случайного числа от 0 до (totalDumpling - 1) и сохранение его в переменную luckyDumplingIndex.
        // Это число будет использоваться в качестве индекса счастливого пельменя.
        //Создание массива пельменей dumplingWeights размером totalDumpling.
        // Заполнение массива dumplingWeights весами пельменей:
        //Если текущий индекс i соответствует luckyDumplingIndex, то вес пельменя увеличивается на вес монеты (baseWeight + coinWeight).
        //В противном случае, вес пельменя остается базовым (baseWeight).
        //Поиск счастливого пельменя в массиве dumplingWeights:
        //Проход по всем элементам массива с помощью цикла for.
        //Если вес текущего пельменя равен (baseWeight + coinWeight), то это счастливый пельмень.
        // Выводится сообщение с его индексом, и цикл прерывается с помощью оператора break.

        int totalDumpling = 30;
        int baseWeight = 50; // Базовый вес одного пельменя в граммах
        int coinWeight = 15; // Вес монеты в граммах

        // Генерируем случайное число от 0 до (totalPelmen - 1)
        int luckyDumplingIndex = (int) (Math.random() * totalDumpling - 1);

        // Создаем массив пельменей
        int[] dumplingWeights = new int[totalDumpling];

        // Заполняем массив весами пельменей
        for (int i = 0; i < totalDumpling; i++) {
            if (i == luckyDumplingIndex) {
                dumplingWeights[i] = baseWeight + coinWeight;
            } else {
                dumplingWeights[i] = baseWeight;
            }
        }

        // Ищем счастливый пельмень
        for (int i = 0; i < totalDumpling; i++) {
            if (dumplingWeights[i] == baseWeight + coinWeight) {
                System.out.println("A happy dumpling is found! Nr.: " + i);
                break;
            }
        }
    }
}
