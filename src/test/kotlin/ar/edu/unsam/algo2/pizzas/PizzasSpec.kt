package ar.edu.unsam.algo2.pizzas

import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PizzasSpec : DescribeSpec({
    isolationMode = IsolationMode.InstancePerTest

    describe("dado un pedido de pizza") {
        val pedido = PedidoComun().apply {
            cliente = Cliente().apply {
                nombre = "Juan"
                vip = false
            }
        }
        it("costo de fugazzetta") {
            pedido.agregarPizza("FUGAZZETTA")
            pedido.calcularTotal() shouldBe 400.0
        }
        it("costo de muzzarella") {
            pedido.agregarPizza("MUZZARELLA")
            pedido.calcularTotal() shouldBe 360.0
        }
        it("costo de napolitana") {
            pedido.agregarPizza("NAPOLITANA")
            pedido.calcularTotal() shouldBe 360.0
        }
        it("para un cliente vip hay descuento") {
            pedido.cliente = Cliente().apply {
                nombre = "Francisca"
                vip = true
            }
            pedido.agregarPizza("MUZZARELLA")
            pedido.calcularTotal() shouldBe 324.0 // o podría ser 360 * 0.9
        }
    }

    describe("dada una lista de pedidos") {
        it("podemos determinar cuáles son piolas") {
            val pedidosPiolas = PedidoService().pedidosPiolas(listOf(
                    PedidoComun().apply {
                        agregarPizza("MUZZARELLA")
                        agregarPizza("FUGAZZETTA")
                    },
                    PedidoComun().apply {
                        agregarPizza("MUZZARELLA")
                    },
                    PedidoComun().apply {
                        agregarPizza("NAPOLITANA")
                        agregarPizza("MUZZARELLA")
                        agregarPizza("FUGAZZETTA")
                    },
                )
            )
            pedidosPiolas.size shouldBe 2
        }
    }

})