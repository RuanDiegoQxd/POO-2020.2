import java.util.*;

 class Tweet{
    int idTw;
    String username;
    String msg;
    TreeSet<String> likes;

    public Tweet(String username, String msg, int idTw) {
        this.username = username;
        this.idTw = idTw;
        this.msg = msg;
        this.likes = new TreeSet<>();
    }

    void like(String username) {
        likes.add(username);
    }

    public int getIdTw(){
        
        return idTw;
    
    }
    
    public String getUsername(){
    
        return username;
    
    }
    
    public String getMsg(){
    
        return msg;
    
    }

    public String toString() {
        return this.idTw + ":" + this.username + "( " + this.msg + ")" + this.likes + "\n";
    }
}

 class User {
    String username;
    TreeMap<String, User> followers;
    TreeMap<String, User> following;
    ArrayList<Tweet> timeline;
    int unreadCount;

    public User(String username) {
        this.username = username;
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.timeline = new ArrayList<>();

    }

    public String getUsername(){
        
        return username;

    }

    public Tweet getTweet(int id){
        for(Tweet twt : timeline){
            if(twt.idTw == id)
                return twt;
        }
        
        System.out.println("ababababe");
        return null;  
    }

    void follow(User user) {       
        following.put(user.username, user);
        user.followers.put(this.username, this);
    }

    void unfollow(String username) {
        User user = following.get(username);
        this.following.remove(username);
        user.followers.remove(this.username);
        return;
    }


    void sendTweet(Tweet tweet) {
        this.timeline.add(tweet);
        this.unreadCount += 1;
    }

    String getUnread() {
        String saida = "";
        for(int i = timeline.size(); i>timeline.size() - unreadCount; i--){
            saida += timeline.get(i);
            unreadCount--;
        }
        return saida;
    }

    String getTimeline() {
        String saida = "";
        for(Tweet tweet : timeline)
            saida += tweet;
        unreadCount = 0;
        return saida;
    }

    public String toString(){
        String saida = "";
        saida += "\n" + " Seguidos: " + this.following.keySet() + "\n" + " Seguidores: " + this.followers.keySet() + "\n";
        return saida;  
    }
}

 class Controller {
    TreeMap<String, User> users;
    TreeMap<Integer, Tweet> tweets;
    int nextTwId = 0;

    public Controller() {
        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
    }

    // int x = 0;

    void sendTweet(String username, String msg) {
       // User user = this.getUser(username);
       // Tweet twt = new Tweet(username, msg, nextTwId++);
       // user.sendTweet(twt);

        User user = getUser(username);
        
        tweets.put(nextTwId, new Tweet(username, msg, nextTwId));
        for(User cara : this.users.values()){
            if(cara.username.equals(username)){
                for (User nome : user.following.values()) {
                    nome.sendTweet(getT(nextTwId));
                }
                user.sendTweet(getT(nextTwId));
                nextTwId =+ 1;
            }
        }
        
    }

    public Tweet getT(int q){
        for(Tweet tweet : tweets.values()){
            if(tweet.idTw == (q)){
                return tweet;
            }
        }
            return null;

    }

    void addUser(String username){
        users.put(username, new User(username));
    }

    public User getUser(String username) {
        for(User name : this.users.values()) {
            if(name.username.equals(username)) {
                return name;
            }
        }

        return null;
    }

    public String toString(){
        String saida = " ";
        saida += "Users: " + "\n" + users + "\n";
        return saida;    
    }
}
public class Twit{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller sistema = new Controller();
        
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            try {
                if (ui[0].equals("end"))
                    break;
                else if (ui[0].equals("add")) {
                    sistema.addUser(ui[1]);
                } else if(ui[0].equals("teste")){
                    sistema.addUser("ruan");
                    sistema.addUser("joao");
                    sistema.addUser("bruno");
                    sistema.addUser("junior");
                    User r = sistema.getUser("ruan");
                    sistema.getUser("junior").follow(r);
                    User j = sistema.getUser("junior");
                    sistema.getUser("ruan").follow(j);
                    User b = sistema.getUser("joao");
                    sistema.getUser("ruan").follow(b);
                    User jp = sistema.getUser("ruan");
                    sistema.getUser("joao").follow(jp);
                    User a = sistema.getUser("joao");
                    sistema.getUser("junior").follow(a);
                    User c = sistema.getUser("junior");
                    sistema.getUser("joao").follow(c);
                } else if (ui[0].equals("show")) {
                    System.out.print(sistema);
                } else if (ui[0].equals("follow")) {
                    User two = sistema.getUser(ui[2]);
                    sistema.getUser(ui[1]).follow(two);                
                }
                else if (ui[0].equals("twittar")) {//goku msg
                    String username = ui[1];
                    String msg = "";
                    for(int i = 2; i < ui.length; i++)
                        msg += ui[i] + " ";
                    sistema.sendTweet(username, msg);
                }
                else if (ui[0].equals("timeline")) {
                    User user = sistema.getUser(ui[1]);
                    System.out.print(user.getTimeline());
                }
                else if (ui[0].equals("unread")) {
                    User user = sistema.getUser(ui[1]);
                    System.out.print(user.getUnread());
                }
                else if (ui[0].equals("like")) {
                    User user = sistema.getUser(ui[1]);
                    Tweet tw = user.getTweet(Integer.parseInt(ui[2]));
                    tw.like(ui[1]);
                }else if (ui[0].equals("unfollow")) {
                    User user = sistema.getUser(ui[1]);
                    user.unfollow(ui[2]);
                }else{
                    System.out.println("fail: comando invalido");
                }
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
        scanner.close();
    }
}
