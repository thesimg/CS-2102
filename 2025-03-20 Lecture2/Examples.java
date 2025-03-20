import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * @author graham simons
 */
public class Examples {

    @Test
    public void testTicketFasterWithoutSeniorDiscount(){
        TicketFaster ticketFaster = new TicketFaster();
        assertEquals(33.0,ticketFaster.priceForTickets(3,false), 0.01);
    }
    @Test
    public void testTicketFasterWithSeniorDiscount(){
        TicketFaster ticketFaster = new TicketFaster();
        assertEquals(16.5,ticketFaster.priceForTickets(3,true), 0.01);
    }

    @Test
    public void testMarqueeNoTicketsRemaining(){
        TicketFaster ticketFaster = new TicketFaster();
        assertEquals("Now Playing: Hatsune Miku !SOLD OUT!", ticketFaster.marquee("Hatsune Miku",0));
    }

    @Test
    public void testMarqueeTicketsRemaining(){
        TicketFaster ticketFaster = new TicketFaster();
        assertEquals("Now Playing: Dingus9000 only 68 tickets left", ticketFaster.marquee("Dingus9000",68));
    }

    @Test
    public void testTicketsLeft(){
        TicketFaster ticketFaster = new TicketFaster();
        assertEquals("only 68 tickets left", ticketFaster.ticketsLeft(68));
    }
}
