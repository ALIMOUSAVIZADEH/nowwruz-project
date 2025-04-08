package example;

import db.Database;
import db.exception.InvalidEntityException;

public class Main {
    public static void main(String[] args) {
        try {
            Database.registerValidator(Human.HUMAN_ENTITY_CODE, new HumanValidator());

            Human validHuman = new Human("Ali", 25);
            Database.add(validHuman);
            System.out.println("✅ Human added successfully!");

            Human invalidAge = new Human("Reza", -5);
            Database.add(invalidAge);
        } catch (InvalidEntityException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Configuration Error: " + e.getMessage());
        }
    }
}