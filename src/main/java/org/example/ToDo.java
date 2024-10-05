package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    private ArrayList<Item> list;

    public ToDo(){
        this.list = new ArrayList();
    }

    public void addItem(String importance, String item){
        Item newItem = new Item(importance, item);
        this.list.add(newItem);
    }
    public void addItem(String item){
        Item newItem = new Item(item);
        this.list.add(newItem);
    }

    public void finishItem(Item item){
        this.list.remove(item);
    }

    public void getList() {
        if(this.list.isEmpty()){
            System.out.println("You have no items To Do");
        }else{
            System.out.println("Your To-Do List:\n====================================\n");

            for (int i = 0; i < list.size(); i++) {
                Item currentItem = list.get(i);
                System.out.println( i+1 + ". "+" Urgency: " + currentItem.getImportance() + " ,Task: " + currentItem.getTask()+ "\n");
            }
            System.out.println("====================================");
        }

    }

    public static void main(String[] args) {
        ToDo newList = new ToDo();
        boolean exit = false;
        while(!exit){
            newList.getList();
            System.out.println("What would you like to do?");
            System.out.println("1. Add Item");
            System.out.println("2. Finish Item");
            System.out.println("3. Update Items Urgency");
            System.out.println("4. Exit Program");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Please enter your task");
                    String task = sc.nextLine();
                    System.out.println("Would you like to add an importance level?(Y/N, Default Medium)");
                    String choice1 = sc.nextLine();
                    if(choice1.equals("Y")){
                        System.out.println("Please enter the importance level");
                        String importance = sc.nextLine();
                        Item newItem = new Item(task, importance);
                        newList.addItem(task, importance);
                        System.out.println("You have successfully added an item to the To-Do List");
                    }else{
                        newList.addItem(task);
                        System.out.println("You have successfully added an item to the To-Do List");
                    }
                    break;
                case 2:
                    System.out.println("Please enter the number corresponding to the Item you wish to remove");
                    int num = sc.nextInt();
                    Item itemToDelete = newList.list.get(num - 1);
                    newList.finishItem(itemToDelete);
                    System.out.println("You have successfully removed an item from the To-Do List");
                    break;
                case 3:
                    System.out.println("Please enter the number corresponding to the Item you wish to update");
                    int num2 = sc.nextInt();
                    sc.nextLine();
                    Item itemToUpdate = newList.list.get(num2 - 1);
                    System.out.println("Please enter the new importance level");
                    String importance = sc.nextLine();
                    itemToUpdate.setImportance(importance);
                    System.out.println("You have successfully updated an item from the To-Do List");
                    break;
                case 4:
                    exit = true;
                    break;

            }
        }
    }
}