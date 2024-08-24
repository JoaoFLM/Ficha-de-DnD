import Atributos.*
import java.util.Scanner



class Personagem (
    var Nome: String,
    var ForcaPJ: Forca,
    var DestrezaPJ: Destreza,
    var ConstituicaoPJ: Constituicao,
    var InteligenciaPJ: Inteligencia,
    var CarismaPJ: Carisma,
    var SabedoriaPJ: Sabedoria,
    )
    {
        fun ComprarAtributos(atributo: Atributo, pontosGastos: Int) : Int {
            return atributo.GastarPontos(pontosGastos)
        }

        fun MostrarAtributos()
        {
            println("Atributos atuais:")
            println("Forca: ${ForcaPJ.att}")
            println("Destreza: ${DestrezaPJ.att}")
            println("Constituição: ${ConstituicaoPJ.att}")
            println("Intelingência: ${InteligenciaPJ.att}")
            println("Carisma: ${CarismaPJ.att}")
            println("Sabedoria: ${SabedoriaPJ.att}")
        }
    }