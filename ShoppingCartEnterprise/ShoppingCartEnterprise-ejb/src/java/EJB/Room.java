/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SamranMalik
 */
@Entity
@Table(name = "ROOM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomid", query = "SELECT r FROM Room r WHERE r.roomid = :roomid"),
    @NamedQuery(name = "Room.findByRoomtypeid", query = "SELECT r FROM Room r WHERE r.roomtypeid = :roomtypeid"),
    @NamedQuery(name = "Room.findByRoomnumber", query = "SELECT r FROM Room r WHERE r.roomnumber = :roomnumber"),
    @NamedQuery(name = "Room.findByFloor", query = "SELECT r FROM Room r WHERE r.floor = :floor"),
    @NamedQuery(name = "Room.findByIsreserved", query = "SELECT r FROM Room r WHERE r.isreserved = :isreserved")})
public class Room implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMID")
    private BigDecimal roomid;
    @Column(name = "ROOMTYPEID")
    private BigInteger roomtypeid;
    @Size(max = 50)
    @Column(name = "ROOMNUMBER")
    private String roomnumber;
    @Column(name = "FLOOR")
    private BigInteger floor;
    @Column(name = "ISRESERVED")
    private BigInteger isreserved;

    public Room() {
    }

    public Room(BigDecimal roomid) {
        this.roomid = roomid;
    }

    public BigDecimal getRoomid() {
        return roomid;
    }

    public void setRoomid(BigDecimal roomid) {
        this.roomid = roomid;
    }

    public BigInteger getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(BigInteger roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public BigInteger getFloor() {
        return floor;
    }

    public void setFloor(BigInteger floor) {
        this.floor = floor;
    }

    public BigInteger getIsreserved() {
        return isreserved;
    }

    public void setIsreserved(BigInteger isreserved) {
        this.isreserved = isreserved;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomid != null ? roomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomid == null && other.roomid != null) || (this.roomid != null && !this.roomid.equals(other.roomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Room[ roomid=" + roomid + " ]";
    }
    
}
