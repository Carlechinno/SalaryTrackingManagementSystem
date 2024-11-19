package HR;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Generator {

    private static final String[] FIRST_NAMES = {"Lauren","Klee","Raiden","Wriothesly","Furina","Nahida","Jean","Pikachu","Kirito","Rein","Asuna","Tania","Nina","Kanade","Harry","Lampy","Jinx","Varus","Evelynn","Cranky","Luffy","Goku","Nat"};
    private static final String[] LAST_NAMES = {"Kirigaya","Shroud","Yuuki","Ketchum","Queen","De Fontaine","Pendragon","Smith","Newton","Tankus","Wayne","Uciha","VI","Orlando","Forger","Briar","Sherwood","Satou","Dustiness","Lance","Monkey","Portages","Zubreg","Asada","Kazama","Mishima"};
    private static final String[] LOCATIONS = {"Inazuma","Sumeru","Aincrad","Natlan","Fontaine","Horizon","Underworld","NightCity","StarCity","The Lands Between","Sce","China","Mom's Basement","Under The Desk","Bed","Wonderland","Hell","Tesla Mega Factory","Amazon Storehouse"};
    private static final String[] EMAIL_DOMAINS = {"gmail.com","walla.com","hotmail","ac.sce.ac.il","protonmail.com"};
    private static final String[] GALAXY_CLUSTER = {"Andromeda" , "Milky Way" , "Triangulum" , "Sombrero" , "Whirlpool" , "Pinwheel" , "Centaurus A" , "Messier 87" , "Messier 82" , "Cartwheel" , "Circinus" , "Sculptor" , "NGC 1300" , "NGC 7331" , "IC 1101"};
    private static final String[] PHONE_NUMBER_PREFIXES = {"54", "50", "52", "08", "07", "02", "53"};

    private static final int MIN_SALARY = 3000;
    private static final int MAX_SALARY = 15000;

    private static final Random RANDOM = new Random();


    public static Worker[] generateWorkers(int amountOfWorkers) {
        Worker[] workers = new Worker[amountOfWorkers];
        Set<Integer> usedIDs = new HashSet<>(); //TODO maybe delete this
        Set<String> usedPhoneNumbers = new HashSet<>(); //TODO maybe delete this
        Set<String> usedEmailAddresses = new HashSet<>(); //TODO maybe delete this

        for (int i = 0; i < amountOfWorkers; i++) {
            String firstName = getRandomItem(FIRST_NAMES);
            String lastName = getRandomItem(LAST_NAMES);
            String email = GenerateUniqueEmail(firstName,lastName,getRandomItem(EMAIL_DOMAINS),usedEmailAddresses);
            String address = GenerateRandomAddress();
            String phoneNumber = GenerateRandomPhoneNumber(usedPhoneNumbers);
            int id = generateUniqueID(usedIDs);
            int salary = GenerateRandomSalary();
            workers[i] =new Worker(firstName,lastName,id,email,phoneNumber,address,salary);

            usedIDs.add(id);
            usedPhoneNumbers.add(phoneNumber);
            usedEmailAddresses.add(email);

        }
        return workers;

    }


    // Function to get a random item from the final lists //
    public static String getRandomItem(String[] list){
        return list[RANDOM.nextInt(list.length)];
    }


    public static int generateUniqueID(Set<Integer> usedIDs) {
        int id;
        do {
            id = RANDOM.nextInt(900000000) + 100000000; // Generate 9-digit ID
        } while (usedIDs.contains(id));
        return id;
    }

    public static String GenerateUniqueEmail(String firstName, String lastName, String domain,Set<String> usedEmailAddress) {

        String result_Email;
        int randomNumber;
        do {
            randomNumber = RANDOM.nextInt();
            result_Email = firstName + lastName + randomNumber + '@' + domain;

        } while (usedEmailAddress.contains(result_Email));

        return result_Email;
    }


    public static String GenerateRandomAddress(){
        String galaxyCluster = getRandomItem(GALAXY_CLUSTER) + ", ";
        String state = getRandomItem(LOCATIONS) + ", ";
        String street = getRandomItem(LOCATIONS) + " Boulevard, ";
        String number = Integer.toString(RANDOM.nextInt(99) + 1);

        return galaxyCluster + state + street + number  ;
    }

    public static String GenerateRandomPhoneNumber(Set<String> usedPhones){
        StringBuilder builder;
        String phoneNumber;
        do {
            builder = new StringBuilder("05");
            for (int i = 0; i < 8; i++) {
                builder.append(RANDOM.nextInt(10));
            }
            phoneNumber = builder.toString();
        } while (usedPhones.contains(phoneNumber));

        return phoneNumber;
    }

    public static int GenerateRandomSalary(){
        return RANDOM.nextInt(MAX_SALARY - MIN_SALARY + 1) + MIN_SALARY;
    }

}
