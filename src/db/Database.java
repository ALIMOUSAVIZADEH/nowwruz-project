package db;

import db.exception.EntityNotFoundException;
import db.exception.InvalidEntityException;
import example.Trackable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;


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

    public static void add(Entity e) {
        e.id = nextId++;
        if (e instanceof Trackable trackable) {
            Date now = new Date();
            trackable.setCreationDate(now);
            trackable.setLastModificationDate(now);
        }
        entities.add(e);
    }
    public static void update(Entity e) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                if (e instanceof Trackable trackable) {
                    trackable.setLastModificationDate(new Date());
                }
                entities.set(i, e);
                return;
            }
        }
        throw new EntityNotFoundException(e.id);
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