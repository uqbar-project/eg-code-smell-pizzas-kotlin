package ar.edu.unsam.algo2.pizzas

class Pizza {
    var tipo: String = ""
    var precio: Double = 0.0
}

class Cliente {
    var nombre: String = ""
    var vip: Boolean = false
}

interface IPedido {
    fun agregarPizza(tipo: String)
    fun calcularTotal(): Double
}

abstract class AbstractPedido : IPedido {
    protected val pizzas = mutableListOf<Pizza>()
    var cliente: Cliente? = null
}

open class Pedido : AbstractPedido() {
    var ultimaPizza = Pizza()

    override fun agregarPizza(tipo: String) {
        ultimaPizza.tipo = tipo

        val precioFugazzetta = 400.0

        if (tipo == "FUGAZZETTA") {
            ultimaPizza.precio = precioFugazzetta
        }

        if (tipo == "MUZZARELLA") {
            ultimaPizza.precio = precioFugazzetta * 0.9
        }

        if (tipo == "NAPOLITANA") {
            ultimaPizza.precio = precioFugazzetta * 0.9
        }

        pizzas.add(ultimaPizza)
    }

    override fun calcularTotal(): Double {
        var total = 0.0

        for (pizza in pizzas) {
            total += pizza.precio
        }

        if (cliente != null && cliente!!.vip) {
            total = total * 0.9
        }

        return total
    }
}

class PedidoComun : Pedido() {

    override fun agregarPizza(tipo: String) {
        val pizza = Pizza()
        pizza.tipo = tipo

        val precioFugazzetta = 400.0

        when (tipo) {
            "FUGAZZETTA" -> pizza.precio = precioFugazzetta
            "MUZZARELLA" -> pizza.precio = precioFugazzetta * 0.9
            "NAPOLITANA" -> pizza.precio = precioFugazzetta * 0.9
            else -> pizza.precio = 0.0
        }

        pizzas.add(pizza)
    }

    override fun calcularTotal(): Double {
        return calcularTotalInterno()
    }

    private fun calcularTotalInterno(): Double {
        return super.calcularTotal()
    }
}

class PedidoService {

    fun pedidosPiolas(pedidos: List<IPedido>): List<IPedido> {
        val resultado = mutableListOf<IPedido>()

        for (pedido in pedidos) {
            val total = pedido.calcularTotal()

            if (total > 500) {
                resultado.add(pedido)
            }
        }

        return resultado
    }
}
