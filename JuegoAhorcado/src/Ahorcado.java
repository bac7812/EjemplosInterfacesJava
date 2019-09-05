
import java.util.Random;


public class Ahorcado {
    
    private int IntentosMax;
    private String [] Palabras={"Ronaldo", "Pepe", "Bale", "Pibe", "Informatica", "Aula", "Programa", "Ordenador", "Mesa", "Cuadro"};
    private int ContadorIntentos;
    private String PalabraOculta;
    private String PalabraAleatoria;
    
    public Ahorcado(){
        
    }
    
    public void setIntentosMax(int IntentosMax) {
        this.IntentosMax = IntentosMax;
    }

    public void setPalabras(String[] Palabras) {
        this.Palabras = Palabras;
    }

    public void setContadorIntentos(int ContadorIntentos) {
        this.ContadorIntentos = ContadorIntentos;
    }

    public void setPalabraOculta(String PalabraOculta) {
        this.PalabraOculta = PalabraOculta;
    }

    public void setPalabraAleatoria(String PalabraAleatoria) {
        this.PalabraAleatoria = PalabraAleatoria;
    }

    public int getIntentosMax() {
        return IntentosMax;
    }

    public String[] getPalabras() {
        return Palabras;
    }

    public int getContadorIntentos() {
        return ContadorIntentos;
    }

    public String getPalabraOculta() {
        return PalabraOculta;
    }

    public String getPalabraAleatoria() {
        return PalabraAleatoria;
    }
    
    public void ObtenerPalabraAleatoria(){
        Random r = new Random();
        int valor = r.nextInt(Palabras.length) + 1;
        this.PalabraAleatoria = Palabras[valor];
        
      //int valor = (int)(Math.random()*Palabras.length);
    }
    
    public void OcultarPalabraConSimbolo(){
        PalabraOculta = "";
        for (int i = 0; i < PalabraAleatoria.length(); i++) {
            PalabraOculta += "*";
        }
    }
    
    public boolean ComprobarPalabra (String Palabra){
        if (Palabra.equals(this.PalabraAleatoria)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void CambiarSimbolosPorLetrasAcertada(char letra){
        String Palabra = "";
        for (int i = 0; i < PalabraAleatoria.length(); i++) {
            if (PalabraAleatoria.charAt(i) == letra) {
                Palabra += letra;
            } else {
                Palabra += PalabraOculta.charAt(i);
//                if (PalabraOculta.charAt(i) != '*') {
//                    Palabra += PalabraOculta.charAt(i);
//                } else {
//                    Palabra += "*";
//                }
            }
            if(!PalabraOculta.trim().equals(Palabra.trim())){
                ContadorIntentos++;
            }
            PalabraOculta = Palabra;
        }
    }
    
    public int ObtenerIntentosResatantes(){
        return this.IntentosMax-this.ContadorIntentos;
    }
}
