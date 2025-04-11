package example;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Entity> entities;

    public Database() {
        entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    @Override
    public String toString() {
        return "Database{entities=" + entities + '}';
    }
}