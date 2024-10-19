package pokemon.types;

import pokemon.Pokemon;

public class WaterPokemon extends Pokemon {
    private static final int maxHydrationLevel = 2500;
    private int hydrationLevel = 1300;

    /**
     * Constructs a WaterPokemon with the given name, level, HP, food, and sound.
     *
     * @param name  the name of the WaterPokemon
     * @param level the level of the WaterPokemon
     * @param hp    the HP of the WaterPokemon
     * @param food  the food the WaterPokemon likes
     * @param sound the sound the WaterPokemon makes
     */
    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        setType("Water");
        setFood("Fish");
        setSound("Splash");
        addAttack("Surf");
        addAttack("Rain Dance");
        addAttack("Hydro Pump");
        addAttack("Hydro Canon");
    }

    public int getHydrationLevel() {
        return hydrationLevel;
    }

    /**
     * Sets the hydration level of the WaterPokemon.
     * Ensures that the hydration level does not exceed the maximum allowed hydration level.
     *
     * @param hydrationLevel the new hydration level to set
     */
    public void setHydrationLevel(int hydrationLevel) {
        this.hydrationLevel = Math.min(hydrationLevel, maxHydrationLevel);
    }

    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood());
        setHydrationLevel(getHydrationLevel() + 100);
        setHp(getHp() + 30);
    }

    /**
     * Calculates the damage dealt to an opponent based on their type and the attack weight.
     * The damage is influenced by a type multiplier and the hydration level of the WaterPokemon.
     *
     * @param opponent the opponent Pokemon
     * @param attackWeight the weight of the attack
     * @return the calculated damage as an integer
     */
    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 1.2;
            case "electric" -> 2.0;
            case "fire" -> 2.5;
            case "grass" -> 1.5;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(hydrationLevel, maxHydrationLevel) * attackWeight);
    }


    /**
     * Attacks the opponent Pokemon with the Surf attack.
     * The attack deals 1.5 times the damage calculated by the damageCalculator method.
     * The hydration level of the WaterPokemon is reduced by 100.
     * If the WaterPokemon's HP is less than 100, it heals 30 HP.
     *
     * @param name  the WaterPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void surf(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.5);
        System.out.println(name + " used Surf on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setHydrationLevel(hydrationLevel - 100);
        // if the Pokemon's HP is less than 100, heal 30 HP
        shouldHeal(30);
    }

    /**
     * Attacks the opponent Pokemon with the Rain Dance attack.
     * The attack deals 1.0 times the damage calculated by the damageCalculator method.
     * The hydration level of the WaterPokemon is reduced by 50.
     * If the WaterPokemon's HP is less than 100, it heals 10 HP.
     *
     * @param name  the WaterPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void rainDance(Pokemon name, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(name + " used Rain Dance on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setHydrationLevel(hydrationLevel - 50);
        shouldHeal(10);
    }

    /**
     * Attacks the opponent Pokemon with the Hydro Pump attack.
     * The attack deals 1.2 times the damage calculated by the damageCalculator method.
     * The hydration level of the WaterPokemon is reduced by 50.
     * If the WaterPokemon's HP is less than 100, it heals 25 HP.
     *
     * @param name  the WaterPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void hydroPump(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.2);
        System.out.println(pokemon + " used Hydro Pump on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setHydrationLevel(hydrationLevel - 50);
        shouldHeal(25);
    }

    /**
     * Attacks the opponent Pokemon with the Hydro Canon attack.
     * The attack deals 1.0 times the damage calculated by the damageCalculator method.
     * The hydration level of the WaterPokemon is reduced by 50.
     * If the WaterPokemon's HP is less than 100, it heals 12 HP.
     *
     * @param name  the WaterPokemon that uses the attack
     * @param enemy the opponent Pokemon that receives the attack
     */
    public void hydroCanon(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(pokemon + " used Hydro Canon on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setHydrationLevel(hydrationLevel - 50);
        shouldHeal(12);
    }
}
