package uvsq.pglp_4_1;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
public void TestPersonnelBuilderConstruct()
    {
    	Personnel p2=new Personnel.Builder("amirouche","nassim",LocalDate.now()).build();
    	assertTrue(p2.GetNom()=="amirouche" && p2.GetPrenom()=="nassim");
    }
    @Test
    public void TestPersonnelBuilderConstructOptionnel()
    {
    	Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).AddTel(356).build();
    	System.out.println(p1.GetTel().toString());
    	assertTrue(p1.GetNom()=="amirouche" && p1.GetPrenom()=="amine" && p1.GetTel().get(0).equals(356)) ;
    }
    
   @Test
   public void TestSerialisePersonnel()
   {
	   Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).build();
	   p1.serialise("./serialisationTest.txt");
	   Personnel p2=Personnel.deserialise("./serialisationTest.txt");
	   System.out.println(" le nom de p2"+ p2.GetNom());
	   assertTrue(p2.GetNom().equals(p1.GetNom()) && p2.GetPrenom().equals(p1.GetPrenom()));
	   
   }
    
    
}
