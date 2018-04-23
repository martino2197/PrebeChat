//Prebecario#06
public class polinomio{
    double a, b, c;

    //construc
    public polinomio(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public void calRaiz() throws ComplexException { 

        if ((b*b-4*(a)*(c))>0) { //para saber si saldrán complex o nel
            System.out.printf("\n---RAÍCES:\n\n\t x1 = %f\n\t x2 = %f\n\n\n", ((-b + Math.sqrt((b*b)-4*(a*c)))/(2*a)),((-b - Math.sqrt((b*b)-4*(a*c)))/(2*a))); //chicharronera
        }
        else if (b*b-4*(a)*(c)<0){
            throw new ComplexException();
        }
    }
}

