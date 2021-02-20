import java.util.Scanner;

class Comida{
    int caloria;
    String alimento;
    boolean estragada;

    Comida(int caloria, String alimento, boolean estragada) {
        this.caloria = caloria;
        this.alimento = alimento;
        this.estragada = estragada;
    }

    void vomitar() {
        this.caloria = 0;
    }

    public String toString() {
        return caloria + "Kg " + " Comendo: " + alimento + " Estragada: " + estragada;
    }
}

class Pessoa {
    int peso;
    boolean fome;
    Comida pesoGanho;

    Pessoa(int peso, boolean fome, Comida pesoGanho) {
        this.peso = peso;
        this.fome = fome;
        this.pesoGanho = pesoGanho;
    }

    void comer(Comida comida) {
        if (this.fome == true) {
            if (comida.estragada == true)
                System.out.println("Eca! Não vou comer isso >:(");
            else {
                pesoGanho = comida;
                this.fome = false;
                System.out.println("Huuuum que delícia!");
            }
        }
        else
            System.out.println("Não estou com fome :)");
    }

    

    void malhar(int horas){
        if(this.peso <= 40)
            throw new RuntimeException("Você está magro demais, por favor se alimente");
        if(this.fome = true)
            throw new RuntimeException("Malhar sem comer é perigoso irmão, vai fazer um pré-treino");
        pesoGanho.caloria -= (2*horas);
        this.fome = true;
    }

    void dormir(int dia){
        if(dia > 2)
            throw new RuntimeException("Tu vai dormir esse tempo todo? Seu preguiçoso, toma vergonha");

        if(dia < 0)
            throw new RuntimeException("Me responda, DIA NEGATIVO???? Cê é idiota?");

        pesoGanho.caloria += (1*dia);
        this.fome = true;
    }

    public String toString() {
        String saida = "Peso inicial: " + peso + " Fome: " + fome + " Engordei: " + pesoGanho; 
        return saida;       
    }

}
public class Interativo {
    public static void main(String[] args) {
        Pessoa ruan = new Pessoa(50, true, null);
        Comida arroz = new Comida(2, "arroz", false);
        Comida feijao = new Comida(30, "feijão", true);
        Comida carne = new Comida(50, "Carne", false);

        Scanner scanner = new Scanner(System.in);
        while(true){
            try{
                String line = scanner.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("end")){
                    break;

                }else if(ui[0].equals("comer")){
                    if(ui[1].equals("arroz"))
                        ruan.comer(arroz);
                    else if(ui[1].equals("feijao"))
                        ruan.comer(feijao);
                    else if(ui[1].equals("carne"))
                        ruan.comer(carne);
                    else
                        System.out.println("Fail: Você esqueceu de dizer o que é pra comer homi");
                    

                }else if(ui[0].equals("malhar")){
                    ruan.malhar(Integer.parseInt(ui[1]));

                }else if(ui[0].equals("dormir")){
                    ruan.dormir(Integer.parseInt(ui[1]));

                }else if(ui[0].equals("mostrar")){
                    System.out.println(ruan);

                }else{
                    System.out.println("fail: comando invalido");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("fail: ce ta esquecendo de digitar alguma coisa rapaz");

            }catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }    
}
