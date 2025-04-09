/**
 * a wheel class
 * @author graham simons
 */
public class Wheel {
    double radius;
    double rps;

    /**
     * a wheel object for use in a rover
     * @param radius of the wheel in meters
     * @param rps the speed (in meters/second) of a wheel is its rps times its circumference
     */
    public Wheel(double radius, double rps) {
        this.radius = radius;
        this.rps = rps;
    }

    /**
     * @return the power draw (milliAmperes) of a wheel, the product of its rps and radius with a conversion factor of 1 milliAmpere-second / meter-rotation
     */
    public double totalCurrentDraw() {
        return this.rps * this.radius;
    }

    /**
     * @return the speed for the wheel
     */
    public double speed(){
        return this.rps * (2*3.14*this.radius);
    }

    /**
     * @return the speed of the wheel
     */
    @Override
    public String toString(){
        return String.format("%.2f", this.speed());
    }

    /**
     * @param o object to compare
     * @return checks all attributes to ensure equality
     */
    @Override
    public boolean equals(Object o){
        if (o instanceof Wheel wheel) {
            return Math.abs(wheel.radius - this.radius) < 0.01 && Math.abs(wheel.rps - this.rps) < 0.01;
        }
        return false;
    }
}
