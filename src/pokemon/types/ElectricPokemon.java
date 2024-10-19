package pokemon.types;

import pokemon.Pokemon;

public class ElectricPokemon extends Pokemon {
    private static final int maxVoltage = 5000;
    private int voltageLevel = 3590;
    /**
     * Constructs an ElectricPokemon with the given name, level, HP, food, and sound.
     *
     * @param name  the name of the ElectricPokemon
     * @param level the level of the ElectricPokemon
     * @param hp    the HP of the ElectricPokemon
     * @param food  the food the ElectricPokemon likes
     * @param sound the sound the ElectricPokemon makes
     */
    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        setType("Electric");
        setFood("Candy");
        setSound("Zap");
        addAttack("VoltTackle");
        addAttack("ElectroBall");
        addAttack("Thunder");
        addAttack("ThunderPunch");
    }


    public int getVoltageLevel() {
        return voltageLevel;
    }

    /**
     * Sets the voltage level of the ElectricPokemon.
     *
     * @param voltageLevel the voltage level to set
     */
    public void setVoltageLevel(int voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood());
        setHp(getHp() + 10);
    }

    /**
     * Calculates the damage dealt to an opponent based on their type and the attack weight.
     * The damage is influenced by a type multiplier and the voltage level of the ElectricPokemon.
     *
     * @param opponent the opponent Pokemon
     * @param attackWeight the weight of the attack
     * @return the calculated damage as an integer
     */
    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 2.5;
            case "electric" -> 1.2;
            case "fire" -> 1.5;
            case "grass" -> 2.0;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(voltageLevel, maxVoltage) * attackWeight);
    }

    /**
     * Attacks the opponent Pokemon with the Volt Tackle attack.
     * The attack deals 1.5 times the damage calculated by the damageCalculator method.
     * The voltage level of the ElectricPokemon is reduced by 100.
     * If the ElectricPokemon's HP is less than 100, it heals 30 HP.
     *
     * @param name  the ElectricPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void voltTackle(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.5);
        System.out.println(name + " used Volt Tackle on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setVoltageLevel(voltageLevel - 100);
        // if the Pokemon's HP is less than 100, heal 30 HP
        shouldHeal(30);
    }

    /**
     * Attacks the opponent Pokemon with the Electro Ball attack.
     * The attack deals 1.0 times the damage calculated by the damageCalculator method.
     * The voltage level of the ElectricPokemon is reduced by 50.
     * If the ElectricPokemon's HP is less than 100, it heals 5 HP.
     *
     * @param name  the ElectricPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void electroBall(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(name + " used Electro Ball on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setVoltageLevel(voltageLevel - 50);
        shouldHeal(5);
    }

    /**
     * Attacks the opponent Pokemon with the Thunder attack.
     * The attack deals 1.2 times the damage calculated by the damageCalculator method.
     * The voltage level of the ElectricPokemon is reduced by 200.
     * If the ElectricPokemon's HP is less than 100, it heals 15 HP.
     *
     * @param name  the ElectricPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void thunder(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.2);
        System.out.println(name + " used Thunder on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setVoltageLevel(voltageLevel - 200);
        shouldHeal(15);
    }

    /**
     * Attacks the opponent Pokemon with the Thunder Punch attack.
     * The attack deals 1.0 times the damage calculated by the damageCalculator method.
     * The voltage level of the ElectricPokemon is reduced by 100.
     * If the ElectricPokemon's HP is less than 100, it heals 10 HP.
     *
     * @param name  the ElectricPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void thunderPunch(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(name + " used Thunder Punch on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setVoltageLevel(voltageLevel - 100);
        shouldHeal(10);
    }

}
