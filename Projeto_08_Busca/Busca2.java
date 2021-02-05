import java.util.*;

class Fone{
    String operadora;
    String numero;

    public Fone(String operadora, String numero){
        this.operadora = operadora;
        this.numero = numero; 
    }
    public String toString(){
        return  this.operadora + ":" + this.numero ;
    }
}

class Contato {
    String nome;
    ArrayList<Fone> fone;

    public Contato(String nome){
        this.nome = nome;
        this.fone = new ArrayList<>();
    }

    String getNome(){
        return nome;
    }


    public String toString() {
        String saida = "";
        saida += nome;
        for(int i = 0; i < fone.size(); i++) {
            saida += fone.get(i);
        }
        saida += "\n";
        return saida;
    }
}
class Agenda{
    ArrayList<Contato> contato;

    public Agenda(){
        this.contato = new ArrayList<>();
    }

    void add(String name, List<Fone> fones){

        if(contato.isEmpty()) {
            contato.add(new Contato(name));
            for(int i = 0; i < contato.size(); i++) {
                if(contato.get(i).nome.equals(name)) {
                    for(int j = 0; j < fones.size(); j++) {
                        contato.get(i).fone.add(fones.get(j));
                    }
                }
            }
        }else{
            for(int i = 0; i<contato.size(); i++){
                if(contato.get(i).nome.equals(name)){
                    for(int j = 0; j < fones.size(); j++) {
                        contato.get(i).fone.add(fones.get(j));
                    }
                    return;
                }
            }

            contato.add(new Contato(name));
            for(int i = 0; i < contato.size(); i++) {
                if(contato.get(i).nome.equals(name)) {
                    for(int j = 0; j < fones.size(); j++) {
                        contato.get(i).fone.add(fones.get(j));
                    }
                }
            }
        }

    }
    void rm(String name){
        int p = -1;
        for(int i = 0; i< contato.size(); i++){
            if(contato.get(i).nome.equals(name)){
                p = i;
            }
        }
        contato.remove(p);
    }
    void rmFone(String name, int index){
        for(int i = 0; i< contato.size(); i++){
            if(contato.get(i).nome.equals(name)){
                    contato.get(i).fone.remove(index);
                    return;              
            }
        }
        
    }
    void search(String pat){
        int x = 0;
        System.out.println("Você procurou por: " + pat);
        for(int i = 0; i<contato.size(); i++){
            if(contato.get(i).nome.contains(pat)){
                System.out.println(contato.get(i).nome); 
                x=1;
            }
        }
        if(x==0)
            System.out.println("Nenhum contato encontrado");
    
    }
    public String toString(){
        String saida = "";
        for(int i = 0; i< contato.size(); i++){
            saida += contato.get(i).nome;
            for(int j = 0; j<contato.get(i).fone.size(); j++){
                saida += " " + "[" + j + ":" + contato.get(i).fone.get(j) + "]";
            }
            saida += "\n";
        }
        return saida;
    }

}
class Busca2{
    public static void main(String[] args){
        Agenda agenda = new Agenda();
        agenda.add("ana", Arrays.asList(new Fone("tim", "66223"), new Fone("cla", "9779")));
        agenda.add("mateus", Arrays.asList(new Fone("vivo", "643"), new Fone("oi", "979")));
        agenda.add("mariana", Arrays.asList(new Fone("vivo", "2222")));
        agenda.rmFone("mateus", 0);
        agenda.search("ana");
        agenda.search("joao");

        System.out.println(agenda);
    }
}