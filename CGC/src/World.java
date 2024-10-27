
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {

    final private int width;
    final private int height;

    private int currentTime; // Текущий ход
    private int totalCount; // Продолжительность боя (2000 ходов)

    private List<Bonus> bonuses;
    private List<Unit> enemyUnits;
    private List<Unit> myUnits;
    private List<Weapon> weapons;

    private static String[][] gameWorld;


    private static World world;

    private World() {
        this.width = 2048;
        this.height = 1536;
        this.totalCount = 2000;
        this.currentTime = 0;

        gameWorld = new String[height][width];

        bonuses = new ArrayList<>();
        enemyUnits = new ArrayList<>();
        myUnits = new ArrayList<>();
        weapons = new ArrayList<>();
    }

    public static World getWorld() {
        if (world == null) {
            world = new World();
        }
        return world;
    }

    // Известная проблема:
    // Надо делать в идеале символы B радиусом объекта, соотвественно и проверять наличие других объектов в этом радиусе
    // Я не знаю как это сделать
    public void addBonuses(Bonus bonus) {
        bonuses.add(bonus);
        Random rn = new Random();
        int randomHeight = rn.nextInt(height);
        int randomWidth = rn.nextInt(width);
        while (gameWorld[randomHeight][randomWidth] != null) {
            randomHeight = rn.nextInt(height);
            randomWidth = rn.nextInt(width);
        }

        gameWorld[randomHeight][randomWidth] = "B";

        bonus.setCords(randomWidth, randomHeight);
    }

    public void getGameWorld() {
        for (int i = 0; i < gameWorld.length; i++) {
            for (int j = 0; j < gameWorld[0].length; j++) {
                if (gameWorld[i][j] != null) {
                    System.out.print(gameWorld[i][j] + " ");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public String getBonusCords(Bonus bonus) {
        return bonus.getCords();
    }

    public void addEnemyUnits(EnemyUnit enemyUnit) {
        enemyUnits.add(enemyUnit);

        int x = 0;
        int y = 0;
        while (gameWorld[y][x] != null) {
            x += 1;
            y += 1;
        }

        gameWorld[y][x] = "EU";
        enemyUnit.setCords(x, y);
    }

    public List<Unit> getEnemyUnits() {
        return enemyUnits;
    }

    public void addMyUnits(Unit myUnit) {
        myUnits.add(myUnit);

        int x = 0;
        int y = 0;
        while (gameWorld[y][x] != null) {
            x += 1;
            y += 1;
        }

        gameWorld[y][x] = "U";
        myUnit.setCords(x, y);
    }

    // При желании, можно String заменить на два отдельных метода x and y, но можно и так
    public String getMyUnitCords(Unit unit) {
        return unit.getCords();
    }

    public String getEnemyUnitCords(EnemyUnit unit) {
        return unit.getCords();
    }

    public List<Unit> getMyUnits() {
        return myUnits;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getMyUnitInfo(Unit unit) {
        return unit.hp;
    }

    public int getEnemyUnitInfo(Unit unit) {
        return unit.hp;
    }

    @Override
    public String toString() {
        return width + " " + height;
    }
}
