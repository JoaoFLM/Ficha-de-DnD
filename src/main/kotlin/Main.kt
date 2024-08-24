import Atributos.*
import java.util.*
import kotlin.system.exitProcess


fun main() {
    println("## Criação de personagem ##");
    println("Digite o nome do personagem")
    val EscolhaAUX  = Scanner(System.`in`)
    val nome = EscolhaAUX.nextLine()
    var PJ = Personagem(
            nome,
            Forca(),
            Destreza(),
            Constituicao(),
            Inteligencia(),
            Carisma(),
            Sabedoria())

    var pontos: Int = 0;
    while(true){
        PJ.MostrarAtributos()
        println("Escolha qual atributo deseja gastar pontos:")
        println("Forca: [1]")
        println("Destreza: [2]")
        println("Constituição: [3]")
        println("Inteligência: [4]")
        println("Sabedoria: [5]")
        println("Carisma: [6]")
        println("Sair [0]")
        println("## Pontos restantes: $pontos/27 ##")
        val attAUX: Int = EscolhaAUX.nextInt()

        println("Digite o valor do atributo")
        val pontoAUX: Int = EscolhaAUX.nextInt()

        when(attAUX){
            1 -> pontos += PJ.ComprarAtributos(PJ.ForcaPJ, pontoAUX)
            2 -> pontos += PJ.ComprarAtributos(PJ.DestrezaPJ, pontoAUX)
            3 -> pontos += PJ.ComprarAtributos(PJ.ConstituicaoPJ, pontoAUX)
            4 -> pontos += PJ.ComprarAtributos(PJ.InteligenciaPJ, pontoAUX)
            5 -> pontos += PJ.ComprarAtributos(PJ.SabedoriaPJ, pontoAUX)
            6 -> pontos += PJ.ComprarAtributos(PJ.CarismaPJ, pontoAUX)
            0 -> exitProcess(0)
            else -> println("Atributo não encontrado");
        }
    }
}