
public class Hash {
   Game tabela[];
   Game m1, m2, m, reserva;
   final Game NULO = -1;

   public Hash() {
      this(21, 9);
   }

   public Hash(int m1, int m2) {
      this.m1 = m1;
      this.m2 = m2;
      this.m = m1 + m2;
      this.tabela = new Game[this.m];
      for (Game i = 0; i < m1; i++) {
         tabela[i] = NULO;
      }
      reserva = 0;
   }

   public int h(Game elemento) {
      return (int)elemento.getName % m1;
   }

   public boolean inserir(Game elemento) {
      boolean resp = false;
      if (elemento != NULO) {
         Game pos = h(elemento);
         if (tabela[pos] == NULO) {
            tabela[pos] = elemento;
            resp = true;
         } else if (reserva < m2) {
            tabela[m1 + reserva] = elemento;
            reserva++;
            resp = true;
         }
      }
      return resp;
   }

   public boolean pesquisar(Game elemento) {
      boolean resp = false;
      Game pos = h(elemento);
      if (tabela[pos] == elemento) {
         resp = true;
      } else if (tabela[pos] != NULO) {
         for (Game i = 0; i < reserva; i++) {
            if (tabela[m1 + i] == elemento) {
               resp = true;
               i = reserva;
            }
         }
      }
      return resp;
   }

   boolean remover(Game elemento) {
      boolean resp = false;
      // ...
      return resp;
   }

}
public static void main(String[] args) throws Exception {
  Scanner scr = new Scanner(System.in);
  Hash tabela = new Hash();
  String line = scr.nextLine();


        // Fill hash table with requested ids
        while(true) {

            if(line.equals("FIM")) break;

            tabela.inserir(Integer.parseInt(line));

            line = scr.nextLine();
        }
        // Add requested ids to games list
        try {

            // Read CSV file
            FileInputStream fstream = new FileInputStream("/tmp/games.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ------------------------------------ //

            // Start to explode CSV file
            while((line = br.readLine()) != null) {

                if(gamesToAdd.contains(Integer.parseInt(line.substring(0, line.indexOf(','))))) {

                    Game game = new Game();

                    game.read(line);
                    games.add(game);
                }
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }
  // Search in games list by name
        line = scr.nextLine();

        while(true) {

            if(line.equals("FIM")) break; 
             boolean found = false;

            for(int i = 0; i < 30; i++) {

                if(hash.pesquisar==true) {

                    found = true;
                    break;
                }
            }
        }
}


                