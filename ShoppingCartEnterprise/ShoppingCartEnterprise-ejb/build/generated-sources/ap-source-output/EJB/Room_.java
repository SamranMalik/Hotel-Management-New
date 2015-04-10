package EJB;

import EJB.Booking;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-10T08:53:38")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, BigDecimal> roomid;
    public static volatile SingularAttribute<Room, String> picture;
    public static volatile CollectionAttribute<Room, Booking> bookingCollection;
    public static volatile SingularAttribute<Room, BigInteger> price;
    public static volatile SingularAttribute<Room, String> description;
    public static volatile SingularAttribute<Room, String> type;
    public static volatile SingularAttribute<Room, BigInteger> availability;

}