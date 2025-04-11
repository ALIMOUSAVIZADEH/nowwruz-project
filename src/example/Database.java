package example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    private static final List<Entity> entities = new ArrayList<>();
    private static int nextId = 1;

    public static void add(Entity e) {
        e.id = nextId++;
        if (e instanceof Trackable) {
            Date now = new Date();
            ((Trackable) e).setCreationDate(now);
            ((Trackable) e).setLastModificationDate(now);
        }
        entities.add(e);
    }

    public static Entity get(int id) {
        for (Entity e : entities) {
            if (e.id == id) {
                return e;
            }
        }
        throw new RuntimeException("Entity not found");
    }

    public static void update(Entity e) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == e.id) {
                if (e instanceof Trackable) {
                    ((Trackable) e).setLastModificationDate(new Date());
                }
                entities.set(i, e);
                return;
            }
        }
        throw new RuntimeException("Entity not found");
    }
}