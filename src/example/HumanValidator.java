package example;

import db.Entity;
import db.Validator;
import db.exception.InvalidEntityException;

public class HumanValidator implements Validator {
    @Override
    public void validate(Entity entity) throws InvalidEntityException {
        if (!(entity instanceof Human)) {
            throw new IllegalArgumentException("Entity must be Human");
        }

        Human human = (Human) entity;
        if (human.age < 0) {
            throw new InvalidEntityException("Age must be positive");
        }
        if (human.name == null || human.name.trim().isEmpty()) {
            throw new InvalidEntityException("Name cannot be empty");
        }
    }
}