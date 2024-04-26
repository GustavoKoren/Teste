public class Sistema {
    private static void menu(){
        System.out.println("\n███╗░░██╗███████╗██████╗░██████╗░██╗░██████╗████████╗░█████╗░██████╗░███████╗");
        System.out.println("████╗░██║██╔════╝██╔══██╗██╔══██╗╚█║██╔════╝╚══██╔══╝██╔══██╗██╔══██╗██╔════╝");
        System.out.println("██╔██╗██║█████╗░░██████╔╝██║░░██║░╚╝╚█████╗░░░░██║░░░██║░░██║██████╔╝█████╗░░");
        System.out.println("██║╚████║██╔══╝░░██╔══██╗██║░░██║░░░░╚═══██╗░░░██║░░░██║░░██║██╔══██╗██╔══╝░░");
        System.out.println("██║░╚███║███████╗██║░░██║██████╔╝░░░██████╔╝░░░██║░░░╚█████╔╝██║░░██║███████╗");
        System.out.println("╚═╝░░╚══╝╚══════╝╚═╝░░╚═╝╚═════╝░░░░╚═════╝░░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝╚══════╝");
        System.out.println("-------------------------------Artigos de RPG--------------------------------");
        System.out.println("\n[1] Cadastrar Dado");
        System.out.println("[2] Cadastrar Tabuleiro");
        System.out.println("[3] Cadastar Boneco");
        System.out.println("[4] Procurar Artigo");
        System.out.println("[5] Mostrar todos os Artigos");
        System.out.println("[6] Exluir Artigo");
        System.out.println("[7] Excluir todos os Artigos");
        System.out.println("[0] Sair");
    }

    private static void verificaOpcao(int op){
        switch (op) {
            case 1:
                cadastrarDado();
                break;
            case 2:
                cadastrarTabuleiro();
                break;
            case 3: 
                cadastrarBoneco();
                break;
            case 4:
                procurarArtigo();
                break;
            case 5:
                mostrarTodosArtigos();
                break;
            case 6:
                excluirArtigo();
            break;
            case 7:
                excluirTodosArtigos();
                break;
            case 0:
                System.out.println("\nO programa foi finalizado...");
                break;
            default:
                System.out.println("\nOpção inválida! Digite novamente");
                break;
        }
    }

private static void mostrarTodosArtigos() {
        if (Cadastro.getListaDeArtigos().isEmpty()) {
        System.out.println("\nNão existem artigos cadastrados.");
        }else{
            System.out.println("\nLista de artigos:");
            for (Artigos artigos : Cadastro.getListaDeArtigos()) {
                System.out.println(artigos.toString());
            }
        }   
    }

private static void cadastrarDado() {
        System.out.println("\nNovo Dado");
        System.out.print("Nome do dado: ");
        String nome = Leitor.lerString(); 
    
        System.out.print("Preco do dado: ");
        Float preco = Leitor.lerFloat(); 
    
        System.out.print("Quantidade em Estoque: ");
        int quant = Leitor.lerInt();
    
        System.out.print("Quantidade de lados: ");
        int lados = Leitor.lerInt();
    
        Dados dado = new Dados(nome,preco,quant,lados);
    
        Cadastro.cadastrarArtigo(dado);
    
        System.out.println("\nDado cadastrado com sucesso!");
    }

    private static void cadastrarTabuleiro() {
        System.out.println("\nNovo Tabuleiro");
        System.out.print("Nome do Tabuleiro: ");
        String nome = Leitor.lerString(); 
    
        System.out.print("Preco do Tabuleiro: ");
        Float preco = Leitor.lerFloat(); 
    
        System.out.print("Quantidade em Estoque: ");
        int quant = Leitor.lerInt();
    
        System.out.print("Numero de casas na vertical: ");
        int casaV = Leitor.lerInt();

        System.out.print("Numero de casas na horizontal: ");
        int casaH = Leitor.lerInt();
    
        Tabuleiro tabuleiro = new Tabuleiro(nome,preco,quant,casaV,casaH);
    
        Cadastro.cadastrarArtigo(tabuleiro);
    
        System.out.println("\nTabuleiro cadastrado com sucesso!");
    }

    private static void cadastrarBoneco() {
        System.out.println("\nNovo Boneco");
        System.out.print("Nome do Boneco: ");
        String nome = Leitor.lerString(); 
    
        System.out.print("Preco do Boneco: ");
        Float preco = Leitor.lerFloat(); 
    
        System.out.print("Quantidade em Estoque");
        int quant = Leitor.lerInt();
    
        System.out.print("Classe do Boneco:");
        String classe = Leitor.lerString();
        
        Boneco boneco = new Boneco(nome,preco,quant,classe);

        Cadastro.cadastrarArtigo(boneco);

        System.out.println("\nBoneco cadastrado com sucesso!");
    }

    private static void procurarArtigo() {
        System.out.println("Informe o nome do artigo que deseja procurar:");
        String nome = Leitor.lerString();

        for (Artigos artigo : Cadastro.getListaDeArtigos()) {
            if (artigo.getNome().equals(nome)) {
                System.out.println("Artigo encontrado");
                System.out.println(artigo.toString());
                return;
            }
            
        }
        System.out.println("Nenhum artigo foi encontrado");
    }

    private static void excluirArtigo() {
        System.out.println("Informe o nome do artigo que deseja Excluir:");
        String nome = Leitor.lerString();

        for (Artigos artigo : Cadastro.getListaDeArtigos()) {
            if (artigo.getNome().equals(nome)) {
                Cadastro.getListaDeArtigos().remove(artigo);
                System.out.println("O artigo foi excluído com sucesso");
                return;
            }
            
        }
        System.out.println("Nenhum artigo foi encontrado");
    }    

    private static void excluirTodosArtigos() {
        Cadastro.getListaDeArtigos().clear();
        System.out.println("Todos os artigos foram excluídos");
    }

    public static void executar() {
        int op;
        do {
            menu();
            op = Leitor.lerInt();
            verificaOpcao(op);
        } while (op != 0);
    }
}
