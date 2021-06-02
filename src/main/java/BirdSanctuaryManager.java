import java.util.HashSet;
import java.util.Set;

public class BirdSanctuaryManager {
    Set<Bird> birdList = new HashSet<Bird>();
    private static BirdSanctuaryManager instance;
    public static BirdSanctuaryManager getInstance() {
        if (instance == null) {
            instance = new BirdSanctuaryManager();
        }
        return instance;
    }

    private BirdSanctuaryManager() {

    }

    public void add(Bird bird) {
        try {
            if (bird == null) {
                throw new BirdSanctuaryException("null not valid");
            }
            else {
                birdList.add(bird);
                bird.incrementCount();
            }
        }
        catch (BirdSanctuaryException e) {
            e.printStackTrace();
        }
    }

    public void remove(Bird bird) throws BirdSanctuaryException{
        if (birdList.contains(bird)) {
            birdList.remove(bird);
            bird.decrementCount();
        }else {
            throw new BirdSanctuaryException("bird is not present");
        }
    }

    public int getAllCount() {
        return birdList.size();
    }

    public void printFlyable() {
        birdList.stream().filter(bird -> bird instanceof Flyable)
                .forEach(bird -> ((Flyable) bird).fly());
    }

    public void printSwimable() {
        birdList.stream().filter(bird -> bird instanceof Swimable)
                .forEach(bird -> ((Swimable) bird).swim());
    }

    public void printEatable() {
        birdList.stream().forEach(bird -> (bird).eat());

    }
}