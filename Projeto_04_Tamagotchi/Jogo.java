class Tamagochi{
    private int energia;
    private int energiaMax;
    private int fome;
    private int fomeMax;
    private int limpeza;
    private int limpezaMax;
    private int idade;
    private int diamante;
    private boolean alive;

    public Tamagochi(int energiaMax, int fomeMax, int limpezaMax){
        this.energia = energiaMax;
        this.energiaMax = energiaMax;
        this.fomeMax = fomeMax;
        this.fome = fomeMax;
        this.limpezaMax = limpezaMax;
        this.limpeza = limpezaMax;
        this.idade = 0;
        this.diamante = 0;
        this.alive = true;
    }
    private void setEnergia(int x){
        energia = x;
        if(energia <= 0){
            energia = 0;
            System.out.println("Seu pet morreu de cansaço");
            this.alive = false;
        }
        if(energia > energiaMax)
            energia = energiaMax;
    }
    private void setFome(int x){
        fome = x;
        if(fome <= 0){
            fome = 0;
            System.out.println("Seu pet morreu de fome");
            this.alive = false;
        }
        if(fome > fomeMax)
            fome = fomeMax;
    }
    private void setLimpeza(int x){
        limpeza = x;
        if(limpeza <= 0){
            limpeza = 0;
            System.out.println("Seu pet morreu de sujo");
            this.alive = false;
        }
        if(limpeza > limpezaMax)
            limpeza = limpezaMax;
    }
    private boolean testarMorto(){
        if(this.energia <= 0 || this.limpeza <= 0 || this.fome <= 0){
            System.out.println("fail: Seu pet está morto :(");
            return true;
        }
        return false;        
    }
    void comer(){
        if(testarMorto())
            return;
        if(fome == fomeMax){
            System.out.println("Seu pet não está com fome");
            return;
        }
        setEnergia(this.energia -= 1);
        setFome(this.fome += 4);
        setLimpeza(this.limpeza -=2);
        this.idade += 1;
    } // -1 a energia, +4 a saciedade, -2 a limpeza, +0 diamantes,  +1 a idade
    void brincar(){
        if(testarMorto())
            return;
        this.energia -= 2;
        this.fome -= 1;
        this.limpeza -=3;
        this.diamante += 1;
        this.idade += 1;
    } // -2 energia, -1 saciedade, -3 limpeza, +1 diamante, +1 idade.
    void dormir(int turno){  
        if(energia > 15){
            System.out.println("Seu pet não está cansado");
            return;
        } 
        this.energia = this.energiaMax;
         
        for(int i = turno; i>0; i--){
            int c = turno - i;
            if(idade == 0){
                System.out.println("Seu pet ja está totalmente restaurado, ele dormiu " + c + " turnos");
                return;
            }
            idade--;
        }    
    }
    void banho(){
        if(testarMorto())
            return;
        if(limpeza == limpezaMax){
            System.out.println("Seu pet já está todo limpinho");
            return;
        }
        setEnergia(this.energia -= 3);
        setFome(this.fome -=1);
        this.limpeza = this.limpezaMax;
        this.idade += 2;
    } //-3 energia, -1 na saciedade, MAX na limpeza, +0 diamantes, +2 na idade.
    public String toString() {
        return "E: " + energia + "/" + energiaMax + " F: " + fome + "/" + fomeMax + " L: " + limpeza + "/" + limpezaMax + " I: " + idade + " D: " + diamante;
    }
}

    public class Jogo{
        public static void main(String[] args) {
            Tamagochi bob = new Tamagochi(20, 10, 15);
            bob.comer();
            System.out.println(bob);
            bob.dormir(3);
            System.out.println(bob);
            bob.brincar();
            System.out.println(bob);
            bob.banho();
            System.out.println(bob);
            bob.brincar();
            System.out.println(bob);
            bob.dormir(50);
            System.out.println(bob);
            bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();bob.brincar();
            System.out.println(bob);
            bob.banho();
            
        }
    }      

