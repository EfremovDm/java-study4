package ru.efremovdm.lesson5;

/**
 * Урок 5. Рекурсия
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 */
public class Application {

    public static void main(String[] args) {
        power(2, 32);
        backPack(75);
    }

    /**
     * Возведение числа в степень
     *
     * @param number
     * @param power
     */
    private static void power(int number, int power) {
        long result = powerRecursion(number, power);
        System.out.println("Power: " + number + "^" + power + "=" + result);
    }

    /**
     * Рекурсия возведения числа в степень
     *
     * @param number
     * @param power
     * @return
     */
    private static long powerRecursion(int number, int power) {

        long result;

        switch (power) {
            case 0:  result = 1; break;
            case 1:  result = number; break;
            default: result = number * powerRecursion(number, power - 1);
        }

        return result;
    }

    /**
     * Задача о рюкзаке
     *
     * @param maxWeight
     */
    private static void backPack(int maxWeight) {

        Product[] goods = {
                new Product(15, 30),
                new Product(30, 40),
                new Product(50, 50),
                new Product(40, 25),
                new Product(10, 20)
        };

        System.out.println("BackPack: max weight=" + maxWeight
                + ", price=" + findBestRes(goods, goods.length - 1, maxWeight));
    }

    /**
     * Рекурсия задачи о рюкзаке
     *
     * @param goods
     * @param i
     * @param weigth
     * @return
     */
    private static int findBestRes(Product[] goods, int i, int weigth) {
        if (i < 0) {
            return 0;
        }

        if (goods[i].getWeight() > weigth) {
            return findBestRes(goods, i - 1, weigth);
        } else {
            return Math.max(
                findBestRes(goods, i - 1, weigth),
                findBestRes(goods, i - 1, weigth - goods[i].getWeight()) + goods[i].getPrice()
            );
        }
    }

    /**
     * Товар с параметрами веса и цены
     */
    private static class Product {
        private int weight;
        private int price;

        Product(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        int getWeight() {
            return weight;
        }

        int getPrice() {
            return price;
        }
    }
}