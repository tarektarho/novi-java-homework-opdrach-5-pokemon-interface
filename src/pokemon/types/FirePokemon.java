package pokemon.types;

import pokemon.Pokemon;

public class FirePokemon extends Pokemon {
    private static final int maxTemperature = 500;
    private int temperature = 194;

    /**
     * Constructs a FirePokemon with the given name, level, HP, food, and sound.
     *
     * @param name  the name of the FirePokemon
     * @param level the level of the FirePokemon
     * @param hp    the HP of the FirePokemon
     * @param food  the food the FirePokemon likes
     * @param sound the sound the FirePokemon makes
     */
    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        setType("Fire");
        setFood("Charcoal");
        setSound("Roar");
        addAttack("Inferno");
        addAttack("FireLash");
        addAttack("FlameThrower");
        addAttack("PyroBall");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = Math.min(temperature, maxTemperature);
    }

    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood());
        setTemperature(getTemperature() + 100);
        setHp(getHp() + 30);
    }

    /**
     * Calculates the damage dealt to an opponent based on their type and the attack weight.
     * The damage is influenced by a type multiplier and the temperature of the FirePokemon.
     *
     * @param opponent the opponent Pokemon
     * @param attackWeight the weight of the attack
     * @return the calculated damage as an integer
     */
    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 2.0;
            case "electric" -> 1.5;
            case "fire" -> 1.2;
            case "grass" -> 2.5;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(temperature, maxTemperature) * attackWeight);
    }

    /**
     * Heals the FirePokemon based on the current temperature.
     * The FirePokemon heals more when the temperature is higher.
     *
     * @param healAmount the amount to heal
     */
    public void inferno(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.5);
        System.out.println(pokemon + " used Inferno on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setTemperature(temperature - 100);
        shouldHeal(30);
    }

    /**
     * Attacks the opponent Pokemon with the Fire Lash attack.
     * The attack deals 1.0 times the damage calculated by the damageCalculator method.
     * The temperature of the FirePokemon is reduced by 50.
     * If the FirePokemon's HP is less than 100, it heals 10 HP.
     *
     * @param name  the FirePokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void fireLash(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(name + " used Fire Lash on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setTemperature(temperature - 50);
        shouldHeal(10);
    }

    /**
     * Attacks the opponent Pokemon with the Flame Thrower attack.
     * The attack deals 0.5 times the damage calculated by the damageCalculator method.
     * The temperature of the FirePokemon is reduced by 25.
     * If the FirePokemon's HP is less than 100, it heals 5 HP.
     *
     * @param name  the FirePokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void flameThrower(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 0.5);
        System.out.println(name + " used Flame Thrower on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setTemperature(temperature - 25);
        shouldHeal(5);
    }

    /**
     * Attacks the opponent Pokemon with the Pyro Ball attack.
     * The attack deals 1.0 times the damage calculated by the damageCalculator method.
     * The temperature of the FirePokemon is reduced by 50.
     * If the FirePokemon's HP is less than 100, it heals 15 HP.
     *
     * @param name  the FirePokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void pyroBall(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(name + " used Pyro Ball on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setTemperature(temperature - 50);
        shouldHeal(15);
    }
}
