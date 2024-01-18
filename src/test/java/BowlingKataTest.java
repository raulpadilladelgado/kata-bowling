import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Bowling kata should")
public class BowlingKataTest {
    @Nested
    @DisplayName("calculate score")
    class CalculateScore {
        @Test
        @DisplayName("adding rolls when there are no spares or strikes")
        void add_rolls_no_spares_or_strikes() {
            BowlingKata bowlingKata = new BowlingKata(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

            int totalScore = bowlingKata.score();

            assertEquals(19, totalScore);
        }

        @Test
        @DisplayName("adding rolls when there is a strike but it's in the last frame")
        void add_rolls_strike_but_in_last_frame() {
            BowlingKata bowlingKata = new BowlingKata(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 10, 1, 1);

            int totalScore = bowlingKata.score();

            assertEquals(30, totalScore);
        }

        @Test
        @DisplayName("adding rolls when there is a spare but it's in the last frame")
        void add_rolls_spare_but_in_last_frame() {
            BowlingKata bowlingKata = new BowlingKata(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9, 1);

            int totalScore = bowlingKata.score();

            assertEquals(29, totalScore);
        }

        @Test
        @DisplayName("applying a bonus of maximum score plus the next roll when the frame is a spare")
        void bonus_for_spares() {
            BowlingKata bowlingKata = new BowlingKata(1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1);

            int totalScore = bowlingKata.score();

            assertEquals(110, totalScore);
        }

        @Test
        @DisplayName("applying a bonus of maximum score plus the next two rolls when the frame is a strike")
        void bonus_for_strikes() {
            BowlingKata bowlingKata = new BowlingKata(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

            int totalScore = bowlingKata.score();

            assertEquals(300, totalScore);
        }
    }
}
