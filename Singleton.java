public class Singleton{
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void doSomething() {
        System.out.println("Singleton instance is doing something.");
    }

    public static void main(String[] args) {
        Singleton o = Singleton.getInstance();
        o.doSomething();

        Singleton b = Singleton.getInstance();
        b.doSomething();

        System.out.println(o == b);
    }
}