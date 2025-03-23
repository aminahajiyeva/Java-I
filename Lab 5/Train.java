import java.util.ArrayList;
/**
 * Car models a car in a passenger train.
 *
 * @author Lynn Marshall, SCE
 * @version 1.1 September 23, 2012
 * 
 * @author Amina Hajiyeva 101303729
 */
public class Train
{
    /** The cars in this train. */
    private ArrayList<Car> cars;
   
    /** 
     * Constructs an empty train; i.e., one that has no cars.
     */
    public Train()
    {
        cars = new ArrayList<Car>(); // new empty train
    }
   
    /**
     * Adds the specified car to this train.
     * @param car is the car object that needs to be added to the train
     */
    public void addCar(Car car)
    {
        cars.add(car); // add a car
    }
    
    /**
     * Returns this trains's list of cars. This method is intended for 
     * testing purposes only, and should not be called by other objects,
     * as it may be removed from the final version of this class.
     * 
     * @return A list of the cars in the train
     */
    public ArrayList<Car> cars()
    {
        return cars;
    }    
      
    /**
     * Attempts to issue a ticket for a business class seat or an
     * economy class seat, as specified by the method's argument.
     * It will attempt to book a seat in the first car of the appropriate
     * type, but if a seat is not available it will attempt to book a seat
     * in the second car of the appropriate type, and so on. 
     * A request to issue a ticket in a business-class car will never result
     * in a seat being reserved in an economy-class car, and vice-versa. 
     * 
     * @param businessClassSeat The boolean determining whether the seat is buisness class or not
     * @return true if the ticket issuing was successful, false otherwise.
     */
    public boolean issueTicket(boolean businessClassSeat)
    {
        for(Car element:cars) // for each loop, iterate over each car
        {
            if(element.isBusinessClass() == businessClassSeat) // check if status's match 
            {
                if(element.bookNextSeat()) // try to book next seat
                {
                    return true;
                }
            }
        }
        return false;
    }
   
    /**
     * Cancels the ticket for the specified seat in the specified car.
     * 
     * @param carId The integer identifier of the car id
     * @param seatNo The integer identifier of the seat.
     * @return true if ticket cancellation is successful, false otherwise.
     */
    public boolean cancelTicket(int carId, int seatNo)
    {
        for(Car element:cars) // for each loop, iterate over each car
        {
            if(element.id() == carId && element.cancelSeat(seatNo)) // find ticket & cancel it
            {
                return true;
            }
        }
        return false;
    }
}
