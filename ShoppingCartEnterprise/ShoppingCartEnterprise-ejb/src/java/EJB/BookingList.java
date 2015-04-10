/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;

/**
 *
 * @author SamranMalik
 */
@Stateful
public class BookingList implements BookingListRemote, BookingListLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @javax.persistence.PersistenceContext(unitName="ShoppingCartEnterprise-ejbPU")
    private EntityManager em;
    private Client client;
    private Booking booking;
    private List<Booking> bookings;
    
    public List getBookings(Object c)
   {
       Client cli = (Client) c;
      bookings = em.createQuery("select b from Booking b where b.clientid = :clientid order by b.checkindate")
            .setParameter("clientid", cli.getClientid())
            .getResultList();
      return bookings;
   }
    
    public Object getBooking()
   {
      return booking;
   }
    
    public void cancel()
   {
      Booking cancelled = em.find(Booking.class, booking.getBookingid());
      if (cancelled!=null) em.remove( cancelled );
   }
    
   @Remove
   public void destroy() {}  
}
