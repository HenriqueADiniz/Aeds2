import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileReader;
//Dica para quickSort, mexe no .elemento e n nos ponteiros
class Data {
    private String str = "";

    public Data(String data) {
        this.formate(data);
    }

    private void formate(String data) {
        str += data.charAt(0);
        str += data.charAt(1);
        str += data.charAt(2);
        str += '/';
        str += data.charAt(data.length() - 4);
        str += data.charAt(data.length() - 3);
        str += data.charAt(data.length() - 2);
        str += data.charAt(data.length() - 1);
    }

    @Override
    public String toString() {
        return str;
    }
}

class Game {
    //=====PRIVATE=====//
    public int app_id, age, dlcs, avg_pt;
    public float price, upvotes;
    public Boolean win, mac, lin;
    public Data date;
    public String name, owners, website, developers;
    public String[] languages, genres;

    //=====CONSTRUCTOR=====//
    public Game(String d) {
        String[] arr = split(d, ',');

        app_id = Integer.parseInt(arr[0]);
        name = arr[1];
        date = new Data(arr[2]);
        owners = arr[3];
        age = Integer.parseInt(arr[4]);
        price = Float.parseFloat(arr[5]);
        dlcs = Integer.parseInt(arr[6]);
        languages = split(remove(remove(arr[7], '['), ']'), ',');
        website = arr[8];
        win = arr[9].equals("True");
        mac = arr[10].equals("True");
        lin = arr[11].equals("True");
        upvotes = (Float.parseFloat(arr[12]) / (Float.parseFloat(arr[12]) + Float.parseFloat(arr[13]))) * 100;
        avg_pt = (arr[14].length() == 0) ? 0 : Integer.parseInt(arr[14]);
        developers = arr[15];
        genres = split(arr[16], ',');
    }

    public String getAvg_pt() {
        int h = avg_pt / 60,
            m = avg_pt % 60;
        String res;

        if(h != 0 && m == 0) res = h + "h";
        else if(h != 0 && m != 0) res = h + "h " + m + "m";
        else if(h == 0 && m != 0) res = m + "m";
        else res = null;
        return res;
    }

    //=====STRING=====//
    public static String imprimeArray(String[] arr) {
        String res  = "[";
        for(int i = 0; i < arr.length; i++) {
            res += arr[i];
            if(i != arr.length - 1) {
                res += ",";
            }
        }
        return res + "]";
    }

    public static String remove(String s, char c) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != c) {
                res += s.charAt(i);
            }
        }
        return res;
    }
    
    //=====SPLIT=====//
    public static String[] split(String str, char ch) {
        String res = "";
        String[] array = new String[contar(str, ch) + 1];

        int j = 0;
        for(int i = 0, k = 0, l = 0; i < str.length(); i++) {
            if(str.charAt(i) == 91 || str.charAt(i) == 93) {
                l++;
            } 
            if(str.charAt(i) == 34) {
                k++;
            }
            else if(str.charAt(i) != ch || k % 2 != 0) {
                if(l % 2 == 0) {
                    res += str.charAt(i);
                }
                else if(str.charAt(i) != 39) {
                    res += str.charAt(i);
                }
            } else {
                array[j++] = res;
                res = "";
            }
        }

        array[j] = res;
        

        return array;
    }

    public static int contar(String str, char ch) {
        int res = 0;

        for(int i = 0, j = 0; i < str.length(); i++) {
            if(str.charAt(i) == 34) {
                j++;
            }
            else if(str.charAt(i) == ch && j % 2 == 0){
                res++;
            }   
        }
        
        return res;
    }

    //=====OVERRIDE=====//
    @Override
    public String toString() {
        return app_id + " " + name + " " + date + " " + owners + " " + age + " " + (((int)price == price) ? (int)price + ".00" : price) + " " + dlcs + " " + imprimeArray(languages) + " " + ((website.length() != 0) ? website : null) + " " + win + " " + mac + " " + lin + " " + (int)Math.round(upvotes) + "% " + getAvg_pt() + " " + developers + " " + Arrays.toString(genres);
    }

}
class Celula{
    public Game elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.
    /**
	 * Construtor da classe.
	 */
	public Celula() {
		this(0);
	}
    /**
	 * Construtor da classe.
	 * @param elemento Game inserido na celula.
	 */
	public Celula(Game elemento) {
      this.elemento = elemento;
      this.prox = null;
	}

}

class Lista {
   private Celula primeiro,ultimo;
    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }
    public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }

    public boolean isVazio() {
        return tamanho == 0;
    }

    public boolean isCheio() {
        return tamanho == arr.length;
    }

    public void inserirInicio(Game game) {
        Celula tmp = new Celula(game);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
    }
  
	public void inserirFim(Game x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


    public void inserir(Game game, int pos) {
       int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(game);
      } else if (pos == tamanho){
         inserirFim(game);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = new Celula(game);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
    }

    public Game removeFim()throws Exception{
        if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      int resp = ultimo.elemento; 
      ultimo = i; 
      i = ultimo.prox = null;
      
		return resp;
    }

    public Game removePosicao(int pos) {
         int resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = i.prox;
         resp = tmp.elemento;
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }

		return resp;
    }

    public void imprimir() {
       System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
    }
    public boolean pesquisar(Game x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}

    @Override 
    public String toString() {
        String str = "[";
        for(int i = 0; i < tamanho; i++) {
            str += arr[i];
            if(i != tamanho - 1) {
                str += ", ";
            }
        }

        return str + "]";
    }
}

public class Questao01 {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Lista lista = new Lista(100);
        String str;

        do {
            str = br.readLine();
            if(!str.equals("FIM")) {
                lista.adiciona(new Game(procura(str)));
            }            
        } while(!str.equals("FIM"));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            str = br.readLine();
            String[] array = str.split(" ");

            if(array[0].charAt(0) == 'I') {

    
                if(array[0].charAt(1) == 'I') {
                    lista.adiciona(new Game(procura(array[1])), 0);
                }
                else if(array[0].charAt(1) == 'F') {
                    lista.adiciona(new Game(procura(array[1])));
                }
                else {
                    lista.adiciona(new Game(procura(array[2])), Integer.parseInt(array[1]));
                }

            } else {
                if(array[0].charAt(1) == 'I') {
                    System.out.println("(R) " + lista.removePosicao(0).name);
                }
                else if(array[0].charAt(1) == 'F') {
                    System.out.println("(R) " + lista.removeFim().name);
                }
                else {
                    System.out.println("(R) " + lista.removePosicao(Integer.parseInt(array[1])).name);
                }
            }
        }

        lista.imprimir();

        br.close();
    }

    public static String procura(String id) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/tmp/games.csv"));
        String game = br.readLine();

        while(game != null) {
            if(ID(game).equals(id)) {
                break;
            }
            game = br.readLine();
        } 
        
        br.close();
        return game;
    }

    public static String ID(String str) {
        String id = "";
        for(int i = 0; str.charAt(i) != ',' && i < str.length(); i++) {
            id += str.charAt(i);
        }

        return id;
    }

}
