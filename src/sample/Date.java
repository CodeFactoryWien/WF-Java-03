package sample;

public class Date {
    private int dateID;
    private Date startDate;
    private Date endDate;
    public Date(int dateID, Date startDate, Date endDate){
        this.dateID = dateID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
