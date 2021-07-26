import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;

public class InvoiceServiceTest {
    @Test
    void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25,fare);
    }

    @Test
    void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5,fare);
    }

    @Test
    void whenMultipleRidesAreGiven_ShouldReturnTotalFareOfAllRides() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rideArray = { new Ride(5.0,10),
                            new Ride(0.1,1)};
        double fare = invoiceGenerator.calculateFare(rideArray);
        Assertions.assertEquals(65,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1) };
        InvoiceSummary summary = invoiceGenerator.calculateFareSummary(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceSummary() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Hashtable<Integer, Ride[]> hTable = new Hashtable<>();

        int userID1 = 1;
        Ride[] ride1 = { new Ride(2.0, 5),
                new Ride(0.1, 1) };
        hTable.put(userID1, ride1);

        int userID2 = 2;
        Ride[] ride2 = { new Ride(4.0, 10),
                new Ride(1, 1) };
        hTable.put(userID2, ride2);

        int userID = 2;

        if(hTable.containsKey(userID)) {
            InvoiceSummary summary = invoiceGenerator.calculateFareSummary(hTable.get(userID));
            InvoiceSummary expectdInvoiceSummary = new InvoiceSummary(2, 61);
            Assertions.assertEquals(expectdInvoiceSummary, summary);
        }
    }
}
