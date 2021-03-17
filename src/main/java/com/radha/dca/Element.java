package com.radha.dca;

public class Element {
    int startPosition;
    int endPosition;

    public Element(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
    public int getDistance() {
        return this.endPosition - this.startPosition;
    }
    public Element setEndPosition(int endPosition) {
        this.endPosition = endPosition;
        return this;
    }

    @Override
    public String toString() {
        return "Element{" +
                "startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                '}';
    }
}
