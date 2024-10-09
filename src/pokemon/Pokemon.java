package pokemon;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {
    private final String name;
    private int level;
    private int hp;
    private final List<String> attacks = new ArrayList<String>();
    private String type;
    private String food;
    private String sound;

    /**
     * Constructs a Pokemon with the given name, level, HP, food, and sound.
     *
     * @param name  the name of the Pokemon
     * @param level the level of the Pokemon
     * @param hp    the HP of the Pokemon
     * @param food  the food the Pokemon likes
     * @param sound the sound the Pokemon makes
     */
    public Pokemon(String name, int level, int hp, String food, String sound) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
    }

    /**
     * Adds an attack to the Pokemon's list of attacks.
     *
     * @param attack the attack to add
     */
    public void addAttack(String attack) {
        attacks.add(attack);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }


    public int getLevel() {
        return level;
    }

    /**
     * Sets the level of the Pokemon.
     *
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }


    public int getHp() {
        return hp;
    }

    /**
     * Sets the HP of the Pokemon.
     *
     * @param hp the HP to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public String getType() {
        return type;
    }

    /**
     * Sets the type of the Pokemon.
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    public String getFood() {
        return food;
    }

    /**
     * Sets the food of the Pokemon.
     *
     * @param food the food to set
     */
    public void setFood(String food) {
        this.food = food;
    }

    public String getSound() {
        return sound;
    }

    /**
     * Sets the sound of the Pokemon.
     *
     * @param sound the sound to set
     */
    public void setSound(String sound) {
        this.sound = sound;
    }

    public String toString() {
        return "Pokemon: " + name + " Level: " + level + " HP: " + hp;
    }

    public abstract void eats();

    public void speaks() {
        System.out.println(getName() + " says " + getSound());
    }

    /**
     * Feeds the Pokemon with the given food.
     * If the food is the same as the Pokemon's type, the Pokemon will gain 20 HP.
     * Otherwise, the Pokemon will spit out the food.
     *
     * @param food the food to feed the Pokemon
     */
    public void feed(String food) {
        System.out.println(getName() + " eats " + food);

        if (food.equals(type)) {
            System.out.println("Yum! " + getName() + " wants more " + food);
            setHp(getHp() + 20);
        } else {
            System.out.println("Yuck! " + getName() + " spits out " + food);
        }
    }

    /**
     * Levels up the Pokemon and fully heals it by increasing its HP by 10 until it reaches 100.
     */
    public void levelUp() {
        System.out.println(getName() + " levels up!");
        setLevel(getLevel() + 1);
        var currentHp = getHp();

        // when a Pokemon levels up, he should be fully healed
        while (currentHp <= 100) {
            System.out.println(getName() + " is healing! HP: " + currentHp);
            setHp(currentHp + 10);
            currentHp = getHp();
        }
    }

    /**
     * Reduces the Pokemon's HP by the given damage amount.
     * If the Pokemon's HP is less than or equal to 0, it indicates that the Pokemon has fainted.
     *
     * @param damage the amount of damage to reduce from the Pokemon's HP
     */
    public void gotHit(int damage) {
        hp -= damage;
        if (hp <= 0) {
            System.out.println(getName() + " fainted!");
        } else {
            System.out.println(getName() + " took " + damage + " damage! HP: " + hp);
        }
    }


    /**
     * Calculates the damage based on the given power and limit.
     * If the power is greater than half of the limit, the damage is a random value between 10 and 20.
     * Otherwise, the damage is a random value between 1 and 10.
     *
     * @param power the power level to calculate damage from
     * @param limit the limit to compare the power against
     * @return the calculated damage as an integer
     */
    public int calculateDamage(int power, int limit) {
        if (power > limit/2) {
            return (int) (Math.random() * 11) +10;
        } else {
            return (int) (Math.random() * 10) + 1;
        }
    }

    /**
     * Heals the Pokemon by a specified amount if its HP is less than 100.
     * If the Pokemon's HP is already 100 or more, it indicates that the Pokemon is fully healed.
     *
     * @param amount the amount of HP to heal
     */
    public void shouldHeal(int amount) {
        // if the Pokemon's HP is less than 100, heal 30 HP
        if (getHp() < 100) {
            setHp(getHp() + amount);
            System.out.println(getName() + " healed 30 HP! Current HP: " + getHp());
        } else {
            System.out.println(getName() + " is fully healed! HP: " + getHp());
        }
    }
}
