import java.util.ArrayList;
import java.util.Collections;

class Pessoax{
    String id;
    int idade;
    public Pessoax(String id, int idade){
        this.id = id;
        this.idade = idade;
    }
    public String toString(){
        return this.id + ":" + this.idade;
    }  
}

class Carro{
    ArrayList<Pessoax> cadeiras;
    int tamanho;
    int cadPref;
    public Carro(int tamanho, int cadPref){
        this.tamanho = tamanho;
        this.cadPref = cadPref;
        //for(int i = 0; i < tamanho; i++){
        //    if(cadeiras.get(i)!=null)
        //        cadeiras.set(i, null);
        //}
        cadeiras = new ArrayList<>(Collections.nCopies(tamanho, null));
        Pessoax pessoax = null;
    }
        
 
        public void in(String id, int idade) {
            if(idade>=60){
                boolean x = false;
                for(int i = 0; i<this.tamanho; i++){
                    if(cadeiras.get(i)==null){
                        x = true;
                        cadeiras.set(i, new Pessoax(id, idade));
                        break;
                    }
                }
                if(x==false)
                    System.out.println("Carro lotada veio");
            }  
            else{
                boolean x = false;
                for(int i = this.cadPref; i < this.tamanho; i++){
                    if(cadeiras.get(i)==null){
                        x = true;
                        cadeiras.set(i, new Pessoax(id, idade));
                        break;
                    }
                }
                if(x==false){
                    x = false;
                    for(int i = 0; i<this.tamanho; i++){
                        if(cadeiras.get(i)==null){
                            x = true;
                            cadeiras.set(i, new Pessoax(id, idade));
                            break;
                        }
                    }
                }
                if(x==false)
                    System.out.println("Carro lotada irmão");
            }          
        }
    

    public void out(String id){
        boolean encontrei = false;
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i) != null && cadeiras.get(i).id.equals(id)){
                cadeiras.set(i, null);
                encontrei = true;
                break;
            }
        }
        if(encontrei)
            System.out.println("Desceu 1 pessoa");
        else
            System.out.println("Id não encontrado");
    }

    public String toString(){
        String saida = "[ ";
            for (int i = 0; i< this.tamanho; i++) {
                if(cadeiras.get(i) == null && i < cadPref){
                    saida += "@ ";
                }
                if(cadeiras.get(i) == null && i >= cadPref){
                    saida += "= ";
                }
            }
            for (Pessoax pessoa : cadeiras) {
                if( pessoa != null)
                    saida += pessoa + " ";
            }

        return saida + "]";
    }
}

public class Topic{
    public static void main(String[] args) {
        Carro Carro = new Carro(5, 3);
        System.out.println(Carro);
        Carro.in("david", 85);
        System.out.println(Carro);
        Carro.in("pedro", 12);
        System.out.println(Carro);
        Carro.in("joao", 59);
        System.out.println(Carro);
        Carro.in("felipe", 87);
        System.out.println(Carro);
        Carro.in("Josué", 14);
        System.out.println(Carro);
        Carro.in("Aluizio", 88);
        System.out.println(Carro);
        Carro.in("jotajota", 9);
        System.out.println(Carro);
        Carro.in("jotape", 57);
        System.out.println(Carro);
        Carro.out("jotape");
        System.out.println(Carro);
        Carro.out("Josué");
        System.out.println(Carro);
        Carro.in("jo", 77);
        System.out.println(Carro);
        Carro.in("joa", 17);
        System.out.println(Carro);
    }
}



