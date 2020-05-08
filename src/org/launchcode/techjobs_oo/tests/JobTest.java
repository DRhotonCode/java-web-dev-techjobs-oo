package org.launchcode.techjobs_oo.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    private Job jobTest1, jobTest2, jobTest3, jobTest4;

    @Before
    public void testJobObjects(){
        jobTest1 = new Job();
        jobTest2 = new Job();
        jobTest3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobTest4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @After
    public void clearJobobjects(){
        Job.resetNextId();
    }

    @Test
    public void testSettingJobId() {
        assertEquals(1,jobTest2.getId() - jobTest1.getId(),0.001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(jobTest3 instanceof Job);
        assertEquals(3,jobTest3.getId());
        assertEquals(jobTest3.getName(),"Product tester");
        assertEquals(jobTest3.getEmployer().getValue(),"ACME");
        assertEquals(jobTest3.getLocation().getValue(),"Desert");
        assertEquals(jobTest3.getPositionType().getValue(),"Quality control");
        assertEquals(jobTest3.getCoreCompetency().getValue(),"Persistence");
    }

    @Test
    public void testJobsForEquality(){
        assertEquals(jobTest3.equals(jobTest4), false);
    }

    @Test
    public void testJobToString(){
            String output =  "\nID: " + jobTest3.getId() + "\n" +
                    "Name : " + jobTest3.getName() + "\n" +
                    "Employer: " + jobTest3.getEmployer().getValue() + "\n" +
                    "Location: " + jobTest3.getLocation().getValue() + "\n" +
                    "Position Type: " + jobTest3.getPositionType().getValue() + "\n" +
                    "Core Competency: " + jobTest3.getCoreCompetency().getValue() + "\n";
            assertEquals(output, jobTest3.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        char firstCharac = jobTest3.toString().charAt(0);
        char endCharac = jobTest3.toString().charAt(jobTest3.toString().length()-1);

        assertTrue(firstCharac == endCharac);
    }

    @Test
    public void testToStringHandlesEmptyString(){
        jobTest3.getEmployer().setValue("");
        jobTest3.getLocation().setValue("");
        String output = "\nID: " + jobTest3.getId() + "\n" +
                "Name : " + jobTest3.getName() + "\n" +
                "Employer: Data not available\n" +
                "Location: Data not available\n" +
                "Position Type: " + jobTest3.getPositionType().getValue() + "\n" +
                "Core Competency: " + jobTest3.getCoreCompetency().getValue() + "\n";
        assertEquals(output, jobTest3.toString());
    }
}
