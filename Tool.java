import java.util.Random;
    /**
    * This class is for tools in the game.
    * @author Crishna Iyengar
    * @version 1.0
    */

public class Tool {
    private String name;
    private int maxDamage;
    private Random randy;
    /**
    * This constructor has two arguments.
    * @param name and damage
    * @return tool with name and damage.
    */

    public Tool(String name, int maxDamage) {
        this.name = name;
        this.maxDamage = maxDamage;
    }
    /**
    * This method has no arguments.
    * @return name.
    */

    public String getName() {
        return name;
    }
    /**
    * This method has no arguments.
    * @return attack damage a random number.
    */

    public int getAttackDamage() {
        randy = new Random();
        int attackDamage = randy.nextInt(maxDamage);
        return attackDamage;

    }

}