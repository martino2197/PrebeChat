public class ComplexException extends Exception {
    @Override
    public String getMessage() {
        return "\n\n******Lo siento, el polinomio tiene raíz compleja*****\n\n";
    }
}
