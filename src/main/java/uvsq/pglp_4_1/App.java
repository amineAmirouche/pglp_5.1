package uvsq.pglp_4_1;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int numeroTel=356;
    	/**
    	 * Builder
    	 */
        Personnel p1=new Personnel.Builder("amirouche", "amine", LocalDate.now()).AddTel(numeroTel).build();
    	Personnel p2=new Personnel.Builder("amirouche","nassim",LocalDate.now()).build();
    	Personnel p3=new Personnel.Builder("test","nassim",LocalDate.now()).build();
    	/**
    	 * Composite
    	 */
    	CompositePersonnels groupe1=new CompositePersonnels();
    	CompositePersonnels groupe2=new CompositePersonnels();
    	/**
    	 * ajout dans le composite 
    	 */
    	groupe1.add(p1);
    	groupe1.add(p2);
    	groupe2.add(p3);
    	groupe2.add(groupe1);
    	//groupe2.print();
    	
    	/**
    	 * serialisation du groupe2
    	 */
    	groupe2.serialise("./serialisationGroupe2.txt");
    	/**
    	 * sérialisation du personnel p1
    	 */
    	p1.serialise("./serialisationPersonnel1.txt");
    	
    	/**
    	 * desérialisation du groupe et du personnel
    	 */
    	//Personnel.deserialise("./serialisationPersonnel1.txt").print();
    	CompositePersonnels.deserialise("./serialisationGroupe2.txt").print();
    }
}
