public class EnemyUnit extends Unit {

    public EnemyUnit() {
        this.radius = 20;
        this.weapon = new Weapon();
        this.angle = 0;
        this.velocity = 1;
        World.getWorld().addEnemyUnits(this);
    }
}
