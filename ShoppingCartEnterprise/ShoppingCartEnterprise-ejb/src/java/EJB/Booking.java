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
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingid", query = "SELECT b FROM Booking b WHERE b.bookingid = :bookingid"),
    @NamedQuery(name = "Booking.findByCheckindate", query = "SELECT b FROM Booking b WHERE b.checkindate = :checkindate"),
    @NamedQuery(name = "Booking.findByCheckoutdate", query = "SELECT b FROM Booking b WHERE b.checkoutdate = :checkoutdate"),
    @NamedQuery(name = "Booking.findByClientid", query = "SELECT b FROM Booking b WHERE b.clientid = :clientid"),
    @NamedQuery(name = "Booking.findByRoomid", query = "SELECT b FROM Booking b WHERE b.roomid = :roomid")})
public class Booking implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKINGID")
    private BigDecimal bookingid;
    @Size(max = 50)
    @Column(name = "CHECKINDATE")
    private String checkindate;
    @Size(max = 50)
    @Column(name = "CHECKOUTDATE")
    private String checkoutdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENTID")
    private BigInteger clientid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMID")
    private BigInteger roomid;

    public Booking() {
    }

    public Booking(BigDecimal bookingid) {
        this.bookingid = bookingid;
    }

    public Booking(BigDecimal bookingid, BigInteger clientid, BigInteger roomid) {
        this.bookingid = bookingid;
        this.clientid = clientid;
        this.roomid = roomid;
    }

    public BigDecimal getBookingid() {
        return bookingid;
    }

    public void setBookingid(BigDecimal bookingid) {
        this.bookingid = bookingid;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public BigInteger getClientid() {
        return clientid;
    }

    public void setClientid(BigInteger clientid) {
        this.clientid = clientid;
    }

    public BigInteger getRoomid() {
        return roomid;
    }

    public void setRoomid(BigInteger roomid) {
        this.roomid = roomid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingid != null ? bookingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingid == null && other.bookingid != null) || (this.bookingid != null && !this.bookingid.equals(other.bookingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Booking[ bookingid=" + bookingid + " ]";
    }
    
}
