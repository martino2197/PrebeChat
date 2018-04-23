public class puma extends carnivoro{
	private String a="carne";

	public puma(){
		super.setcomidaFav(a);
	}
	@Override
	public void comerAnimal(){
		System.out.println("...Ese puma anda comiendo");
	}

	@Override
	public void jugar(){
		System.out.println("Anda jugando...");
	}

	public String Hola(){
		return super.getcomidaFav();
	}
}