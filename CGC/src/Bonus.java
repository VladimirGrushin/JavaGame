public class Bonus {

    private int radius;
    private int x;
    private int y;

    public Bonus() {
        this.radius = 10;
        World.getWorld().addBonuses(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setCords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getCords() {
        return x + " " + y;
    }
}
