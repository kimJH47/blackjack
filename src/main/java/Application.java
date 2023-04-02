import domain.card.ShuffleDeck;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new BlackjackGame(ShuffleDeck.create()), new InputView(),
                new OutputView());
        controller.run();
    }
}
