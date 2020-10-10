package pl.coderslab;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
       /* Path path = Paths.get("src/pl/coderslab/tasks.csv");
        Scanner scan = new Scanner(System.in);
       /* File file = new File(path);
        Scanner scan2 = new Scanner(file);
        String answer1 = "";
        String answer2 = "";
        String answer3 = "";
       // while()

        System.out.println("Please add task description");
        answer1 = scan.nextLine();
        System.out.println("Please add task due date");
        answer2 = scan.nextLine();
        System.out.println("Is your task important: true/false");
        answer3 = scan.nextLine();

        try (FileWriter fileWriter = new FileWriter("src/pl/coderslab/tasks.csv", false)) {
            fileWriter.append(answer1);
            fileWriter.append(answer2);
            fileWriter.append(answer3);
            fileWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static void remove() {
        System.out.println("remove");
    }

    public static void list() {
        Path path = Paths.get("src/pl/coderslab/tasks.csv");
        int i =0;
        try {
            for (String list : Files.readAllLines(path)) {
                list=list.replace(",","  ");
                System.out.println(i+" : "+list);
                i++;
            }
        } catch (IOException e) {
            System.err.println(" ");
        }
        System.out.println("To juz koniec naszych danych!");
        System.out.println();


    }
}
