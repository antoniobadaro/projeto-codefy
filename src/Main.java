import com.codefy.colecoesdereproducao.Playlist;
import com.codefy.servicos.Musica;
import com.codefy.usuario.ManipulacaoDeUsuario;
import com.codefy.usuario.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Instanciar algumas Músicas
        /*Usuario antonio =new Usuario("Antonio", 22, 1105);
        antonio.criarPlaylist("Rock nacional");
        antonio.criarPlaylist("Rock internacional");
        Playlist novaPlaylist = new Playlist(antonio, "Rock");



        List<Playlist> exibriPlaylist= antonio.getMinhasPlaylists();

        System.out.println(novaPlaylist);*/













        Scanner scanner = new Scanner(System.in);
        ManipulacaoDeUsuario manipulacaoDeUsuario=new ManipulacaoDeUsuario(); //instância da classe auxiliar ManipulacaoDeUsuario para poder implementar algumas funcionalidades
        Usuario usuarioParManipulacao = new Usuario(); //usuário instanciado para servir de classe auxiliar para manipular algumas funções da classe Playlist

        //instanciar algumas músicas para testar

        //TELA DE MENU INICIAL
        System.out.println("*** BEM-VINDO AO CODEFY ***");
        System.out.println("Entre ou crie uma conta!\n");
            int opcao=0;
            while (opcao!= 3){

                System.out.println("O que deseja fazer? Escolha uma das opções abaixo:");
                System.out.println("""
                        1-Criar conta
                        2-Entrar em uma conta existente
                        3-sair""");
                opcao = Integer.parseInt(scanner.nextLine()); //variável que recebe a opção escolhida pelo usuário
                switch (opcao) { //switch case para executar a opção escolhida no menu
                    case 1 -> { //cria um conta no app Codfy
                        Usuario novoUsuario= new Usuario();
                        System.out.println("Digite o nome do usuário");
                        novoUsuario.setNome(scanner.nextLine());
                        System.out.println("Digite a idade do usuário");
                        novoUsuario.setIdade(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Crie uma senha");
                        novoUsuario.setSenha(scanner.nextLine());
                        manipulacaoDeUsuario.adicionarUsuario(novoUsuario);
                        System.out.println("Usuário criado com sucesso!");
                        System.out.println(novoUsuario.toString());
                        System.out.println();
                    }
                    case 2 -> { //Entra em uma conta que já tenha sido cadastrada
                        //VALICAÇÃO DA CONTA DO USUÁRIO
                        System.out.println("ID do usuário: ");
                        Integer id= scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Senha: ");
                        String senha= scanner.nextLine();

                        //TELA DE MENU DO USUÁRIO LOGADO
                        try{ //tratamento de exeção IndexOutOfBoundsException, pois caso o id passado (que equeivale ao indice) esteja fora do limite da lista o programa não será interrompido
                            if(manipulacaoDeUsuario.getListaDeUsuarios().get(id).getSenha().equals(senha)) {
                                int op = 0;
                                while (op != 7) {
                                    System.out.println("Vamos lá! assine nosso plano e seja premium ou crie sua playlist");
                                    System.out.println("""
                                            1- Assinar plano
                                            2- Cancelar plano
                                            3- Criar playlist
                                            4- Excluir playlist
                                            5-Adiconar música a uma playlist
                                            6-exibir informaçoes do usuário
                                            7-sair""");
                                    op = Integer.parseInt(scanner.nextLine());
                                    switch (op) {
                                        case 1 -> { //assina o plano
                                            if (!manipulacaoDeUsuario.getListaDeUsuarios().get(id).isAssinante()) {
                                                manipulacaoDeUsuario.getListaDeUsuarios().get(id).assinarPlano();
                                                System.out.println("Plano assinado com sucesso. Agora você é premium!!!");
                                                System.out.println();
                                            } else {
                                                System.out.println("Você já é premium!");
                                                System.out.println();
                                            }
                                        }
                                        case 2 -> { //cancela a assinatura
                                            if (manipulacaoDeUsuario.getListaDeUsuarios().get(id).isAssinante()) {
                                                manipulacaoDeUsuario.getListaDeUsuarios().get(id).cancelarPlano();
                                                System.out.println("Seu plano foi cancelado. Você não receberá mais cobranças futuras.");
                                                System.out.println();
                                            } else {
                                                System.out.println("Você ainda não assinou nenhum plano. Não há como cancelar!");
                                                System.out.println();
                                            }
                                        }
                                        case 3 -> { //cria uma playlit
                                            Playlist novaPlaylist = new Playlist();
                                            novaPlaylist.setAutor(manipulacaoDeUsuario.getListaDeUsuarios().get(id));
                                            System.out.println("Digite o nome da playlist");
                                            novaPlaylist.setNomeDaPlaylist(scanner.nextLine());
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).adicionarPlaylist(novaPlaylist);
                                            System.out.println(manipulacaoDeUsuario.getListaDeUsuarios().get(id).toString());
                                            System.out.println("O tamanho: "+usuarioParManipulacao.getMinhasPlaylists().size());
                                            System.out.println();
                                        }
                                        case 4 -> { //exclui uma playlist
                                            System.out.println("Digite o id da playlist que deseja excluir");
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).lisarPlaylist();

                                            int idParaExcluir=scanner.nextInt();
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).excluirPlaylist(usuarioParManipulacao.getMinhasPlaylists().get(idParaExcluir));

                                            System.out.println();

                                        }
                                        case 5->{ //adiciona musicas a uma playlist
                                            //adicionar musicas na playlist
                                            //mostrar lista de musicas da playlist
                                        }
                                        case 6->{ //exibe as informações do usuário
                                            System.out.println(manipulacaoDeUsuario.getListaDeUsuarios().get(id).toString());
                                            System.out.println();
                                        }
                                        case 7->{ //sai do menu do usuário e retorna para o menu inicial
                                            System.out.println("Estamos te direcionando para o menu inicial...");
                                            System.out.println();
                                        }

                                    }
                                }
                            }else{
                                System.out.println("Não encontramos o usuário");
                                System.out.println();
                            }
                        }catch (IndexOutOfBoundsException e){
                            System.out.println("Não encontramos o usuário");
                            System.out.println();
                        }

                    }
                    case 3->{
                        System.out.println("Encerrando o Codefy");
                    }
                    default -> {
                        System.out.println("Opção inválida. Escolha uma das opções listadas");
                        System.out.println();
                    }
                }
            }
    }

}
