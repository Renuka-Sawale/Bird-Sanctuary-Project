public class Penguin extends Bird implements Swimable {

    static int count = 0;

    public Penguin(String id) {
        this.id = id;
        this.color = "Black-White";
    }

    public void eat() {
        System.out.println("Penguin is eating");
    }

    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    int getCount() {
        return count;
    }

    @Override
    void incrementCount() {
        count++;
    }

    @Override
    void decrementCount() {
        count--;
    }
}