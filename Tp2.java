import java.util.Date;
class Game{
    private int app_id;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;
    public int getapp_id(){
        return app_id;
    }
    public String getname(){
        return name;
    }
    public Date getrelease_date(){
        return release_date;
    }
    public String getowners(){
        return owners;
    }
    public int getage(){
        return age;
    }
    public float getprice(){
        return price;
    }
    public int getdlcs(){
        return dlcs;
    }
    public String[] getlanguages(){
        return languages;
    }
    public String getwebsite(){
        return website;
    }
    public boolean getwindows(){
        return windows;
    }
    public boolean getmac(){
        return mac;
    }
    public boolean getlinux(){
        return linux;
    }
    public float getupvotes(){
        return upvotes;
    }
    public int getav_pt(){
        return avg_pt;
    }
    public String getdevelopers(){
        return developers;
    }
    public String[] getgenres(){
        return genres;
    }
    public void setapp_id(int app_id){
        this.app_id=app_id;
    }
    public void setname(String name){
        this.name=name;
    }
    public void setReleaseDate(Date release_date){
       this.release_date=release_date;
    }
    public void setOwners(String owners){
        this.owners=owners;
    }
    public void setage(int age){
        this.age=age;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public void setDlcs(int dlcs){
      this.dlcs=dlcs;
    }
    public void setlanguages(String languages[]){
        this.languages=languages;
    }
    public void setwebsite(String website){
       this.website=website;
    }
    public void setWindows(boolean windows){
        this.windows=windows;
    }
    public void setMac(boolean mac){
        this.mac=mac;
    }
    public void setLinux(boolean linux){
        this.linux=linux;
    }
    public void setupvotes(float upvotes){
        this.upvotes=upvotes;
    }
    public void setavg_pt(int avg_pt){
        this.avg_pt=avg_pt;
    }
    public void setdevelopers(String developers){
        this.developers=developers;
    }
    public void setGenres(String genres[]){
        this.genres=genres;
    }
    public void imprimir(Game exemplo){//Usar split(https://www.alura.com.br/artigos/como-separar-palavras-de-string-em-java?gclid=EAIaIQobChMIlJOg8ZyA-gIV_xXUAR0yqwFlEAAYASAAEgKY2vD_BwE). parseFloat(https://www.geeksforgeeks.org/float-parsefloat-method-in-java-with-examples/), mascara para Date.
        System.out.print
    }

}