package org.serugle.sergey.notes;

import org.serugle.sergey.notes.model.Note;
import org.serugle.sergey.notes.repository.NoteRepository;

import java.util.Scanner;

public class Handler {
    private NoteRepository noteRepository;
    private Scanner scanner;

    public Handler() {
        this.noteRepository = new NoteRepository();
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
                this.noteRepository.deleteUser(user);
            }
            else if (command.equals("add")){
                System.out.print("User: ");
                user = this.scanner.nextLine();
                System.out.print("Note: ");
                note = this.scanner.nextLine();
                this.noteRepository.addNote(user, note);
            }
            else if (command.equals("clear")){
                this.noteRepository.clear();
            }
            else if (command.equals("get_owner")){
                System.out.print("Note: ");
                note = this.scanner.nextLine();
                System.out.println(this.noteRepository.getOwnerOf(note));
            }
            else if (command.equals("all")){
                for (Note noteF : this.noteRepository.fetchAll()) {
                    System.out.print("Owner: " + noteF.owner);
                    System.out.println();
                    System.out.print("Note: " + noteF.note);
                    System.out.println();
                    System.out.println();
                    System.out.println();
                }
            }
        }
        this.scanner.close();
    }
}
