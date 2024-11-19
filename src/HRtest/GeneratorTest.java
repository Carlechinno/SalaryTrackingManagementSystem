package HRtest;

import HR.*;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class GeneratorTest {

    private final int amount = 10000;

    @Test
    public void testGeneratorIdUniqueness() {

        Set<Integer> usedIDs = new HashSet<>();
        Worker[] workers = Generator.generateWorkers(amount);

        for (Worker w : workers) {
            assertFalse(usedIDs.contains(w.getId()));

            usedIDs.add(w.getId());
        }
    }

    @Test
    public void testGeneratorSalaryCorrectness(){
        Worker[] workers = Generator.generateWorkers(amount);

        for (Worker w : workers) {
            assertTrue(w.getMonthlySalary() >= 3000);
            assertTrue(w.getMonthlySalary() <= 15000);
        }
    }


    @Test
    public void testGeneratorPhoneNumberUniqueness(){
        Set<String> usedPhoneNumbers = new HashSet<>();
        Worker[] workers = Generator.generateWorkers(amount);

        for (Worker w : workers) {
            assertFalse(usedPhoneNumbers.contains(w.getPhoneNumber()));
            usedPhoneNumbers.add(w.getPhoneNumber());
        }
    }

    @Test
    public void testGeneratorEmailUniqueness(){
        Set<String> usedEmails = new HashSet<>();
        Worker[] workers = Generator.generateWorkers(amount);

        for (Worker w : workers) {
            assertFalse(usedEmails.contains(w.getEmail()));
            usedEmails.add(w.getEmail());
        }


    }


}

