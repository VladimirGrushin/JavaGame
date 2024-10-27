public class Weapon {

    private int velocity;
    private int radius;


    public Weapon() {
        this.velocity = 3;
        this.radius = 5;
    }

    public void shot() {
        // TODO
    }

    @Override
    public String toString() {
        return velocity + " " + radius;
    }
}
