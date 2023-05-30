import com.codefy.colecoesdereproducao.Playlist;

import com.codefy.servicos.Musica;
import com.codefy.usuario.ManipulacaoDeUsuario;
import com.codefy.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        ManipulacaoDeUsuario manipulacaoDeUsuario=new ManipulacaoDeUsuario(); //instância da classe auxiliar ManipulacaoDeUsuario para poder implementar algumas funcionalidades

        List<Musica> musicasDeTeste =new ArrayList<>();
        musicasDeTeste.add(new Musica(120,"Dia Especial","Pouca Vogal"));
        musicasDeTeste.add(new Musica(185,"Como tudo deve ser","CBJR"));
        musicasDeTeste.add(new Musica(120,"Vamos fugir","Skank"));

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
                        System.out.println(novoUsuario);
                        System.out.println();
                    }
                    case 2 -> { //Entra em uma conta que já tenha sido cadastrada
                        //VALICAÇÃO DA CONTA DO USUÁRIO
                        System.out.println("ID do usuário: ");
                        int id= scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Senha: ");
                        String senha= scanner.nextLine();

                        //TELA DE MENU DO USUÁRIO LOGADO
                        try{ //tratamento de exeção IndexOutOfBoundsException, pois caso o id passado (que equeivale ao indice) esteja fora do limite da lista o programa não será interrompido
                            if(manipulacaoDeUsuario.getListaDeUsuarios().get(id).getSenha().equals(senha)) {
                                int op = 0;
                                while (op != 8) {
                                    System.out.println("Vamos lá! assine nosso plano e seja premium ou crie sua playlist");
                                    System.out.println("""
                                            1- Assinar plano
                                            2- Cancelar plano
                                            3- Criar playlist
                                            4- Excluir playlist
                                            5- Adiconar música a uma playlist
                                            6- exibir informaçoes do usuário
                                            7- Alterar nome do usuário
                                            8- sair""");
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
                                            System.out.println();
                                        }
                                        case 4 -> { //exclui uma playlist
                                            System.out.println("Digite o id da playlist que deseja excluir");
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).listarPlaylist();
                                            //scanner.nextLine();
                                            int idParaExcluir=Integer.parseInt(scanner.nextLine());
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).excluirPlaylist(manipulacaoDeUsuario.getListaDeUsuarios().get(id).getMinhasPlaylists().get(idParaExcluir));

                                            System.out.println();

                                        }
                                        case 5->{ //adiciona musicas a uma playlist
                                            System.out.println("Digite o id da playlist que deseja adicionar uma música");
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).listarPlaylist();
                                            int idParaAdicioanr=Integer.parseInt(scanner.nextLine());
                                            System.out.println("Digite o id da música que deseja adicionar");
                                            for (int i =0; i<musicasDeTeste.size();i++){
                                                System.out.println(musicasDeTeste.get(i).getNomeFaixa()+" | ID: "+ i);
                                            }
                                            int idDaMusica=Integer.parseInt(scanner.nextLine());
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).getMinhasPlaylists().get(idParaAdicioanr).adicionarMusica(musicasDeTeste.get(idDaMusica));
                                            System.out.println("Musica adicionada com sucesso");
                                            System.out.println("As músicas dessa playlist são: "+manipulacaoDeUsuario.getListaDeUsuarios().get(id).getMinhasPlaylists().get(idParaAdicioanr).toString());
                                        }
                                        case 6->{ //exibe as informações do usuário
                                            System.out.println(manipulacaoDeUsuario.getListaDeUsuarios().get(id).toString());
                                            System.out.println();
                                        }
                                        case 7->{ //altera o nome do usuário
                                            System.out.println("Informe o novo nome do usuário: ");
                                            manipulacaoDeUsuario.getListaDeUsuarios().get(id).setNome(scanner.nextLine());
                                            System.out.println(manipulacaoDeUsuario.getListaDeUsuarios().get(id).toString());
                                            System.out.println();

                                        }
                                        case 8->{ //sai do menu do usuário e retorna para o menu inicial
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
                        }catch (NumberFormatException e) {
                            System.out.println("Entrada inválida!");
                            System.out.println();
                        }

                    }
                    case 3-> System.out.println("Encerrando o Codefy");
                    default -> {
                        System.out.println("Opção inválida. Escolha uma das opções listadas");
                        System.out.println();
                    }
                }
            }
    }

}
