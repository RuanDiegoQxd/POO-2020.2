/*import java.util.Scanner;


class Inseto {
    int tamanho;
    int energia;
    Inseto(int tamanho, int energia){
        this.tamanho = tamanho;
        this.energia = energia;
    }
    public String toString() {
        return "T:" + tamanho + " E:" + energia;        
    }
}

class Calango {
    Inseto barriga;
    int energia; //atributos
    int maxEnergia;
    int nPatas;
    int vida;
    boolean alive;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxEnergia){ //parametros
        this.energia = maxEnergia;
        this.maxEnergia = maxEnergia;
        this.nPatas = 4;
        this.vida = 4;
        this.alive = true;
        this.barriga = null; //nada
    }

    boolean comer(Inseto mosquito){
        if(this.barriga != null){
            System.out.println("Barriga esta cheia");
            return false;
        }
        if(mosquito.tamanho > 3){
            System.out.println("Inseto muito grande");
            return false;
        }
        barriga = mosquito;
        return true;
    }

    Inseto vomitar(){
        if(barriga == null){
            System.out.println("Barriga vazia, nao tem o que por pra fora");
            return null;
        }
        Inseto aux = barriga;
        barriga = null;
        return aux;
    }

    void digerir(){
        if(barriga == null){
            System.out.println("nao tem o que digerir");
            return;
        }
        this.energia += barriga.energia;
        if(energia > maxEnergia){
            energia = maxEnergia;
            System.out.println("Nhame Nhame, estou cheio ate a tampa");
        }else{
            System.out.println("Nhame Nhame");
        }
        barriga = null;
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(energia > 0){
            if(energia < dist){
                System.out.println("Andei só " + energia);
                energia = 0;
                return;
            }
            energia -= dist;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void brigar(Calango other){
        if(!this.alive){
            System.out.println("Morto nao luta");
            return;
        }
        if(other.nPatas > 0){
            other.nPatas -= 1;
            System.out.println("Arranquei uma pata sua com meu Ninjutso");
        }else{
            System.out.println("Morra com meu golpe do dedo das 4 folhas!!");
            other.alive = false;
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (energia > 0){
            nPatas += 1;
            energia -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        String saida =  "energia: " + energia + "/" + maxEnergia + " Patas: " + nPatas  + " Alive:" + alive;
        saida += " Barriga: " + barriga;
        return saida;
    }
}


public class Interativo {
    public static void main(String[] args) {
        Calango dead = new Calango(100);
        dead.andar(50);
        System.out.println(dead);
        Inseto muri = new Inseto(1, 1);
        dead.comer(muri);
        System.out.println(dead);
        dead.digerir();
        System.out.println(dead);
        Inseto barataVoadora = new Inseto(5, 20);
        dead.comer(barataVoadora);
        Inseto meiaBarataVoadora = new Inseto(2, 20);
        dead.comer(meiaBarataVoadora);
        System.out.println(dead);
        Inseto fugiu = dead.vomitar();
        System.out.println(fugiu);
        dead.comer(fugiu);
        dead.digerir();
        System.out.println(dead);
    }
}*/

//import java.util.Scanner;

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

    

    void malhar(){
        pesoGanho.caloria -= 2;
        this.fome = true;
    }

    void dormir(){
        pesoGanho.caloria += 1;
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
        System.out.println(ruan);
        System.out.println(arroz);
        ruan.comer(arroz);
        System.out.println(ruan);
        ruan.malhar();
        System.out.println(ruan);
        ruan.comer(carne);
        System.out.println(ruan);
        ruan.dormir();
        System.out.println(ruan);
        ruan.comer(feijao);
        System.out.println(ruan);
        ruan.comer(arroz);
        System.out.println(ruan);
        ruan.comer(arroz);
        System.out.println(ruan);
    }
}
