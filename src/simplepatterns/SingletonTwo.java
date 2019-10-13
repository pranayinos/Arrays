package simplepatterns;

public enum SingletonTwo {
    INSTANCE("name", "id");
    private final String name;
    private final String id;

    SingletonTwo(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
