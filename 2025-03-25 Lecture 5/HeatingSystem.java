/** A Complete heating system with multiple subcomponents */
public class HeatingSystem {
    public Furnace furnace;
    public WaterTank waterTank;
    public FuelTank fuelTank;

    public HeatingSystem(Furnace furnace, WaterTank waterTank, FuelTank fuelTank){
        this.furnace = furnace;
        this.waterTank = waterTank;
        this.fuelTank = fuelTank;
    }

    /**
     * Uses the current fuel and water to get to 60 degrees
     * @return the time to get to 60 degrees Celsius in seconds
     */
    public double secondsUntil60Degrees(){
        double fc = this.furnace.fuelConsumption; // kg/s
        double temp = this.waterTank.temperature; // C


        // with that helper mehtod, we have now removed the need for thses two fields
        double cap = this.waterTank.capacity; // L
        double percent = this.waterTank.percentFull; // percent

//        double fuel = this.fuelTank.amount; // kg
        double pot = this.fuelTank.kcalPotential; // C * L / kg

        double litres = this.waterTank.currentAmount(); // cap * (percent / 100.0);
        double raiseC = this.waterTank.deltaC(60); // temp > 60 ? 0 : 60 - temp;
        double kgToBurn = this.fuelTank.kgToBurn(raiseC, litres);
        double seconds = this.furnace.howLong(kgToBurn);  // (kg / (kg / s) = kg * (s / kg) = s
        return seconds;
    }

    /**
     * Run the heating system for some unit of seconds
     * @param seconds
     * Side effects:
     * - raises the temperature of the hot water tank
     * - consumes fuel
     */
    public void runFor(double seconds){
        //stub
    }
}
