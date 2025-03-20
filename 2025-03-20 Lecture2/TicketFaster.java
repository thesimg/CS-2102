public class TicketFaster {

    /**
     * produces the price for a movie that costs $11 per ticket.
     * @param numTickets the number of tickets
     * @param seniorDiscount movies are half-off for when accompanied by seniors
     * @return the total cost of the tickets
     */
    public double priceForTickets(int numTickets, boolean seniorDiscount) {
        if(seniorDiscount){
            return (numTickets * 11) / 2.0;
        }
        else{
            return (numTickets * 11);
        }
    }

    /**
     * Generates a marquee string
     * @param concert is the name of the performer
     * @param numTickets >= 0
     * @return a Now playing string, says if sold out: "Now Playing %s %s"
     */
    public String marquee(String concert, int numTickets){
//        return String.format("Now Playing: %s %s", concert, (numTickets > 0) ? numTickets + " tickets left" : "!SOLD OUT!");
        return String.format("Now Playing: %s %s", concert, ticketsLeft(numTickets));
    }

    /**
     * Generates a string describing how many tickets are left
     * @param numTickets is the number of tickets left
     * @return a string saying tickets left or sold out
     */
    protected String ticketsLeft(int numTickets) {
        return (numTickets > 0) ? String.format("only %d tickets left", numTickets) : "!SOLD OUT!";
    }

}
