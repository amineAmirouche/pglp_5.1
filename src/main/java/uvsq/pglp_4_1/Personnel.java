package uvsq.pglp_4_1;

import java.util.ArrayList;

public final class Personnel implements GroupePersonnels {
	
	private  String Nom;
	private  String Prenom;
	private  String Post;
	private  java.time.LocalDate Date;
	private  ArrayList<Integer> Tel;
	
	Personnel(Builder build)
	{
		Nom=build.Nom;
		Prenom=build.Prenom;
		Post=build.Post;
		Date=build.Date;
		Tel=build.Tel;
	}
	
	public ArrayList<Integer> GetTel()
	{
		return this.Tel;
	}
	public static class Builder {
		
		private final String Nom;
		private final String Prenom;
		private final java.time.LocalDate Date;
		
		private  String Post="inconnue";		
		private  ArrayList<Integer> Tel=new ArrayList<Integer>();
		
		
		public Builder(String Nom,String Prenom,java.time.LocalDate Date)
		{
			this.Date=Date;
			this.Nom=Nom;
			this.Prenom=Prenom;
		}
		
		public Builder AddTel(int numero)
		{
			this.Tel.add(numero);
			return this;
		}
		
		
		public Personnel build()
		{
			return new Personnel(this);
		}
	}
	public void print() {
		System.out.println("Nom du personnel" + Nom + Prenom );
		
	}
	

}
