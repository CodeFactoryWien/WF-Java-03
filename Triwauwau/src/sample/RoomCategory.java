package sample;

public class RoomCategory {
    private int roomID;
    private String roomName;
    private String categoryName;
    private double categorySize;
    private double categoryPrice;

    public RoomCategory(int roomID, String roomName, String categoryName, double categorySize, double categoryPrice) {
        this.roomID = roomID;
        this.roomName = roomName;
        this.categoryName = categoryName;
        this.categorySize = categorySize;
        this.categoryPrice = categoryPrice;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getCategorySize() {
        return categorySize;
    }

    public void setCategorySize(double categorySize) {
        this.categorySize = categorySize;
    }

    public double getCategoryPrice() {
        return categoryPrice;
    }

    public void setCategoryPrice(double categoryPrice) {
        this.categoryPrice = categoryPrice;
    }

    @Override
    public String toString() {
        return "RoomCategory{" +
                "roomID=" + roomID +
                ", roomName='" + roomName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categorySize=" + categorySize +
                ", categoryPrice=" + categoryPrice +
                '}';
    }
}
