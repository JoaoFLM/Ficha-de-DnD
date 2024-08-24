package Atributos

class Forca (var att: Int = 8) : Atributo(att)  {
    override fun GastarPontos(pontos: Int) : Int  {
        if(pontos in 8..15)
        {
            var pontosGastos: Int = 0;

            when (pontos) {
                8  -> pontosGastos = 0
                9  -> pontosGastos = 1
                10 -> pontosGastos = 2
                11 -> pontosGastos = 3
                12 -> pontosGastos = 4
                13 -> pontosGastos = 5
                14 -> pontosGastos = 7
                15 -> pontosGastos = 9
            }

            this.att = pontos
            return pontosGastos
        }
        else {
            throw IllegalArgumentException()
        }
    }
}