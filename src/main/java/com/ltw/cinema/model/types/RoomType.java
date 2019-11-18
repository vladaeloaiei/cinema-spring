package com.ltw.cinema.model.types;

public enum RoomType {
    LARGE((short) 16, (short) 10),
    SMALL((short) 10, (short) 10);
    private Short numberOfRows;
    private Short numberOfColumns;

    RoomType(Short numberOfRows, Short numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public Short getNumberOfColumns() {
        return numberOfColumns;
    }

    public Short getNumberOfRows() {
        return numberOfRows;
    }
}
