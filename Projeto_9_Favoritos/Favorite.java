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
    boolean fav = false;

    public Contato(String nome){
        this.nome = nome;
        this.fone = new ArrayList<>();
        this.fav = false;
    }    

    String getNome(){
        return nome;
    }

    boolean isFav(){
        return this.fav;
    }

    void setFav(boolean a){
        this.fav = a;
    }

    public String toString() {
        String saida = "";

        saida += nome;
        for(int i = 0; i < fone.size(); i++) {
            saida += " " + "[" + fone.get(i) + "]";
        }
        saida += "\n";
        return saida;
    }
}
class Agenda{
    TreeMap<String, Contato> contatos;
    TreeMap<String, Contato> favs;
    

    public Agenda(){
        this.contatos = new TreeMap<>();
        this.favs = new TreeMap<>();
    }

    void star(String name){
        if(this.contatos.containsKey(name)){
            favs.put(name, contatos.get(name));
            boolean x = true;
            contatos.get(name).setFav(x);
            return;
        }
        System.out.println("Não existe essa pessoa");
    }


    void favs() {
        System.out.print(favs);
    }
    
    void add(String name, List<Fone> fones){
        if(this.contatos.isEmpty()){
            contatos.put(name, new Contato(name));  
            for(int j = 0; j < fones.size(); j++) {
                contatos.get(name).fone.add(fones.get(j));
            }
        }
        else if(this.contatos.containsKey(name)){
            for(int j = 0; j < fones.size(); j++) {
                contatos.get(name).fone.add(fones.get(j));
            }
        }

        else{
            contatos.put(name, new Contato(name));  
            for(int j = 0; j < fones.size(); j++) {
                contatos.get(name).fone.add(fones.get(j));
            }
        }
    }
    
    void rm(String name){
        if(this.contatos.containsKey(name)){
            contatos.remove(name);
        }
    }
    void rmFone(String name, int index){        
        if(contatos.get(name).nome.equals(name)){
                contatos.get(name).fone.remove(index);
                return;              
        }
        
        
    }
    void search(String pat){
        int x = 0;
        System.out.println("Você procurou por: " + pat);
        for(Contato contatos : contatos.values()){
            if(contatos.toString().contains(pat)){
                System.out.print(contatos); 
                x=1;
            }
        }
        if(x==0)
            System.out.println("Nenhum contato encontrado");
    
    }
    public String toString(){
        String saida = " ";

        for(Contato favs : favs.values()){
            saida += "@";
            saida += favs;
        }
        for(Contato contatos : contatos.values()){
            if(contatos.fav != true){
                saida += "-";
                saida += contatos;
            }
        }
        return saida;
    }

}
class Favorite{
    public static void main(String[] args){
        Agenda agenda = new Agenda();
        agenda.add("ana", Arrays.asList(new Fone("tim", "66223"), new Fone("cla", "9779")));
        agenda.add("mateus", Arrays.asList(new Fone("vivo", "643"), new Fone("oi", "95475")));
        agenda.add("maria", Arrays.asList(new Fone("tim", "95"), new Fone("viv", "65816")));
        agenda.add("lucia", Arrays.asList(new Fone("cla", "653"), new Fone("cla", "351")));
        agenda.add("joana", Arrays.asList(new Fone("vivo", "553"), new Fone("tim", "47")));
        agenda.add("mariana", Arrays.asList(new Fone("tim", "2222")));
        agenda.star("mariana");
        System.out.println(agenda);
        agenda.search("ma");
    }
}