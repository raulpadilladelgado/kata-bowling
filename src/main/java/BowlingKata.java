import java.util.Arrays;
import java.util.List;

public class BowlingKata {

    public static final int MAX_SCORE_PER_FRAME = 10;
    private final List<Integer> rolls;

    public BowlingKata(Integer... rolls) {
        this.rolls = Arrays.asList(rolls);
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        while (rollIndex < rolls.size()) {
            if (isLastFrame(rollIndex)) {
                score += sumRollsFrom(rollIndex, 3);
                break;
            }
            if (isStrike(rollIndex)) {
                score += MAX_SCORE_PER_FRAME + sumRollsFrom(rollIndex + 1, 2);
                rollIndex++;
                continue;
            }
            if (isSpare(rollIndex)) {
                score += MAX_SCORE_PER_FRAME + sumRollsFrom(rollIndex + 2, 1);
                rollIndex += 2;
                continue;
            }
            score += sumRollsFrom(rollIndex, 2);
            rollIndex += 2;
        }
        return score;
    }

    private boolean isLastFrame(int rollIndex) {
        return rollIndex == rolls.size() - 3;
    }

    private int sumRollsFrom(int rollIndex, int rollsToSum) {
        return rolls.subList(rollIndex, rolls.size()).stream().limit(rollsToSum).mapToInt(Integer::intValue).sum();
    }

    private boolean isStrike(int rollIndex) {
        return rolls.get(rollIndex) == MAX_SCORE_PER_FRAME;
    }

    private boolean isSpare(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1) == MAX_SCORE_PER_FRAME;
    }
}