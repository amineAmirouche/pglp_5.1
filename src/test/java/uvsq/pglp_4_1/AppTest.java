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
   
   @Test
   public void TestCompositePersonnelConstruct()
   {
	   
	   CompositePersonnels p1=new CompositePersonnels();
	   assertTrue(p1.GetList()!=null);
   }
   
   @Test
   public void TestCompositePersonnelAddPersonnel()
   {
	   
	   CompositePersonnels groupe1=new CompositePersonnels();
	   Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).build();
	   groupe1.add(p1);
	  assertTrue(groupe1.GetList().get(0).equals(p1));
	   
   }
   
   @Test
   public void TestCompositePersonnelAddCompositePersonnel()
   {
	   
	   CompositePersonnels groupe1=new CompositePersonnels();
	   CompositePersonnels groupe2=new CompositePersonnels();
	   Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).build();
	   Personnel p2=new Personnel.Builder("amirouche", "nass", LocalDate.now()).build();
	   Personnel p3=new Personnel.Builder("amirouche", "abcd", LocalDate.now()).build();
	   groupe1.add(p1);
	   groupe1.add(p2);
	   groupe2.add(p3);
	   groupe2.add(groupe1);
	  assertTrue(groupe2.GetList().size()==2);
	   
   }
   
   @Test
   public void TestCompositePersonnelSerialisation()
   {
	   Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).AddTel(356).build();
   	Personnel p2=new Personnel.Builder("amirouche","nassim",LocalDate.now()).build();
   	Personnel p3=new Personnel.Builder("test","nassim",LocalDate.now()).build();
	   
   	CompositePersonnels groupe1=new CompositePersonnels();
	CompositePersonnels groupe2=new CompositePersonnels();
	groupe1.add(p1);
	groupe1.add(p2);
	groupe2.add(p3);
	groupe2.add(groupe1);
	groupe2.serialise("./serialisationTestGroupe2.txt");
	CompositePersonnels groupeVerif=CompositePersonnels.deserialise("./serialisationGroupe2.txt");
	assertTrue(groupe2.GetList().size()==groupeVerif.GetList().size());
	   
   }
   
   @Test
   public void TestCompositePersonnelRemove()
   {
		CompositePersonnels groupe1=new CompositePersonnels();
		 Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).AddTel(356).build();
		 groupe1.add(p1);
		 groupe1.remove(p1);
		 assertTrue(groupe1.GetList().size()==0);
		   	
   }
   
    
}
