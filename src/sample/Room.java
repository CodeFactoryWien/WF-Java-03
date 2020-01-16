package sample;

public class Room {

    private int roomID;
    private String roomName;
    private String roomCapacity;
    private String roomSize;
    private int fk_catagoryID;
    private int fk_hotelID;

    public Room(int roomID, String roomName, String roomCapacity, String roomSize, int fk_catagoryID, int fk_hotelID) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.roomCapacity = roomCapacity;
        this.roomSize = roomSize;
        this.fk_catagoryID = fk_catagoryID;
        this.fk_hotelID = fk_hotelID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }
}
