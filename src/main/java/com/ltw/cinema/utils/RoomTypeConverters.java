package com.ltw.cinema.utils;

import com.ltw.cinema.model.types.RoomType;
import org.modelmapper.Converter;

public class RoomTypeConverters {
    public static Converter<RoomType, Short> roomTypeToNumberOfRowsConverter = mappingContext -> {
        if (mappingContext.getSource() != null) {
            return mappingContext.getSource().getNumberOfRows();
        }
        return null;
    };

    public static Converter<RoomType, Short> roomTypeToNumberOfColumnsConverter = mappingContext -> {
        if (mappingContext.getSource() != null) {
            return mappingContext.getSource().getNumberOfColumns();
        }
        return null;
    };

    public static Converter<RoomType, Short> roomTypeToTotalNumberOfChairsConverter = mappingContext -> {
        if (mappingContext.getSource() != null) {
            return (short) (mappingContext.getSource().getNumberOfRows()
                    * mappingContext.getSource().getNumberOfColumns());
        }
        return null;
    };
}
