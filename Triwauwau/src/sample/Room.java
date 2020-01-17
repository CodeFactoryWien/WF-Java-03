package sample;

public class Room {

    private int roomID;
    private String roomName;
    private int fk_categoryID;
    private int fk_hotelID;

    public Room(int roomID, String roomName, int fk_categoryID, int fk_hotelID) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.fk_categoryID = fk_categoryID;
        this.fk_hotelID = fk_hotelID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public int getFk_categoryID() {
        return fk_categoryID;
    }

    public void setFk_categoryID(int fk_categoryID) {
        this.fk_categoryID = fk_categoryID;
    }

    public int getFk_hotelID() {
        return fk_hotelID;
    }

    public void setFk_hotelID(int fk_hotelID) {
        this.fk_hotelID = fk_hotelID;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID=" + roomID +
                ", roomName='" + roomName + '\'' +
                ", fk_catagoryID=" + fk_categoryID +
                ", fk_hotelID=" + fk_hotelID +
                '}';
    }
}
