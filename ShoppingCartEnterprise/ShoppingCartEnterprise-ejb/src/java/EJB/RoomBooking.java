/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author SamranMalik
 */
@Stateful
public class RoomBooking implements RoomBookingRemote, RoomBookingLocal {

   // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.persistence.PersistenceContext(unitName="ShoppingCartEnterprise-ejbPU")
    private EntityManager em;
    private Client client;
    private Room room;
    private Booking booking;
    List<Booking> bookings;
    private boolean bookingValid;
    List<Room> rooms;
    List<Roomtype> roomtypes;
    @Override
   public void selectRoom(Object selectedRoom)
   {
      Room selected = (Room) selectedRoom;
      room = em.find(Room.class, selected.getRoomid());
   }
   public List rooms()
   {
       roomtypes = em.createNamedQuery("Roomtype.findAll").getResultList();
       return roomtypes;
   }
   
   public List roomByType(String roomtype)
   {
       roomtypes = em.createNamedQuery("Roomtype.findByName", Roomtype.class).setParameter("name", roomtype).getResultList();     
       return roomtypes;
   }
    @Override
   public void bookRoom(Object room1,Object client,String checkin, String checkout)
   {
       booking = new Booking();
       Roomtype r = (Roomtype) room1;
       Client c = (Client) client;
       //Calendar calendar = Calendar.getInstance();
       booking.setCheckindate(checkin);
        booking.setCheckoutdate(checkout);
        room = em.createNamedQuery("Room.findByRoomtypeid", Room.class).setParameter("roomtypeid", r.getRoomtypeid()).getSingleResult();
        booking.setRoomid(room.getRoomid().toBigInteger());
        booking.setClientid(c.getClientid().toBigInteger());
        em.persist(booking);
   }
   
  /* public void setBookingDetails()
   {
       Calendar calendar = Calendar.getInstance();
       calendar.add(Calendar.DAY_OF_MONTH, -1);
       if (booking.getCheckindate().before( calendar.getTime())){
           bookingValid=false;
       }
       else if ( !booking.getCheckindate().before( booking.getCheckoutdate() ) )
      {
          bookingValid=false;
      }
       else
       {
           bookingValid=true;
      }
   }*/
       
    @Override
       public boolean isBookingValid()
   {
      return bookingValid;
   }
       
       public void confirm()
   {
       em.persist(booking);
       bookings=null;
   }
       
   @Remove
   public void destroy() {}
   
}

