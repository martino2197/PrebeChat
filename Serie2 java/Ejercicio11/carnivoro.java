public class carnivoro implements animal {

	private String comidaFav;

	public void comerAnimal(){
		System.out.println("...se comio a otro");
	}

	public void jugar(){
		System.out.println("Amda jugando...");
	}

	public void setcomidaFav(String comidaFav){
    	this.comidaFav=comidaFav;
 	 }
  
  	public String getcomidaFav(){
    	return comidaFav;
  	}
}
