package formas;

public class Circulo implements Forma {

    protected double raio;

    public void Circulo(double raio){
        this.raio = raio;    
    }

    @Override
    public double area() {
        return  Math.PI * raio * raio;
    }

}
