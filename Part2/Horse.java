
/**
 * Write a description of class Horse here.
 * 
 * @author Adam Dahimene
 * @version (a version number or a date)
 */
public class Horse
{
    //Fields of class Horse
    private String horseName;
    private char horseSymbol;
    private double horseConfidence;
    private int DistanceTravelled;
    private boolean fallen;
    //Constructor of class Horse
    /**
     * Constructor for objects of class Horse
     */
    public Horse(char horseSymbol, String horseName, double horseConfidence)
    {
        this.horseSymbol = horseSymbol;
        this.horseName = horseName;
        this.horseConfidence = horseConfidence;
        return;
    }
    
    
    
    //Other methods of class Horse
    public void fall()
    {
        this.fallen = true;
        return;
    }
    
    public double getConfidence()
    {
        return this.horseConfidence;
    }
    
    public int getDistanceTravelled()
    {
        return this.DistanceTravelled;
    }
    
    public String getName()
    {
        return this.horseName;
    }
    
    public char getSymbol()
    {
        return this.horseSymbol;
    }
    
    public void goBackToStart()
    {
        this.DistanceTravelled = 0;
        return;
    }
    
    public boolean hasFallen()
    {
        if(fallen) {
            return true;
        } else {
            return false;
        }
    }

    public void moveForward()
    {
        this.DistanceTravelled = this.DistanceTravelled + 1;
        return;
    }

    public void setConfidence(double newConfidence)
    {
        this.horseConfidence = newConfidence;
        return;
    }
    
    public void setSymbol(char newSymbol)
    {
        this.horseSymbol = newSymbol;
        return;
    }
    
}
