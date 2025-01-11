package org.serugle.sergey.notes;

import org.serugle.sergey.notes.repository.Repository;

import java.util.Scanner;

public class Handler {
    Repository repository;
    Scanner scanner;

    public Handler() {
        this.repository = new Repository();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String command;
        String user;
        String note;
        while (true){
            System.out.print("Command (all, get_owner, clear, add, delete_user, stop): ");
            command = this.scanner.nextLine();
            if (command.equals("stop")){
                break;
            }
            else if (command.equals("delete_user")){
                System.out.print("User: ");
                user = this.scanner.nextLine();
                this.repository.deleteUser(user);
            }
            else if (command.equals("add")){
                System.out.print("User: ");
                user = this.scanner.nextLine();
                System.out.print("Note: ");
                note = this.scanner.nextLine();
                this.repository.addNote(user, note);
            }
            else if (command.equals("clear")){
                this.repository.clear();
            }
            else if (command.equals("get_owner")){
                System.out.print("Note: ");
                note = this.scanner.nextLine();
                System.out.println(this.repository.getOwnerOf(note));
            }
            else if (command.equals("all")){
                this.repository.fetchAll();
            }
        }
        this.scanner.close();
    }
}
