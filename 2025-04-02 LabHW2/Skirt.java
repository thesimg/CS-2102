public class Skirt {
    double radius;
    double height;
    double propulsion;

    /**
     * an inflatable hovercraft skirt constructor
     * @param radius the radius of the circular hovercraft in meters
     * @param height the height of the skirt in meters
     * @param propulsion the percentage of the current that goes to propelling the hovercraft forward
     */
    public Skirt(double radius, double height, double propulsion) {
        this.radius = radius;
        this.height = height;
        this.propulsion = propulsion;
    }

    /**
     * @return the power draw (milliAmperes) of a skirt, the product of its total volume
     */
    public double totalCurrentDraw() {
        return this.radius * this.height;
    }

    /**
     * @return the speed based on the amount of the current going towards propulsion
     */
    public double speed(){
        return totalCurrentDraw() * this.propulsion;
    }

    /**
     * @return the redius, height, and propulsion of the skirt
     */
    @Override
    public String toString(){
        return this.radius + " " + this.height + " " + this.propulsion;
    }


    /**
     * @param o object to compare
     * @return checks all attributes to ensure equality
     */
    @Override
    public boolean equals(Object o){
        if (o instanceof Skirt skirt) {
            return Math.abs(this.radius - skirt.radius) < 0.02 && Math.abs(this.height - skirt.height) < 0.02 && Math.abs(this.propulsion - skirt.propulsion) < 0.02;
        }
        return false;
    }
}
