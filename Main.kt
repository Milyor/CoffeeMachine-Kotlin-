package machine

import kotlin.system.exitProcess

class CoffeeMaker{
    class Supplies(
        var water: Int,
        var milk: Int,
        var coffee: Int,
        var cups: Int,
        var money: Int
    )

    private fun buyCoffee(
        supplies: Supplies,
        waterNeeded: Int,
        milkNeeded: Int,
        coffeeNeeded: Int,
        moneyNeeded: Int,
        cupsNeeded: Int
    ) {
        if (supplies.water >= waterNeeded && supplies.milk >= milkNeeded && supplies.coffee >= coffeeNeeded &&
            supplies.cups >= cupsNeeded && supplies.money >= moneyNeeded
        ) {
            println("I have enough resources, making you a coffee!")
            supplies.water -= waterNeeded
            supplies.milk -= milkNeeded
            supplies.coffee -= coffeeNeeded
            supplies.cups -= cupsNeeded
            supplies.money += moneyNeeded
            println()
        } else {
            printMissingResources(supplies)
        }
    }

    fun take(supplies: Supplies) {
        println("I gave you $${supplies.money}")
        val takeAmount = supplies.money
        supplies.money -= takeAmount
        println()
    }

    fun fillMachine(supplies: Supplies) {
        println("Write how many ml of water you want to add:")
        val addedWater = readln().toInt()
        supplies.water += addedWater
        println("Write how many ml of milk you want to add: ")
        supplies.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        supplies.coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        supplies.cups += readln().toInt()
        println()
    }

    private fun printMissingResources(supplies: Supplies) {
        if (supplies.water == 0) println("Sorry, not enough water!")
        if (supplies.milk == 0) println("Sorry, not enough milk!")
        if (supplies.coffee == 0) println("Sorry, not enough coffee!")
        if (supplies.cups == 0) println("Sorry, not enough cups")
        if (supplies.money == 0) println("Sorry, not enough Money")
    }

    fun printStatus(supplies: Supplies) {
        println(
            "The coffee machine has:\n" +
                    "${supplies.water} ml of water\n" +
                    "${supplies.milk} ml of milk\n" +
                    "${supplies.coffee} g of coffee beans\n" +
                    "${supplies.cups} disposable cups\n" +
                    "$${supplies.money} of money\n"
        )
        println()
    }

    fun exit() {
        exitProcess(0)
    }

    fun buy(supplies: Supplies) {
        println()
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val type = readln()
        if (type == "back") return
        when (type) {
            "1" -> buyCoffee(supplies, 250, 0, 16, 4, 1)
            "2" -> buyCoffee(supplies, 350, 75, 20, 7, 1)
            "3" -> buyCoffee(supplies, 200, 100, 12, 6, 1)
            else -> return
        }
    }
}
    fun main() {
        var switch = 1
        val supplies = CoffeeMaker.Supplies(water = 400, milk = 540, coffee = 120, cups = 9, money = 550)
        val coffeeMaker = CoffeeMaker()
        do {
            println("Write action (buy, fill, take, remaining, exit):")
            val action = readln().toLowerCase()
            when (action) {
                "buy" -> coffeeMaker.buy(supplies)
                "fill" -> coffeeMaker.fillMachine(supplies)
                "take" -> coffeeMaker.take(supplies)
                "remaining" -> coffeeMaker.printStatus(supplies)
                "exit" -> coffeeMaker.exit()

                else -> switch++
            }
        } while (switch != 2)

    }




