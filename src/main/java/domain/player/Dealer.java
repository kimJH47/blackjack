package domain.player;

public class Dealer extends Player {
    public static final String NAME = "dealer";
    private static final int DEALER_MIN_SCORE = 17;
    public Dealer() {
        super(NAME);
    }

    public boolean isStay() {
        int dealerScore = super.calcScore();
        return dealerScore >= DEALER_MIN_SCORE;
    }

    @Override
    public boolean isDealer() {
        return true;
    }

}
