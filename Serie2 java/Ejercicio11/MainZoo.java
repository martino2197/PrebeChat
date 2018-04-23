public class MainZoo{
	public static void main(String[] args){
		zoo z = new zoo();
		z.AgregarAnimal(new jirafa());
		z.AgregarAnimal(new leon());
		z.AgregarAnimal(new cebra());
		z.AgregarAnimal(new puma());
		z.AgregarAnimal(new antilope());
		z.AgregarAnimal(new tigre());

		for (int i=0; i < z.numero; i++){
			animal a = z.animales[i];
			a.comerAnimal();
			a.jugar();

		if(a instanceof jirafa){
			jirafa j = (jirafa) a;
			System.out.println(j.Hola());
		}

		if(a instanceof leon){
			leon l = (leon) a;
			System.out.println(l.Hola());
		}

		if(a instanceof cebra){
			cebra c = (cebra) a;
			System.out.println(c.Hola());
		}

		if(a instanceof puma){
			puma p = (puma) a;
			System.out.println(p.Hola());
		}

		if(a instanceof antilope){
			antilope ant = (antilope) a;
			System.out.println(ant.Hola());
		}

		if(a instanceof tigre){
			tigre t = (tigre) a;
			System.out.println(t.Hola());
		}

			//animal obj = new leon(); //upcasting

			//leon obt = (leon) new animal(); downcasting
	}
}
} //darle formato a la impresion!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!