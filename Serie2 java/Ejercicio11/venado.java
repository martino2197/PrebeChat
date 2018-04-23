
public class venado extends herbivoro{
  private String a="hierba";

  public venado(){
    super.setcomidaFav(a);
  }
  @Override
  public void comerAnimal(){
    System.out.println("...no como animales");
  }

  @Override
  public void jugar(){
    System.out.println("ando jugando cuernazos");
  }

  public String Hola(){
    return super.getcomidaFav();
  }
}