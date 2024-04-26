import java.util.ArrayList;
import java.util.List;

public class Cadastro{
    private static List <Artigos> listaDeArtigos = new ArrayList<>();
    
    //adiciona pessoa a lista
    public static void cadastrarArtigo(Artigos artigos){
        listaDeArtigos.add(artigos);
    }

    //busca artigo na lista por nome
    public static Artigos buscarArtigos(String nome){
        for (Artigos artigos : listaDeArtigos) {
            if(artigos.getNome()==nome){
                //artigo encontrado
                return artigos;
            }
        }
        return null;
    }

    public static List<Artigos> getListaDeArtigos() {
        return listaDeArtigos;
    }
} 

