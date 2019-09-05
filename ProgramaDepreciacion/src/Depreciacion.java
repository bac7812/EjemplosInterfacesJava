
public class Depreciacion {
    private int precio = 0;
    private int años = 0;
    private int depreciacion = 0;
    
    public Depreciacion() {
    }
    
    public Depreciacion(int precio, int años) {
        this.precio = precio;
        this.años = años;
        this.depreciacion = precio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }
    
    public int CalcularValorPerdido() {
        return precio/años;
    }
    
    public void ValorArticulo() {
        depreciacion -= CalcularValorPerdido();
        
    }
    
    public String Imprimir(int año) {
        return "Año"+año+": depreciacion del articulo -> "+CalcularValorPerdido()+"\t valor del articulo -> "+depreciacion+"\n";
    }
}
