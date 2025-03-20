import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
}
