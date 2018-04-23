public class leon extends carnivoro{
	private String a="carne";

	public leon(){
		super.setcomidaFav(a);
	}
	@Override
	public void comerAnimal(){
		System.out.println("...Ese leon anda comiendo");
	}

	@Override
	public void jugar(){
		System.out.println("Anda jugando...");
	}

	public String Hola(){
		return super.getcomidaFav();
	}

}