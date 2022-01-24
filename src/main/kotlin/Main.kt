import java.util.logging.Level
import java.util.logging.LogManager

//Superclase de las armas
open class ArmaDeFuego(
    var nombre: String,
    var municion: Int,
    var municionARestar: Int,
    private var tipoDeMunicion: String,
    private var danio: Int,
    private var radio: String){

//Método que hace que un arma dispare y se heredará a las demás clases
    open fun dispara(): Int {
        this.municion =municion-municionARestar
        return municion
    }
//Método que hace que un arma dispare y se heredará a las demás clases
    open fun recarga():Int{
         this.municion +=municion
        return this.municion
    }

}
//Subclase pistola
    class Pistola(nombre: String,municion: Int,municionARestar: Int,tipoDeMunicion: String,danio: Int,radio: String):
            ArmaDeFuego(nombre,municion, municionARestar, tipoDeMunicion, danio, radio){
        //Ponemos este metodo para que al llamar al objeto salga con su nombre y no con el de la clase
        override fun toString(): String = nombre

        //A heredado el metodo dispara poniendo override delate del metodo y se a multiplicado *1 la municionARestar
        override fun dispara(): Int {
            municion =municion-(municionARestar*1)
            return municion
        }

    }
    class Rifle(nombre: String,municion: Int,municionARestar: Int,tipoDeMunicion: String,danio: Int,radio: String):
            ArmaDeFuego(nombre,municion, municionARestar, tipoDeMunicion, danio, radio){
        //Ponemos este metodo para que al llamar al objeto salga con su nombre y no con el de la clase
        override fun toString(): String = nombre
        //A heredado el metodo dispara poniendo override delate del metodo y se a multiplicado *2 la municionARestar
        override fun dispara(): Int {
            this.municion =municion-(municionARestar*2)
            return municion
        }

            }
    class Bazooka(nombre: String,municion: Int,municionARestar: Int,tipoDeMunicion: String,danio: Int,radio: String):
            ArmaDeFuego(nombre, municion, municionARestar, tipoDeMunicion, danio, radio){
        //Ponemos este metodo para que al llamar al objeto salga con su nombre y no con el de la clase
        override fun toString(): String = nombre
        //A heredado el metodo dispara poniendo override delate del metodo y se a multiplicado *3 la municionARestar
        override fun dispara(): Int {
            this.municion =municion-(municionARestar*3)
            return municion
        }

            }

fun main() {
    //Se pone la variable l para poder poner logs en vez de println
    val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }

    //Instancio 3 objetos, cada uno de una subclase distinta
    var Rk9: Pistola = Pistola("Rk9", 15, 1, "9mm", 2, "Pqueño")
    var AK47: Rifle = Rifle("AK47", 30, 3, "11mm", 3, "Amplio")
    var RPG: Bazooka = Bazooka("RPG", 15, 1, "Explosiva", 10, "Amplio")

    var listaArma = listOf<ArmaDeFuego>(Rk9, RPG, AK47)
    var mapaAleatorio = mutableMapOf<Int, ArmaDeFuego>()

    //Se hace un log para comprobar que el objeto que va a disparar es el mismo que el que dispara
    for (i in 1..6){
    var random = (0..2).random()
    mapaAleatorio.put(i,listaArma[random])
    }
    //Imprime los objetos seleccionados de forma aleatoria que van a disparar
    for (it in mapaAleatorio){
        l.info("${it.value}")

}
    println()
    //Se imprimen por pantalla los objetos que disparan y cuantas veces de forma aleatoria
    for (i in 1..6){
        println("${mapaAleatorio.get(i)?.nombre} a disparado = ${mapaAleatorio.get(i)?.dispara()}")
    }


}

