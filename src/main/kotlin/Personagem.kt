import Atributos.*
import Raças.Raca
import java.util.Scanner



class Personagem (
    var Nome: String,
    var ForcaPJ: Forca,
    var DestrezaPJ: Destreza,
    var ConstituicaoPJ: Constituicao,
    var InteligenciaPJ: Inteligencia,
    var CarismaPJ: Carisma,
    var SabedoriaPJ: Sabedoria,
    var Raca: Raca
    )
    {
        fun ComprarAtributos(atributo: Atributo, pontosGastos: Int) : Int {
            return atributo.GastarPontos(pontosGastos)
        }

        fun MostrarAtributos()
        {
            println("## Atributos ##")
            println("Forca: ${ForcaPJ.att}")
            println("Destreza: ${DestrezaPJ.att}")
            println("Constituição: ${ConstituicaoPJ.att}")
            println("Intelingência: ${InteligenciaPJ.att}")
            println("Carisma: ${CarismaPJ.att}")
            println("Sabedoria: ${SabedoriaPJ.att}")
        }

        private fun CalculaPV(Constituicao: Int) : Int? {
            val PVbase = 10
            when (Constituicao){
                8 -> return PVbase-1
                9 -> return PVbase-1
                10 -> return PVbase+0
                11 -> return PVbase+0
                12 -> return PVbase+1
                13 -> return PVbase+1
                14 -> return PVbase+2
                15 -> return PVbase+2
                16 -> return PVbase+3
                17 -> return PVbase+3
                18 -> return PVbase+4
                19 -> return PVbase+4
                20 -> return PVbase+5
            }
            return null
        }

        fun AdicionaRaca(){
            this.ForcaPJ.att+=this.Raca.IncrementoForca
            this.DestrezaPJ.att+=this.Raca.IncrementoDestreza
            this.ConstituicaoPJ.att+=this.Raca.IncrementoConstituicao
            this.InteligenciaPJ.att+=this.Raca.IncrementoInteligencia
            this.SabedoriaPJ.att+=this.Raca.IncrementoSabedoria
            this.CarismaPJ.att+=this.Raca.IncrementoCarisma
        }

        fun MostarPersonagem()
        {
            println("## $Nome ##")
            println("Pontos de Vida: ${CalculaPV(this.ConstituicaoPJ.att)}")
            println("Raca ${Raca.RacaNome}")
            this.MostrarAtributos()

        }
    }