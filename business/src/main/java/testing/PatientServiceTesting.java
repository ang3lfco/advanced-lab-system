/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testing;

import connection.DBConnection;
import daos.PatientDAO;
import dtos.PatientDTO;
import entities.Patient;
import interfaces.IDBConnection;
import interfaces.IPatientDAO;
import interfaces.IPatientService;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import services.PatientService;

/**
 *
 * @author ang3lfco
 */
public class PatientServiceTesting {
    public static void main(String[] args) {
        IDBConnection conn = new DBConnection();
        IPatientDAO patientDAO = new PatientDAO(conn);
        IPatientService patientService = new PatientService(patientDAO);
        
        PatientDTO p1 = new PatientDTO("James", "Anderson", "M", LocalDate.of(1987, Month.JUNE, 13), "123 Maple St, Denver, CO", "7205550111", "james.anderson@example.com", new ArrayList<>());
        PatientDTO p2 = new PatientDTO("Maria", "Gonzalez", "F", LocalDate.of(1992, Month.MARCH, 5), "456 Pine Ave, Austin, TX", "5125550190", "maria.gonzalez@example.com", new ArrayList<>());
        PatientDTO p3 = new PatientDTO("David", "Brown", "M", LocalDate.of(1989, Month.DECEMBER, 30), "789 Oak Rd, Seattle, WA", "2065550187", "david.brown@example.com", new ArrayList<>());
        PatientDTO p4 = new PatientDTO("Emily", "Johnson", "F", LocalDate.of(2000, Month.JULY, 19), "321 Birch Blvd, Miami, FL", "3055550176", "emily.johnson@example.com", new ArrayList<>());
        PatientDTO p5 = new PatientDTO("Michael", "Lee", "M", LocalDate.of(1993, Month.NOVEMBER, 11), "852 Willow Ln, San Diego, CA", "8585550165", "michael.lee@example.com", new ArrayList<>());
        PatientDTO p6 = new PatientDTO("Sophia", "Martinez", "F", LocalDate.of(1996, Month.MAY, 9), "147 Cherry St, Phoenix, AZ", "6025550154", "sophia.martinez@example.com", new ArrayList<>());
        PatientDTO p7 = new PatientDTO("Christopher", "Wilson", "M", LocalDate.of(1984, Month.OCTOBER, 28), "963 Elm Dr, Chicago, IL", "3125550123", "chris.wilson@example.com", new ArrayList<>());
        PatientDTO p8 = new PatientDTO("Olivia", "Davis", "F", LocalDate.of(1998, Month.JANUARY, 2), "753 Aspen Ct, Atlanta, GA", "4045550147", "olivia.davis@example.com", new ArrayList<>());
        PatientDTO p9 = new PatientDTO("Daniel", "Taylor", "M", LocalDate.of(1991, Month.SEPTEMBER, 15), "258 Spruce Way, Portland, OR", "5035550199", "daniel.taylor@example.com", new ArrayList<>());
        PatientDTO p10 = new PatientDTO("Grace", "Clark", "F", LocalDate.of(1994, Month.FEBRUARY, 23), "678 Maplewood Ave, Boston, MA", "6175550181", "grace.clark@example.com", new ArrayList<>());
        PatientDTO p11 = new PatientDTO("Ethan", "Moore", "M", LocalDate.of(1990, Month.JULY, 6), "369 Hilltop Rd, San Francisco, CA", "4155550170", "ethan.moore@example.com", new ArrayList<>());
        PatientDTO p12 = new PatientDTO("Ava", "Hall", "F", LocalDate.of(1988, Month.MARCH, 12), "135 Lakeview Blvd, Orlando, FL", "4075550162", "ava.hall@example.com", new ArrayList<>());
        PatientDTO p13 = new PatientDTO("Benjamin", "Allen", "M", LocalDate.of(1997, Month.APRIL, 18), "904 Sunset St, Minneapolis, MN", "6125550184", "ben.allen@example.com", new ArrayList<>());
        PatientDTO p14 = new PatientDTO("Isabella", "Young", "F", LocalDate.of(1999, Month.DECEMBER, 1), "214 Meadow Ln, Salt Lake City, UT", "8015550197", "isabella.young@example.com", new ArrayList<>());
        PatientDTO p15 = new PatientDTO("Logan", "King", "M", LocalDate.of(1995, Month.MAY, 27), "447 Forest Rd, Columbus, OH", "6145550155", "logan.king@example.com", new ArrayList<>());
        PatientDTO p16 = new PatientDTO("Mia", "Wright", "F", LocalDate.of(1993, Month.SEPTEMBER, 8), "159 Brook St, Charlotte, NC", "9805550148", "mia.wright@example.com", new ArrayList<>());
        PatientDTO p17 = new PatientDTO("Henry", "Scott", "M", LocalDate.of(1986, Month.JUNE, 3), "888 Summit Ave, Kansas City, MO", "8165550173", "henry.scott@example.com", new ArrayList<>());
        PatientDTO p18 = new PatientDTO("Chloe", "Green", "F", LocalDate.of(2001, Month.AUGUST, 14), "432 Highland Blvd, Sacramento, CA", "9165550133", "chloe.green@example.com", new ArrayList<>());
        PatientDTO p19 = new PatientDTO("Matthew", "Baker", "M", LocalDate.of(1990, Month.NOVEMBER, 10), "275 River Rd, Raleigh, NC", "9195550192", "matthew.baker@example.com", new ArrayList<>());
        PatientDTO p20 = new PatientDTO("Ella", "Nelson", "F", LocalDate.of(1992, Month.JUNE, 20), "616 Garden St, Albuquerque, NM", "5055550159", "ella.nelson@example.com", new ArrayList<>());

        
        List<PatientDTO> patientsDTO = List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20);
        for(PatientDTO p : patientsDTO){
            patientService.registerPatient(p);
        }
        System.out.println("Done");
    }
}
