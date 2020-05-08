package org.launchcode.techjobs_oo.Tests;

import jdk.jfr.StackTrace;
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

}
