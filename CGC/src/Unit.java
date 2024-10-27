public class Unit {

    protected int radius;
    protected int velocity;
    protected int hp;
    protected int angle;
    protected Weapon weapon;
    protected int x;
    protected int y;

    public Unit() {
        this.radius = 20;
        this.hp = 100;
        this.weapon = new Weapon();
        this.angle = 0;
        this.velocity = 1;
        World.getWorld().addMyUnits(this);
    }

    public void setAngle(int angle) {
        if (this.angle + angle > 360) {
            this.angle += angle;
            this.angle -= 360;
        }
        this.angle += angle;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void shot() {
        // Не знаю как реализовать. Идея такая:
        // Мы смотрит на угол, в который смотрит юнит, если это 0, то идем по оси х вправо
        // Если от 0 до 90, то идем по диагонали вправо вверх, если 90, то идеам только по оси у вперед
        // если от 90 до 180, то идем по диагонали влево вверх, если 180, то от нынешнего положения юнита идем назад по х
        // если от 180 до 270, то идем по диагонали влево вниз, если 270, то идем по у вниз,
        // если от 270 до 360, то по диагонали вправо вниз
    }

    public void setCords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getCords() {
        return x + " " + y;
    }

    public String getWeaponInfo() {
        return weapon.toString();
    }



}
