package pl.coderslab;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        while(!choice.contains("exit")){
            System.out.println(ConsoleColors.BLUE + "Please select an option");
            System.out.println(ConsoleColors.RESET+"add");
            System.out.println("remove");
            System.out.println("list");
            System.out.println("exit");
            choice=scan.nextLine();

            if(choice.contains("add")){
                add();
            }else if(choice.contains("remove")){
                remove();
            }else if(choice.contains("list")){
                list();
            }
        }
    }

    public static void add(){
        System.out.println("add");
    }

    public static void remove(){
        System.out.println("remove");
    }

    public static void list(){
        System.out.println("list");
    }
}
