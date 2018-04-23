public class tigre extends carnivoro{
	private String a="carne";

	public tigre(){
		super.setcomidaFav(a);
	}
	@Override
	public void comerAnimal(){
		System.out.println("...Ese tigre anda comiendo");
	}

	@Override
	public void jugar(){
		System.out.println("Anda jugando...");
	}

	public String Hola(){
		return super.getcomidaFav();
	}
}