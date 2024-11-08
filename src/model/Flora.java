package model;

public class Flora extends Species {

    private boolean hasFlowers;
    private boolean hasFruits;
    private double maxHeight;

    public Flora(String name, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeight) {
        super(name, scientificName);
        this.hasFlowers = hasFlowers;
        this.hasFruits = hasFruits;
        this.maxHeight = maxHeight;
    }

    public boolean isHasFlowers() {
        return hasFlowers;
    }

    public void setHasFlowers(boolean hasFlowers) {
        this.hasFlowers = hasFlowers;
    }

    public boolean isHasFruits() {
        return hasFruits;
    }

    public void setHasFruits(boolean hasFruits) {
        this.hasFruits = hasFruits;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    

    
}
