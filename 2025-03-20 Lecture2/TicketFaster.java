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

}
