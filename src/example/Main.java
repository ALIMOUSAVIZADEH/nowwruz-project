package example;

import db.Database;
import db.exception.EntityNotFoundException;

public class Main {
    public static void main(String[] args) {
        Human ali = new Human("Ali");
        Database.add(ali);

        ali.name = "Ali Hosseini";

        Human fromDB = (Human) Database.get(ali.id);
        System.out.println("اسم در دیتابیس: " + fromDB.name);
    }
}