/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SamranMalik
 */
@Remote
public interface RoomBookingRemote {
    public void selectRoom(Object selectedRoom);
    public void bookRoom(Object r,Object c,String checkin, String checkout);
    public List rooms();
    public List roomByType(String roomtype);
   //public void bookRoom(); 
   //public void setBookingDetails();
   public boolean isBookingValid(); 
   public void confirm();  
   public void destroy();
}
