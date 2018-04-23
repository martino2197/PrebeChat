
public class jirafa extends herbivoro{
	private String a="hojas de pinole";

	public jirafa(){
		super.setcomidaFav(a);
	}
	@Override
	public void comerAnimal(){
		System.out.println("...no como animales");
	}

	@Override
	public void jugar(){
		System.out.println("Anda jugando cuellazos");
	}

	public String Hola(){
		return super.getcomidaFav();
	}  
}