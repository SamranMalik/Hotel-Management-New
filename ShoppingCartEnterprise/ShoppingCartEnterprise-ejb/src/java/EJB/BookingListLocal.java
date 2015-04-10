/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SamranMalik
 */
@Local
public interface BookingListLocal {
    public List getBookings(Object c);
   public Object getBooking();
   public void cancel();
   public void destroy();
}
