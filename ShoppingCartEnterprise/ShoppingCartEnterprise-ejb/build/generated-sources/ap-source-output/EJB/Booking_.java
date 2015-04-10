package EJB;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-10T08:53:38")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, BigInteger> clientid;
    public static volatile SingularAttribute<Booking, BigInteger> roomid;
    public static volatile SingularAttribute<Booking, String> checkoutdate;
    public static volatile SingularAttribute<Booking, String> checkindate;
    public static volatile SingularAttribute<Booking, BigDecimal> bookingid;

}