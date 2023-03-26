package domain.player;

public class Participant extends Player {
    private final String name;

    public Participant(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public boolean isDealer() {
        return false;
    }

}

