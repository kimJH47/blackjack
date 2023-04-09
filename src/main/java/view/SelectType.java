package view;

public enum SelectType {
    HIT("y"),
    STAY("n");


    SelectType(String select) {
        this.select = select;
    }

    private final String select;

    public static SelectType of(String select) {
        if (select.equalsIgnoreCase("y")) {
            return HIT;
        }
        if (select.equalsIgnoreCase("n")) {
            return STAY;
        }
        throw new IllegalArgumentException("y 또는 n 을 입력해야합니다.");
    }

    public boolean isHitSelect() {
        return select.equals("y");
    }
}
