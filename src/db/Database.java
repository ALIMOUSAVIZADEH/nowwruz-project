package db;

import db.exception.EntityNotFoundException;
import db.exception.InvalidEntityException;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private static final ArrayList<Entity> entities = new ArrayList<>();
    private static int nextId = 1;
    private static HashMap<Integer, Validator> validators = new HashMap<>();

    public static void registerValidator(int entityCode, Validator validator) {
        if (validators.containsKey(entityCode)) {
            throw new IllegalArgumentException("Validator already exists for entity code: " + entityCode);
        }
        validators.put(entityCode, validator);
    }

    public static void add(Entity e) throws InvalidEntityException {
        Validator validator = validators.get(e.getEntityCode());
        if (validator != null) {
            validator.validate(e);
        }
        e.id = nextId++;
        entities.add(e.copy());
    }

    public static Entity get(int id) {
        for (Entity e : entities) {
            if (e.id == id) {
                return e.copy();
            }
        }
        throw new EntityNotFoundException(id);
    }
}