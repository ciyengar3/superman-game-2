import java.util.Random;
/**
* This is the class for Goons in the game. 
* @author Crishna Iyengar
* @version 1.0
*/
public class Goon {
    private Random randy;
    private int attackPoints;
    private int healthPoints;
    private final int DEFAULT_ATTACK = 100;
    private final int DEFAULT_HEALTH = 50;
        /**
    * This constructor has two arguments.
    * @return goon with set attack and health points.
    */
    public Goon(int attackPoints, int healthPoints) {
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
    }
    /**
    * This constructor has no arguments.
    * @return goon with default attack and health.
    */
    public Goon() {
        this.attackPoints = DEFAULT_ATTACK;
        this.healthPoints = DEFAULT_HEALTH;
    }
    /**
    * This method has no arguments.
    * @return attackPoints of goon.
    */
    public int getAttackPoints() {
        return attackPoints;
    }
    /**
    * This method has no arguments.
    * @return healthPoints of goon.
    */
    public int getHealthPoints() {
        return healthPoints;
    }
    /**
    * This method has one argument.
    * @param attackPoints of goon.
    * @return changes goon's attackPoints.
    */
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
    /**
    * This method has one argument.
    *@param health lost of goon in turn.
    * @return goon with new healthPoints.
    */
    public void loseHealth(int healthLost) {
        if (healthLost >= 0) {
            healthPoints -= healthLost;
        } else {
            healthPoints += healthLost;
        }
    }
    /**
    * This method has no arguments.
    * @return attackPoints of goon.
    */
    public int getAttackDamage() {
        randy = new Random();
        int randomAttack = randy.nextInt(9) + 1;
        int attackPlusRandom = randomAttack + attackPoints;
        return attackPlusRandom;
    }
    /**
    * This method has no arguments.
    * @return string of challenge.
    */
    public String challenge() {
        String fight = "You are going DOWN!";
        return fight;
    }
    /**
    * This method has one arguments.
    * @param Takes in new health.
    * @return new health of goon.
    */
    public void setHealth(int healthPoints) {
        this.healthPoints = healthPoints;
    }
}