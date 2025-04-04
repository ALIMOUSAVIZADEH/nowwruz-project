package db;

import db.exception.EntityNotFoundException;
import java.util.ArrayList;

public class Database {
    private static final ArrayList<Entity> entities = new ArrayList<>();
    private static int nextId = 1;

    public static void add(Entity e) {
        e.id = nextId++;
        entities.add(e);
    }

    public static Entity get(int id) {
        for (Entity e : entities) {
            if (e.id == id) {
                return e;
            }
        }
        throw new EntityNotFoundException(id);
    }

    public static void delete(int id) {
        Entity toRemove = null;
        for (Entity e : entities) {
            if (e.id == id) {
                toRemove = e;
                break;
            }
        }
        if (toRemove == null) {
            throw new EntityNotFoundException(id);
        }
        entities.remove(toRemove);
    }

    public static void update(Entity e) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                entities.set(i, e);
                return;
            }
        }
        throw new EntityNotFoundException(e.id);
    }

    void add() {

    }
}
}
