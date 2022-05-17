package fr.uga.pddl4j.util;

public interface Clonable<T extends Object> {

    public T clone();
    public T deepClone();
}
