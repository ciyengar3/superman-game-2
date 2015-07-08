import java.util.Scanner;
import java.util.Random;
/**
* This class runs the Bman-Sman game. Main method.
*@author Crishna Iyengar
*version 1.0
*/
public class Game {
    
    public static void main(String[] args) {
        while (true) {
            Scanner scan = new Scanner(System.in);
            int count = 1;
            int fleeCount = 0;
            Tool tool01 = new Tool("Batarangs", 150);
            Tool tool11 = new Tool("Laser Vision", 150);
            Tool tool02 = new Tool("Utility Belt", 100);
            Tool tool12 = new Tool("Super Strength", 100);
            Tool tool03 = new Tool("Bat Rope", 75);
            Tool tool13 = new Tool("Hand Swipe", 75);
            Tool tool00;
            Tool tool10;
            Goon goon1 = new Goon(10 , 25);
            int goonHealth = goon1.getHealthPoints();
            SuperHero super0;
            SuperHero villian0;
            String superName;
            String greeting;
            boolean isAlive = true;
            System.out.print("Hey! Please select a difficulty!");
            System.out.print("\n1. Easy\n2. Medium\n3. Hard\n");
            int difficulty = scan.nextInt();
            if (difficulty == 1) {
                System.out.println("Easy Mode Enabled.");
            } else if (difficulty == 2) {
                System.out.println("Medium Mode Enabled.");
            } else {
                System.out.println("Hard mode Enabled.");
            }
            scan.nextLine();
            System.out.println("Please choose your character");
            System.out.println("by typing a number.");
            System.out.println("1. Batman\n 2. Superman");
            int superHero = scan.nextInt();
            if (superHero == 1) {
                superName = "Batman";
                System.out.println("Batman is selected.");
                System.out.print("Superman is under control of the sith lord!");
                System.out.println("It is your job to stop him,");
                System.out.println(" but you must first his goons.");
                System.out.println("Good luck Batman!");
            } else {
                superName = "Superman";
                System.out.println("Superman is selected.");
                System.out.println("Batman is under control of the sith lord!");
                System.out.print(" It is your job to stop him, ");
                System.out.println("but you must first his goons.");
                System.out.println("Good luck Superman!");
            }
        //FINISH THIS IF STATEMENT
            if (difficulty == 1 && superHero == 1) {
                super0 = new SuperHero(300 , 20 , 300 , superName, tool01);
                villian0 = new SuperHero(100 , 15 , 100 , "Superman" , tool13);
                tool00 = tool01;
                tool10 = tool13;
            } else if (difficulty == 2 && superHero == 1) {
                super0 = new SuperHero(250 , 20 , 250 , superName , tool02);
                villian0 = new SuperHero(150 , 15 , 150 , "Superman" , tool12);
                tool00 = tool02;
                tool10 = tool12;
            } else if (difficulty == 3 && superHero == 1) {
                super0 = new SuperHero(220 , 20 , 220 , superName, tool03);
                villian0 = new SuperHero(300 , 100 , 1000 , "Superman", tool11);
                tool00 = tool03;
                tool10 = tool11;
            } else if (difficulty == 1 && superHero == 2) {
                super0 = new SuperHero(300 , 20 , 300 , superName, tool11);
                villian0 = new SuperHero(100 , 15 , 100 , "Batman" , tool03);
                tool00 = tool11;
                tool10 = tool03;
            } else if (difficulty == 2 && superHero == 2) {
                super0 = new SuperHero(250 , 20 , 250 , superName , tool12);
                villian0 = new SuperHero(150 , 15 , 150 , "Batman" , tool02);
                tool00 = tool12;
                tool10 = tool02;
            } else {
                super0 = new SuperHero(220 , 20 , 220 , superName, tool13);
                villian0 = new SuperHero(300 , 100 , 1000 , "Batman", tool11);
                tool00 = tool13;
                tool10 = tool11;
            }


            scan.nextLine();
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    goon1 = goon1;
                } else if (i == 2) {
                    goon1.setAttackPoints(30 + difficulty * 5);
                    goon1.setHealth(40 + difficulty * 5);
                } else {
                    goon1.setAttackPoints(35 + difficulty * 5);
                    goon1.setHealth(45 + difficulty * 5);
                }
                greeting = goon1.challenge();
                System.out.println("\n\n\n\n" + greeting + "I am goon " + i);
                while (goon1.getHealthPoints() >= 0
                    && super0.getHealth() >= 0) {
                    System.out.print("What do you do?");
                    System.out.println("\n1. Attack");
                    System.out.println("2. Special Attack");
                    System.out.println("3. Flee");
                    System.out.println("4. View Stats");
                    int move = scan.nextInt();
                    if (move == 1) {
                        int attack = super0.getAttackDamage();
                        goon1.loseHealth(attack);
                        int diff = super0.getDefense()
                            - goon1.getAttackDamage();
                        if (diff < 0) {
                            super0.setHealth(super0.getHealth() + diff);
                            diff = -diff;
                        } else {
                            diff = 0;
                        }
                        if (goon1.getHealthPoints() <= 0) {
                            System.out.print("Goon is ");
                            System.out.print("damaged beyond repair!");
                            System.out.println(superName + "'s attack did ");
                            System.out.print(attack + " damage on the goon!");
                            System.out.println("The goon did ");
                            System.out.print(diff + " damage on " + superName);
                        } else if (super0.getHealth() <= 0) {
                            System.out.println(superName);
                            System.out.print(" is beyond repair.");
                            System.out.print(" You lose the game.");
                            System.out.print("Would you like to");
                            System.out.print(" play again? (1 - no 2 -yes)");
                            int answer = scan.nextInt();
                            scan.nextLine();
                            if (answer == 1) {
                                System.exit(0);
                            } else {
                                i = 6;
                                isAlive = false;
                            }
                        } else {
                            System.out.println("The goon still lives!");
                            System.out.println(superName + "'s attack did ");
                            System.out.print(attack + " damage on the goon!");
                            System.out.println("The goon did ");
                            System.out.print(goon1.getAttackDamage());
                            System.out.print(" damage on " + superName);
                        }
                    } else if (move == 2) {
                        int attack = tool00.getAttackDamage();
                        goon1.loseHealth(attack);
                        int diff = super0.getDefense()
                            - goon1.getAttackDamage();
                        if (diff < 0) {
                            super0.setHealth(
                                super0.getHealth() + diff);
                            diff = -diff;
                        } else {
                            diff = 0;
                        }

                        if (goon1.getHealthPoints() <= 0) {
                            System.out.println("Goon");
                            System.out.print(" is damaged beyond repair!");
                            System.out.println(superName + "'s "
                                + tool00.getName() + " did "
                                + attack + " damage on the goon!");
                            System.out.println("The goon did "
                                + diff + " damage on "
                                + superName);
                        } else if (super0.getHealth() <= 0) {
                            System.out.println(superName
                                + " is beyond repair. You lose the game."
                                + "Would you like to play again?"
                                + "(1 - no 2 -yes)");
                            int answer = scan.nextInt();
                            scan.nextLine();
                            if (answer == 1) {
                                System.exit(0);
                            } else {
                                i = 6;
                                isAlive = false;
                            }
                        } else {
                            System.out.println("The goon still lives!");
                            System.out.println(superName
                                + "'s attack did " + attack
                                + " damage on the goon!");
                            System.out.println("The goon did "
                                + diff + " damage on "
                                + superName);
                        }
                    } else if (move == 3) {
                        fleeCount++;
                        if (fleeCount % 4 == 0) {
                            System.out.println(superName
                                + " successfully fled!");
                            goon1.loseHealth(1000000);
                        } else {
                            System.out.println("You failed"
                                + " to flee!");
                            int diff = super0.getDefense()
                                - goon1.getAttackDamage();
                            if (diff < 0) {
                                super0.setHealth(super0.getHealth() + diff);
                                diff = -diff;
                                System.out.println("The goon did "
                                    + diff + " damage on "
                                    + superName);
                            } else {
                                System.out.println("The goon did no damage on "
                                    + superName);
                            }
                        }
                    } else {
                        System.out.println(superName
                            + " Health: "
                            + super0.getHealth());
                        System.out.println("Goon Health : "
                            + goon1.getHealthPoints());
                    }
                }
                System.out.println("\nBatman: I am the best ever.");
                System.out.println("Superman: You suck.");
            }
    //final battle is here
            String villian;
            if (superHero == 1) {
                villian = "Superman";
            } else {
                villian = "Batman";
            }
            Random randy = new Random();
            while (villian0.getHealth() >= 0 && super0.getHealth() >= 0) {
                System.out.print("What do you do?");
                System.out.println("\n1. Attack");
                System.out.println("2. Special Attack");
                System.out.println("3. Flee");
                System.out.println("4. View Stats");
                int move = scan.nextInt();
                int villianAttack = villian0.getAttackDamage();
                int specialVillianAttack = tool10.getAttackDamage();
                int randoNum = randy.nextInt(1);
                int heroAttack;
                int fight;
                int fight2;
                if (move == 1) {
                    heroAttack = super0.getAttackDamage();
                } else {
                    heroAttack = tool00.getAttackDamage();
                }
                if (randoNum == 1) {
                    villianAttack = specialVillianAttack;
                }
                if ((move == 1) || (move == 2)) {
                    if (heroAttack > villian0.getDefense()) {
                        fight = heroAttack - villian0.getDefense();
                        villian0.setHealth(villian0.getHealth() - fight);
                    } else {
                        fight = 0;
                    }
                    if (villianAttack > super0.getDefense()) {
                        fight2 = villianAttack - super0.getDefense();
                        super0.setHealth(super0.getHealth() - fight2);
                    } else {
                        fight2 = 0;
                    }
                    System.out.println(superName
                        + " did " + fight
                        + " damage on " + villian);
                    System.out.println(villian + " did "
                        + fight2 + " damage on "
                        + superName);
                } else if (move == 3) {
                    if (fleeCount % 50 == 25) {
                        System.out.println("Congratulations "
                            + superName
                            + "! Great job on winning!"
                            + " Do you want to play again? (1- N 2- Y)");
                        int play = scan.nextInt();
                        scan.nextLine();
                        if (play == 1) {
                            System.exit(0);
                        }
                    } else {
                        System.out.println("You failed to flee!");
                        fleeCount++;
                        if (villianAttack
                            > super0.getDefense()) {
                            fight2 = villianAttack - super0.getDefense();
                            super0.setHealth(super0.getHealth() - fight2);
                            System.out.println(villian
                                + " attack did " + fight2
                                + " damage on " + superName);
                        }
                    }
                } else {
                    System.out.println(superName
                        + " Health: "
                        + super0.getHealth());
                    System.out.println(villian
                        + " Health: "
                        + villian0.getHealth());
                }
                if (villian0.getHealth() <= 0) {
                    System.out.println("Congrats "
                        + superName
                        + " on winning the game."
                        + " Do you want to play again? (1-N 2-Y)");
                    int play2 = scan.nextInt();
                    if (play2 == 1) {
                        System.exit(0);
                    }
                } else if (super0.getHealth() <= 0) {
                    System.out.println("Sorry you lost the game."
                        + " Do you want to play again? (1-N 2-Y)");
                    int play3 = scan.nextInt();
                    if (play3 == 1) {
                        System.exit(0);
                    }
                }
            }
        }
    }
}