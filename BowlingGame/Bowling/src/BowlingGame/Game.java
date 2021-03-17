package BowlingGame;

public class Game {

    private int[] rolls;
    private int currentRoll;

    public Game() {
        rolls = new int[21];
    }

    public void roll(int pinsHit) {
        rolls[currentRoll] = pinsHit;
        currentRoll++;

        if (pinsHit == 10 && currentRoll < 19) {
            rolls[currentRoll] = 0;
            currentRoll++;
        }
    }

    public int score() {
        int score = 0;
        for (int frame = 0; frame < 10; frame++) {
            int firstRoll = rolls[frame*2];
            int secondRoll = rolls[(frame*2)+1];

            if (isStrike(frame-1)) {
                if (isStrike(frame)) {
                    score += 10 + rolls[(frame + 1) * 2];
                    if (frame == 9) {
                        score += 10;
                    }
                } else {
                    score += firstRoll + secondRoll;
                }
            } else if (isSpare(frame-1)) {
                score += firstRoll;
            }

            score += firstRoll + secondRoll;
        }

        return score;
    }

    private boolean isStrike(int frame) {
        return frame >= 0 && rolls[frame * 2] == 10;
    }

    private boolean isSpare(int frame) {
        return frame >= 0 && rolls[frame * 2] + rolls[(frame * 2) + 1] == 10;
    }
}
