package pl.coderslab;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        Path path = Paths.get("src/pl/coderslab/tasks.csv");

        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (!choice.contains("exit")) {
            System.out.println();
            System.out.println(ConsoleColors.BLUE + "Please select an option>");
            System.out.println(ConsoleColors.RESET + "add");
            System.out.println("remove");
            System.out.println("list");
            System.out.println("exit");
            choice = scan.nextLine();

            if (choice.contains("add")) {
                add();
            } else if (choice.contains("remove")) {
                remove();
            } else if (choice.contains("list")) {
                list();
            }
        }
        System.out.println(ConsoleColors.RED + "Bye, bye");
    }

    public static void add() {
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Path path = Paths.get("src/pl/coderslab/tasks.csv");
        String answer1="";
        String answer2="";
        String answer3 = "";
        try {
            for (String line : Files.readAllLines(path)) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Please add task description");
        answer1 = scan.nextLine();
        System.out.println("Please add task due date");
        answer2 = scan.nextLine();
        while(!answer3.contains("true") && !answer3.contains("false")){
            System.out.println("Is your task important: true/false");
            answer3 = scan.nextLine();
        }


        list.add(answer1 + "," + answer2 + "," + answer3);

        try {
            Files.write(path, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void remove() {
        Path path = Paths.get("src/pl/coderslab/tasks.csv");
        List<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int idToRemove = -1;
        int length = 0;
        try {
            for (String lines : Files.readAllLines(path)) {
                length++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (idToRemove < 0 || idToRemove >= length) {
            try {
                System.out.println("Please select value to remove");
                idToRemove = scan.nextInt();
            } catch (ArithmeticException e) {
                System.err.println("This value is not on the list");
            }
        }
        try {
            for (String line : Files.readAllLines(path)) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        list.remove(idToRemove);
        try {
            Files.write(path, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Value was succesfully deleted.");
    }

    public static void list() {
        Path path = Paths.get("src/pl/coderslab/tasks.csv");
        int i = 0;
        try {
            for (String list : Files.readAllLines(path)) {
                list = list.replace(",", "  ");
                System.out.println(i + " : " + list);
                i++;
            }
        } catch (IOException e) {
            System.err.println(" ");
        }
        System.out.println("To juz koniec naszych danych!");
        System.out.println();


    }
}
