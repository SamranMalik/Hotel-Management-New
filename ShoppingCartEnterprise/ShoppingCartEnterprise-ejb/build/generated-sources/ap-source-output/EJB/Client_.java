package EJB;

import EJB.Booking;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-10T08:53:38")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, BigDecimal> clientid;
    public static volatile CollectionAttribute<Client, Booking> bookingCollection;
    public static volatile SingularAttribute<Client, String> username;
    public static volatile SingularAttribute<Client, String> lastname;
    public static volatile SingularAttribute<Client, String> firstname;
    public static volatile SingularAttribute<Client, String> password;

}