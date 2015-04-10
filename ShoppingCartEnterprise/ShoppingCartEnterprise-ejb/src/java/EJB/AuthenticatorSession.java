/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EJB;

import java.util.List;
//import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author SamranMalik
 */
@Stateless
public class AuthenticatorSession implements AuthenticatorSessionRemote, AuthenticatorSessionLocal {
    @javax.persistence.PersistenceContext(unitName="ShoppingCartEnterprise-ejbPU")
    private EntityManager em;
    private Client client;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method
    @Override
    public boolean authenticate(String user, String Password)
    {
        Query query = em.createNamedQuery("Client.Login", Client.class).setParameter("username", user).setParameter("password", Password);
        //query.setParameter("username", user);
        //query.setParameter("password", Password);
        
        List result = query.getResultList();

        if (result.isEmpty())
        {
            return false;
        }
        else
        {
            client = (Client) result.get(0);
            return true;
        }
    }
    @Override
    public boolean isUsernameAvailable(String user)
    {
        Query query = em.createNamedQuery("Client.findByUsername", Client.class).setParameter("username", user);
        List result = query.getResultList();

        if (result.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public Object userDetail()
    {
        return client;
    }
}