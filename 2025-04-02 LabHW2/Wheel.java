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

    // The power draw (milliAmperes) of a wheel is the product of its rps and radius and has a conversion factor of 1 milliAmpere-second / meter-rotation


}
