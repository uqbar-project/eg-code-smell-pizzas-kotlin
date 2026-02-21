# 🧾 Ejercicio: Sistema de Pedidos de una Pizzería

Una pizzería necesita un sistema para gestionar sus pedidos. 

El objetivo de este ejercicio es  con varios problemas de diseño (code smells), para luego poder analizarlos y refactorizarlos.

⚠️ **Importante**:  
Este ejercicio **no busca una buena solución**, sino una que funcione pero esté mal diseñada.

---

## 📌 Requisitos funcionales

El sistema debe permitir:

1. Crear pedidos
2. Asociar un cliente a un pedido
3. Agregar pizzas a un pedido
4. Calcular el total del pedido
5. Cambiar el estado del pedido
6. Obtener los **pedidos piolas**

---

## 🍕 Tipos de pizza y precios

La **Fugazzetta** tiene como precio **$400**

Otras pizzas se calculan **en función del precio de la fugazzetta**:

- Muzzarella: **90% del precio de la fugazzetta**
- Napolitana: **90% del precio de la fugazzetta**

---

## 😎 Pedidos piolas

Un pedido se considera **piola** si su total es **mayor a $500**.
