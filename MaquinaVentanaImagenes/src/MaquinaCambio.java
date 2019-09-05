
import java.util.ArrayList;

public class MaquinaCambio {

    private ArrayList<Moneda> Monedas;

    public MaquinaCambio(ArrayList<Moneda> Monedas) {
        this.Monedas = Monedas;
    }

    public ArrayList<Moneda> getMonedas() {
        return Monedas;
    }

    public void setMonedas(ArrayList<Moneda> Monedas) {
        this.Monedas = Monedas;
    }
    
    public Moneda ObtenerCambios(ArrayList<Moneda> listamonedas){
        Moneda mon=null;
        int acumulador=0;
        int p=-1;
        for(Moneda m: listamonedas){
            acumulador+=m.getValor();
        }
        for(Moneda m: Monedas){
            if(m.getValor()==acumulador&&m.getNumeroMoneda()>0){
                m.DiminuiNumMonedas(1);
                mon= new Moneda (m.getValor(),1);
                p = Monedas.indexOf(m);
                break;
            }
        }
        for(Moneda m: listamonedas){
            for(int i = p+1; i< Monedas.size(); i++){
                if(m.getValor()==Monedas.get(i).getValor()){
                    Monedas.get(i).AñadirNumMonedas(m.getNumeroMoneda());
                    p=Monedas.indexOf(Monedas.get(i));
                    break;
                }
            }
        }
        return mon;
    }
    
    public ArrayList<Moneda> ObtenerCambio(Moneda m) {
        ArrayList<Moneda> cambio = new ArrayList<Moneda>();
        int p = -1;
        int vm = m.getValor();
        for (Moneda mon : Monedas) {
            if (m.getValor() == mon.getValor()) {
                p = Monedas.indexOf(mon);
                break;
            }
        }
        if (p >= -1) {
            for (int i = p + 1; 1 < Monedas.size(); i++) {
                Moneda mc = Monedas.get(i);
                int nm = vm / mc.getValor();
                if (nm > mc.getNumeroMoneda()) {
                    nm = mc.getNumeroMoneda();
                }
               
                Moneda mcambio = new Moneda(mc.getValor(), nm);
                cambio.add(mcambio); 
                vm = vm - (nm * mc.getValor());
                if (vm==0)break;
            }
            if (vm != 0) {
                return null;
            } else {
                Monedas.get(p).setNumeroMoneda(Monedas.get(p).getNumeroMoneda() + 1);
                for (Moneda moneda : cambio) {
                    for (int i = p + 1; i < Monedas.size(); i++) {
                        if (moneda.getValor() == Monedas.get(i).getValor()) {
                            Monedas.get(i).setNumeroMoneda(Monedas.get(i).getNumeroMoneda() - moneda.getNumeroMoneda());
                            break;
                        }
                    }
                }
            return cambio;
            }
        }
    return null;
    }
    
    public int ObtenerSaldoMaquina(){
        int saldo=0;
        for(Moneda m:Monedas){
            saldo=saldo+m.ObtenerCuantia();
        }
        return saldo;
    }
    
    @Override
    public String toString() {
        return "Moneda{" + "Obtener Saldo=" + ObtenerSaldoMaquina() + '}';
    }
}
    
    class Moneda{
    
    int valor;
    int numeroMonedas;

    public Moneda(int valor, int numeroMonedas) {
        this.valor = valor;
        this.numeroMonedas = numeroMonedas;
    }

    public int getValor() {
        return valor;
    }

    public int getNumeroMoneda() {
        return numeroMonedas;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setNumeroMoneda(int numeroMonedas) {
        this.numeroMonedas = numeroMonedas;
    }
    
    public int ObtenerCuantia(){
        int total;
        total=valor*numeroMonedas;
        return total;
    }
    
    public void AñadirNumMonedas(int numeroMonedas){
        this.numeroMonedas+=numeroMonedas;
    }
    
    public void DiminuiNumMonedas(int numeroMonedas){
        this.numeroMonedas-=numeroMonedas;
    }

    @Override
    public String toString() {
        return "Valor=" + valor + ", Numeros de monedas=" + numeroMonedas + ", Cuantia=" + ObtenerCuantia();
    }
}
