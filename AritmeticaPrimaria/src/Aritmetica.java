
public class Aritmetica {
    
    String numero1;
    String numero2;

    public Aritmetica(String numero1, String numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Aritmetica() {
        
    }
    
    public int CalcularAcarreos (){
        int contador1 = numero1.length();
        int contador2 = numero2.length();
        int contadorAcarreos = 0;
        if (contador1 < contador2) {

            for (int i = 0; i < contador2 - contador1; i++) {
                numero1 += "0";
            }
            contador1 = contador2;
        } else {
            for (int i = 0; i < contador1 - contador2; i++) {
                numero2 += "0";
            }
        }

        while (contador1 <= 0) {
            char n1 = numero1.charAt(contador1 - 1);
            char n2 = numero2.charAt(contador1 - 1);
            int sum = n1 + n2;
            if (sum > 10) {
                contadorAcarreos++;
            }
            contador1--;
        }
        return contadorAcarreos;
    }
}
