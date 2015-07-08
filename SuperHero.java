[import java.util.Random;
    /**
    * This class describes superheroes for the game.
    * @author Crishna Iyengar
    * @version 1.0
    */
public class SuperHero {
    private int attack;
    private int defense;
    private int health;
    private String superName;
    private Tool weapon;
    private Random randy;
    /**
    * This constructor has no arguments.
    * @return Spiderman.
    */
    public SuperHero() {
        this.attack = 1;
        this.defense = 1;
        this.health = 1;
        this.superName = "Spiderman";
        this.weapon = new Tool("Web", 200);
    }
    /**
    * This constructor has five arguments.
    * @param 1 attack
    * @param 2 defense
    * @param 3 health
    * @param 4 name
    * @param 5 weapon
    * @return object Superhero.
    */

    public SuperHero(int attack, int defense, int health,
        String superName, Tool weapon) {
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.superName = superName;
        this.weapon = weapon;
    }
    /**
    * This method has no arguments.
    * @return attackpoints.
    */

    public int getAttack() {
        return attack;
    }
    /**
    * This method has no arguments.
    * @return defense.
    */

    public int getDefense() {
        return defense;

    }
    /**
    * This method has no arguments.
    * @return health.
    */

    public int getHealth() {
        return health;
    }
    /**
    * This method has no arguments.
    * @return name.
    */

    public String getSuperName() {
        return superName;
    }
    /**
    * This method has no arguments.
    * @return weapon.
    */

    public Tool getWeapon() {
        return weapon;
    }
        /**
    * This constructor has one argument.
    * @papram health
    * @return superhero with health param.
    */

    public void setHealth(int health) {
        this.health = health;
    }
    /**
    * This method has no arguments.
    * @return attackdamage a random value.
    */

    public int getAttackDamage() {
        randy = new Random();
        int randoInt = randy.nextInt(20) - 5;
        int attackDamage = attack + randoInt;
        return attackDamage;
    }
}

