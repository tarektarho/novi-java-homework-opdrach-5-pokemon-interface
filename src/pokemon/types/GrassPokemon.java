package pokemon.types;

import pokemon.Pokemon;

public class GrassPokemon extends Pokemon {
    private static final int maxChlorofylLevel = 1000;
    private int chlorofylLevel = 600;
    /**
     * Constructs a Grass Pokemon with the given name, level, HP, food, and sound.
     *
     * @param name  the name of the Pokemon
     * @param level the level of the Pokemon
     * @param hp    the HP of the Pokemon
     * @param food  the food the Pokemon likes
     * @param sound the sound the Pokemon makes
     */
    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound);
        setType("Grass");
        setFood("Berries");
        setSound("Rustle");
        addAttack("LeafStorm");
        addAttack("SolarBeam");
        addAttack("LeechSeed");
        addAttack("LeaveBlade");
    }

    public int getChlorofylLevel() {
        return chlorofylLevel;
    }

    /**
     * Sets the chlorofyl level of the GrassPokemon.
     *
     * @param chlorofylLevel the chlorofyl level to set
     */
    public void setChlorofylLevel(int chlorofylLevel) {
        this.chlorofylLevel = Math.min(chlorofylLevel, maxChlorofylLevel);
    }

    @Override
    public void eats() {
        System.out.println(getName() + " eats " + getFood());
        setChlorofylLevel(getChlorofylLevel() + 100);
        setHp(getHp() + 30);
    }

    /**
     * Calculates the damage dealt to an opponent based on their type and the attack weight.
     * The damage is influenced by a type multiplier and the chlorofyl level of the GrassPokemon.
     *
     * @param opponent the opponent Pokemon
     * @param attackWeight the weight of the attack
     * @return the calculated damage as an integer
     */
    public int damageCalculator(Pokemon opponent, double attackWeight) {
        double multiplier = switch (opponent.getType()) {
            case "water" -> 1.5;
            case "electric" -> 2.5;
            case "fire" -> 2.0;
            case "grass" -> 1.2;
            default -> 1.0;
        };

        return (int) (multiplier * calculateDamage(chlorofylLevel, maxChlorofylLevel) * attackWeight);
    }

    /**
     * Attacks the opponent Pokemon with Leaf Storm.
     * The damage dealt is calculated based on the opponent's type and the attack weight.
     * The chlorofyl level of the GrassPokemon is reduced by 100.
     * If the GrassPokemon's HP is less than 100, it heals 30 HP.
     *
     * @param pokemon the GrassPokemon attacking
     * @param enemy the opponent Pokemon
     */
    public void leafStorm(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.5);
        System.out.println(pokemon + " used Leaf Storm on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setChlorofylLevel(chlorofylLevel - 100);
        // if the Pokemon's HP is less than 100, heal 30 HP
        shouldHeal(30);
    }

    /**
     * Attacks the opponent Pokemon with Solar Beam.
     * The damage dealt is calculated based on the opponent's type and the attack weight.
     * The chlorofyl level of the GrassPokemon is reduced by 50.
     * If the GrassPokemon's HP is less than 100, it heals 10 HP.
     *
     * @param pokemon the GrassPokemon attacking
     * @param enemy the opponent Pokemon
     */
    public void solarBeam(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(pokemon + " used Solar Beam on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setChlorofylLevel(chlorofylLevel - 50);
        shouldHeal(10);
    }

    /**
     * Attacks the opponent Pokemon with Leech Seed.
     * The damage dealt is calculated based on the opponent's type and the attack weight.
     * The chlorofyl level of the GrassPokemon is reduced by 25.
     * If the GrassPokemon's HP is less than 100, it heals 5 HP.
     *
     * @param pokemon the GrassPokemon attacking
     * @param enemy the opponent Pokemon
     */
    public void leechSeed(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 0.5);
        System.out.println(pokemon + " used Leech Seed on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setChlorofylLevel(chlorofylLevel - 25);
        shouldHeal(5);
    }

    /**
     * Attacks the opponent Pokemon with Leave Blade.
     * The damage dealt is calculated based on the opponent's type and the attack weight.
     * The chlorofyl level of the GrassPokemon is reduced by 50.
     * If the GrassPokemon's HP is less than 100, it heals 15 HP.
     *
     * @param pokemon the GrassPokemon attacking
     * @param enemy the opponent Pokemon
     */
    public void leaveBlade(Pokemon pokemon, Pokemon enemy) {
        int damage = damageCalculator(enemy, 1.0);
        System.out.println(pokemon + " used Leave Blade on " + enemy + " and dealt " + damage + " damage!");
        enemy.gotHit(damage);
        setChlorofylLevel(chlorofylLevel - 50);
        shouldHeal(15);
    }
}
