package beans;

import java.util.Set;
import java.util.HashSet;

public class Animals {
    private Set<String> names;

    public Animals() {
    	names = new HashSet<>();
    }

    public Set<String> getNames() {
    	return names;
    }

    public void addName(String name) {
    	names.add(name);
    }

    public void removeName(String name) {
    	names.remove(name);
    }

    public boolean containsName(String name) {
    	return names.contains(name);
    }

    public void removeAll() {
    	names.clear();
    }
}