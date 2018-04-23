
public class cebra extends herbivoro{
  private String a="hierba tosca";

  public cebra(){
    super.setcomidaFav(a);
  }
  @Override
  public void comerAnimal(){
    System.out.println("no como animales");
  }

  @Override
  public void jugar(){
    System.out.println("anda jugando a correr");
  }

  public String Hola(){
    return super.getcomidaFav();
  }
}