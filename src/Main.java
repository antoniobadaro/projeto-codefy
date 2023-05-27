import com.codefy.colecoesdereproducao.Playlist;
import com.codefy.usuario.Usuario;

import java.util.List;
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















        //TELA DE MENU
        System.out.println("*** BEM-VINDO AO CODEFY ***");
        System.out.println("Entre ou crie uma conta!\n");


            System.out.println("O que deseja fazer? Escolha uma das opções abaixo:");
            System.out.println("""
                    1-Criar conta
                    2-Entrar em uma conta existente""");
            Scanner scanner = new Scanner(System.in);
            int opcao = Integer.parseInt(scanner.nextLine()); //variável que recebe a opção escolhida pelo usuário
            switch (opcao) { //switch case para executar a opção escolhida no menu
                case 1 -> {

                }
                case 2 -> {

                }
            }
    }

}
