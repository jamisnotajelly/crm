package model;

public enum State {
    NEW,
    ACCEPTED,
    DECLINED,
    DRAFT,
    CLOSED;

    public static State fromValue(String value) {
        for (State state : State.values()) {
            if (value.equalsIgnoreCase(state.name())) {
                return state;
            }
        }
        return null;
    }

}




