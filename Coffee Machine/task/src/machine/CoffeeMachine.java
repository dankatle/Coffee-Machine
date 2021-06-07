package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static int moneyInMachine = 550;
    private static int waterInMachine = 400;
    private static int milkInMachine = 540;
    private static int coffeeBeansInMachine = 120;
    private static int cupsInMachine = 9;

    public static void main(String[] args) {
        String checkAction;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            checkAction = scanner.next();
            switch (checkAction) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    infoMachine();
                    break;
            }
        } while (!checkAction.equals("exit"));
    }

    public static void take() {
        System.out.println("I gave you " + moneyInMachine);
        moneyInMachine = 0;
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        waterInMachine += addWater;

        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        milkInMachine += addMilk;

        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffeeBeans = scanner.nextInt();
        coffeeBeansInMachine += addCoffeeBeans;

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int addCups = scanner.nextInt();
        cupsInMachine += addCups;
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String chooseToBuy = scanner.next();
        switch (chooseToBuy) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                break;
        }
    }

    private static void makeEspresso() {
        int water = 250;
        int coffeeBeans = 16;
        int cost = 4;

        if (checkLogic(water, 0, coffeeBeans, cost)) {
            make(water, 0, coffeeBeans, cost);
        }
    }

    private static void makeLatte() {
        int water = 350;
        int milk = 75;
        int coffeeBeans = 20;
        int cost = 7;

        if (checkLogic(water, milk, coffeeBeans, cost)) {
            make(water, milk, coffeeBeans, cost);
        }
    }

    private static void makeCappuccino() {
        int water = 200;
        int milk = 100;
        int coffeeBeans = 12;
        int cost = 6;

        if (checkLogic(water, milk, coffeeBeans, cost)) {
            make(water, milk, coffeeBeans, cost);
        }
    }

    private static boolean checkLogic(int water, int milk, int coffeeBeans, int cost) {
        boolean result = false;
        if (waterInMachine < water) {
            System.out.println("Sorry, not enough water!");
        } else if (milkInMachine < milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeansInMachine < coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cupsInMachine < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            result = true;
        }
        return result;
    }

    private static void make(int water, int milk, int coffeeBeans, int cost) {
        waterInMachine -= water;
        milkInMachine -= milk;
        coffeeBeansInMachine -= coffeeBeans;
        moneyInMachine += cost;
        cupsInMachine--;
    }

    private static void infoMachine() {
        System.out.println("The coffee machine has:");
        System.out.println(waterInMachine + " ml of water");
        System.out.println(milkInMachine + " ml of milk");
        System.out.println(coffeeBeansInMachine + " g of coffee beans");
        System.out.println(cupsInMachine + " disposable cups");
        System.out.println("$" + moneyInMachine + " of money");
    }
}
