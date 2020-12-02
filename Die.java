public class Die {
    private int sides = 0, roll = 0;

    Die(int s) {
        this.sides = s;
    }

    int RollDie() {
        double intermediate = 1 + (Math.random() * sides);
        roll = (int) intermediate;
        return roll;
    }

    int GetRoll () {
        return roll;
    }

    int GetSides() {
        return sides;
    }
}
