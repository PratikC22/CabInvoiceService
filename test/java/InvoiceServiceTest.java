import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
