


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

    void comer(){
        bucho = bucho + 1;
        if(bucho > maxBucho){
            bucho = maxBucho;
            hp = hp + 1;
            System.out.println("Comi até ficar saciado, me sinto restaurado");
        }else{
            System.out.println("nhame nhame, muito bom");
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
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

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " Vida: " + hp;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Calango deadlango = new Calango(20, 20, 4, 10);
        System.out.println(deadlango);
        

        for(int i=0; i<2; i++){
            deadlango.comer();
        }
        System.out.println(deadlango);
        for(int i=0; i<50; i++){
            deadlango.andar();
        }
        System.out.println(deadlango);
        
        // for(int i = 0; i < 25; i++)
        //     deadlango.comer(1);
        // System.out.println(deadlango);
        
        // deadlango.acidentar();
        // deadlango.acidentar();
        // deadlango.acidentar();
        // System.out.println(deadlango);

        // for(int i = 0; i < 25; i++)
        //     deadlango.andar();
        // System.out.println(deadlango);
        // deadlango.regenerar();
        // deadlango.regenerar();
        // deadlango.regenerar();
        // deadlango.regenerar();
        // deadlango.regenerar();
        // System.out.println(deadlango);
        // deadlango.acidentar();
        // deadlango.regenerar();
        // deadlango.bucho = 0;
        // deadlango.maxBucho = 20;
        // deadlango.nPatas = 4;


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();


        // deadlango.comer();

        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();

    }
}


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();

