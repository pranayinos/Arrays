package simplepatterns;

public final class SingletonOne {
    private final String name;
    private final String id;

    private SingletonOne(String name, String id) {
        this.name = name;
        this.id = id;
    }

    private static volatile SingletonOne holder;

    public static SingletonOne getInstance(String name, String id) {
        if(holder==null){
            synchronized(SingletonOne.class){
                if(holder == null){
                    holder = new SingletonOne(name, id);
                }
            }
        }
        return holder;
    }
}
