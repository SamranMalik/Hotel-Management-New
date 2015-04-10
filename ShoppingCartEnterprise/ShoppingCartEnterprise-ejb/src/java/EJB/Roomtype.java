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
@Table(name = "ROOMTYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r"),
    @NamedQuery(name = "Roomtype.findByRoomtypeid", query = "SELECT r FROM Roomtype r WHERE r.roomtypeid = :roomtypeid"),
    @NamedQuery(name = "Roomtype.findByName", query = "SELECT r FROM Roomtype r WHERE r.name = :name"),
    @NamedQuery(name = "Roomtype.findByDescription", query = "SELECT r FROM Roomtype r WHERE r.description = :description"),
    @NamedQuery(name = "Roomtype.findByPrice", query = "SELECT r FROM Roomtype r WHERE r.price = :price"),
    @NamedQuery(name = "Roomtype.findByPicture", query = "SELECT r FROM Roomtype r WHERE r.picture = :picture")})
public class Roomtype implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROOMTYPEID")
    private BigDecimal roomtypeid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private BigInteger price;
    @Size(max = 50)
    @Column(name = "PICTURE")
    private String picture;

    public Roomtype() {
    }

    public Roomtype(BigDecimal roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public BigDecimal getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(BigDecimal roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomtypeid != null ? roomtypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.roomtypeid == null && other.roomtypeid != null) || (this.roomtypeid != null && !this.roomtypeid.equals(other.roomtypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.Roomtype[ roomtypeid=" + roomtypeid + " ]";
    }
    
}
