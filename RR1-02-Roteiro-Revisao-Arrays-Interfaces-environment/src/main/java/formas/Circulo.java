package formas;

public class Circulo implements Forma{

    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }    

    public double area(){
        return Math.PI * raio * raio;
    }
}

    