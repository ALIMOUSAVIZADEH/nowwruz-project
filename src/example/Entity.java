package example;

import java.util.ArrayList;
import java.util.List;

public class Entity {
    private String name;
    private List<Field> fields;

    public Entity(String name) {
        this.name = name;
        this.fields = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    @Override
    public String toString() {
        return "Entity{name='" + name + "', fields=" + fields + '}';
    }
}