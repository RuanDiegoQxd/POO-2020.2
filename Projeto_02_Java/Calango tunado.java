import java.util.Scanner;


class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int hp;
    //mesmo nome da classe = sombreamento de variavel
    Calango(int bucho, int maxBucho, int nPatas, int hp){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
        this.hp = hp;
    }

    void comer(int qtdc){
        bucho = bucho + qtdc;
        if(bucho > maxBucho){
            bucho = maxBucho;
            hp = hp + 1;
            System.out.println("Comi até ficar saciado, me sinto restaurado");
        }else{
            System.out.println("nhame nhame, muito bom");
        }
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel, andei " + dist + " metros");
            return;
        }        
        if(bucho==0){
            if(hp > 0){
                System.out.println("Tentar fazer isso me machuca");
                hp = hp - 1;
                return;
            }else if(hp==0){
                System.out.println("Vida crueeeel. Morri");
                System.exit(0);
            }
        }
    }

    void acidentar(int qtda){
        if(nPatas > 0){
            if(qtda>nPatas){
                System.out.println("Eu nem tenho tudo isso de perna :/");
                return;
            }
            nPatas -= qtda;
            System.out.println("Ouch! Perdi " + qtda + " pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(int qtdr){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        } else if(qtdr+nPatas>4){
            System.out.println("Cara, eu sou um calango, não uma centopeia");
        } else if (bucho > 0){
            nPatas += qtdr;
            bucho -= 1;
            System.out.println("Opa! Recuperei " + qtdr + " pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " Vida: " + hp;
    }

    public static void main(String[] args) {
        Calango deadlango = new Calango(20, 20, 4, 10);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(line.equals("end")){
                break;
            } else if(ui[0].equals("comer")) {
                deadlango.comer(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("andar")){
                deadlango.andar(Integer.parseInt(ui[1]));
            } else if(line.equals("mostrar")){
                System.out.println(deadlango);
            }else if(ui[0].equals("regenerar")){
                deadlango.regenerar(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("acidentar")){
                deadlango.acidentar(Integer.parseInt(ui[1]));
            } else {
                System.out.println("que?");
            }
        }
        scanner.close();

    }
}

        