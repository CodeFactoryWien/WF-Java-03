package com.codefactory.team3.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "date")
public class Bookingdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dateid")
    private int id;

    @Column(name = "startdate")
    private Date start;
    @Column(name = "enddate")
    private Date end;
    @Column(name = "fk_roomid")
    private int fk_roomId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int getFk_roomId() {
        return fk_roomId;
    }

    public void setFk_roomId(int fk_roomId) {
        this.fk_roomId = fk_roomId;
    }
}
