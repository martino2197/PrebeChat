
public class antilope extends herbivoro{
  private String a="tallos tiernos";

  public antilope(){
    super.setcomidaFav(a);
  }
  @Override
  public void comerAnimal(){
    System.out.println("no como aniamles");
  }

  @Override
  public void jugar(){
    System.out.println("ando jugando cuernazos");
  }

  public String Hola(){
    return super.getcomidaFav();
  }
}