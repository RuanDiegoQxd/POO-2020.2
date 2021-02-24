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
            saida += " " + "[" + fone.get(i) + "]";
        }
        saida += "\n";
        return saida;
    }
}

class ContatoPlus extends Contato{
    boolean fav = false;
    
    public ContatoPlus(String nome) {
        super(nome);
    }

    boolean isFav(){
        return this.fav;
    }

    void setFav(boolean a){
        this.fav = a;
    }
}
class Agenda{
    TreeMap<String, ContatoPlus> contatos;
    
    public Agenda(){
        this.contatos = new TreeMap<>();
        
    }
    
    void getContatos() {
        System.out.print(contatos);
    }

    void getContato(String name){
        if(this.contatos.containsKey(name)){
            System.out.println(contatos.get(name)); 
        }
    }

    void add(String name, List<Fone> fones){
        if(this.contatos.isEmpty()){
            contatos.put(name, new ContatoPlus(name));  
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
            contatos.put(name, new ContatoPlus(name));  
            for(int j = 0; j < fones.size(); j++) {
                contatos.get(name).fone.add(fones.get(j));
            }
        }
    }
    
    void rm(String name){
        if(this.contatos.containsKey(name)){
            contatos.remove(name);
        }
        else
            System.out.println("Fail: Não existe essa pessoa na agenda");
    }
    void rmFone(String name, int index){        
        if(contatos.get(name).nome.equals(name)){
                contatos.get(name).fone.remove(index);
                return;              
        }
        else
            System.out.println("Fail: Não existe esse fone, ou contato na agenda");
        
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

}

    class AgendaPlus extends Agenda{
        TreeMap<String, ContatoPlus> favs;

        public AgendaPlus(){
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

        void getFavs() {
            System.out.print(favs);
        }

        void rm(String name){
            if(this.contatos.containsKey(name)){
                contatos.remove(name);
            }
        }

        void unstar(String name){
            if(this.favs.containsKey(name)){
                favs.remove(name);
            }
        }

        public String toString(){
            String saida = " ";
    
            for(Contato favs : favs.values()){
                saida += "@";
                saida += favs;
            }
            for(ContatoPlus contatos : contatos.values()){
                if(contatos.fav != true){
                    saida += "-";
                    saida += contatos;
                }
            }
            return saida;
        }
    }


class Agendastar{
    public static void main(String[] args){
        AgendaPlus agenda = new AgendaPlus();
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
