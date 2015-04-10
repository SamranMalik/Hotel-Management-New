/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import javax.ejb.Remote;

/**
 *
 * @author SamranMalik
 */
@Remote
public interface AuthenticatorSessionRemote {
    public boolean authenticate(String user, String Password);
     public boolean isUsernameAvailable(String user);
     public Object userDetail();
}
