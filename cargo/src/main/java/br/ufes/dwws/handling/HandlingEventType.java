package br.ufes.dwws.handling;

public enum HandlingEventType {

    LOAD(true),
    UNLOAD(true),
    RECEIVE(false),
    CLAIM(false),
    CUSTOMS(false);

    private final boolean voyageRequired;

    private HandlingEventType(boolean voyageRequired) {
        this.voyageRequired = voyageRequired;
    }

    public boolean isVoyageRequired() {
        return voyageRequired;
    }
}
