import com.hotel.service.entity.Booking;
import com.hotel.service.repository.BookingRepository;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class BookingServiceTest {
    @Test
    void testRoomBooked(){
        BookingRepository repo = new BookingRepository();


        Booking booking = new Booking(
                "Rindra",
                "0340000000",
                "rindra@mail.com",
                3,
                "vue mer",
                LocalDate.of(2025,9,5)
        );

        repo.save(booking);

        boolean exists = repo.existsBookingByRoomNumberAndBookingDate(
                3,
                LocalDate.of(2025,9,5)
        );

        assertTrue(exists);


    }

}
