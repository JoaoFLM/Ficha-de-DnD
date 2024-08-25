import Atributos.*
import Raças.*
import java.util.*
import kotlin.system.exitProcess


fun main() {
    println("## Criação de personagem ##")
    println("Digite o nome do personagem:")
    val scanner = Scanner(System.`in`)
    val nome = scanner.nextLine()

    println("Primeiro escolha a sua Raça:")
    var raca: Raca? = null
    var flag: Boolean
    do {
        println("Anao Da Colina [1]")
        println("Anao Da Montanha [2]")
        println("Alto Elfo [3]")
        println("Elfo da Floresta [4]")
        println("Drow [5]")
        println("Hafling Pes Leves [6]")
        println("Hafling Robusto [7]")
        println("Humano [8]")
        println("Gnomo da Floresta [9]")
        println("Gnomo das Rochas [10]")
        println("Draconato [11]")
        println("Meio-Elfo [12]")
        println("Meio-Orc [13]")
        println("Tiefling [14]")

        val escolhaRaca = scanner.nextInt()
        raca = when (escolhaRaca) {
            1 -> AnaoDaColina()
            2 -> AnaoDaMontanha()
            3 -> AltoElfo()
            4 -> ElfoDaFloresta()
            5 -> Drow()
            6 -> HaflingPesLeves()
            7 -> HaflingRobusto()
            8 -> Humano()
            9 -> GnomoDaFloresta()
            10 -> GnomoDasRochas()
            11 -> Draconato()
            12 -> MeioElfo()
            13 -> MeioOrc()
            14 -> Tiefling()
            else -> {
                println("Opção inválida. Tente novamente.")
                null
            }
        }
        flag = raca == null
    } while (flag)

    val personagem = Personagem(
        nome,
        Forca(),
        Destreza(),
        Constituicao(),
        Inteligencia(),
        Carisma(),
        Sabedoria(),
        raca!!
    )

    var pontos = 0
    val maxPontos = 27

    while (true) {
        personagem.MostrarAtributos()
        println("Escolha qual atributo deseja gastar pontos:")
        println("Força: [1]")
        println("Destreza: [2]")
        println("Constituição: [3]")
        println("Inteligência: [4]")
        println("Sabedoria: [5]")
        println("Carisma: [6]")
        println("## Pontos restantes: ${maxPontos - pontos}/$maxPontos ##")

        val escolhaAtributo = scanner.nextInt()

        println("Digite o valor do atributo:")
        val valorAtributo = scanner.nextInt()

        when (escolhaAtributo) {
            1 -> pontos += personagem.ComprarAtributos(personagem.ForcaPJ, valorAtributo)
            2 -> pontos += personagem.ComprarAtributos(personagem.DestrezaPJ, valorAtributo)
            3 -> pontos += personagem.ComprarAtributos(personagem.ConstituicaoPJ, valorAtributo)
            4 -> pontos += personagem.ComprarAtributos(personagem.InteligenciaPJ, valorAtributo)
            5 -> pontos += personagem.ComprarAtributos(personagem.SabedoriaPJ, valorAtributo)
            6 -> pontos += personagem.ComprarAtributos(personagem.CarismaPJ, valorAtributo)
            else -> println("Atributo não encontrado")
        }

        if (pontos > maxPontos) {
            println("Limite de pontos ultrapassado")
            pontos -= valorAtributo
        } else if (pontos == maxPontos) {
            personagem.AdicionaRaca()
            break
        }
    }
    personagem.MostarPersonagem()
    scanner.close()
}
