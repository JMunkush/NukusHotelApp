package io.munkush.app;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Room {
    private int id;
    private boolean isActive;
    private String price;

    public Room(int id, boolean isActive, String price) {
        this.id = id;
        this.isActive = isActive;
        this.price = price;
    }
}

