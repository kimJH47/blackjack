package util;

import domain.player.dto.PlayerStatusDto;

public class Score {

    public final static int BLACK_JACK = 21;
    private final static int MAX_ACE_SCORE = 11;
    private final static int MIN_ACE_SCORE = 1;

    private Score() {

    }

    public static int calc(int score, int aceCount) {
        int result = score + aceCount * MAX_ACE_SCORE;
        while (aceCount > 0) {
            if (result > BLACK_JACK) {
                result -= MAX_ACE_SCORE - MIN_ACE_SCORE;
            }
            aceCount--;
        }
        return result;
    }

    public static Result getResult(PlayerStatusDto dealer, PlayerStatusDto participant) {
        if (dealer.isBust() && participant.isBust()) {
            return Result.DEFAULT;
        }
        if (participant.isBlackJack() && !dealer.isBlackJack()) {
            return Result.WIN;
        }
        int dealerScore = dealer.getScore();
        int participantScore = participant.getScore();

        if (participantScore == dealerScore) {
            return Result.DEFAULT;
        }
        if (participantScore - dealerScore < 0) {
            return Result.LOSE;
        }
        return Result.WIN;

    }
}
