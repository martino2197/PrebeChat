public class herbivoro implements animal{
	
  private String comidaFav;
  
  //@override
  public void comerAnimal(){
    System.out.println("yo solo como hojas, ssrry");  
  }
  
  //@override
  public void jugar(){
    System.out.println("Estoy jugando con las hojitas");
  }
    
  public void setcomidaFav(String comidaFav){
    this.comidaFav=comidaFav;
  }
  
  public String getcomidaFav(){
    return this.comidaFav;
  }
  
  
}
