open class Animal {
    open fun look() {
        println("Animal is looking.")
    }

    open fun eat() {
        println("Animal is eating.")
    }

    open fun move() {
        println("Animal is moving.")
    }
}

class Mammal : Animal() {
    override fun look() {
        println("Mammal is looking.")
    }

    override fun eat() {
        println("Mammal is eating.")
    }

    override fun move() {
        println("Mammal is moving.")
    }
}

class Bird : Animal() {
    override fun look() {
        println("Bird is looking.")
    }

    override fun eat() {
        println("Bird is eating.")
    }

    override fun move() {
        println("Bird is moving.")
    }
}

class Fish : Animal() {
    override fun look() {
        println("Fish is looking.")
    }

    override fun eat() {
        println("Fish is eating.")
    }

    override fun move() {
        println("Fish is moving.")
    }
}

fun main() {
    val lion = Mammal()
    val eagle = Bird()
    val shark = Fish()

    lion.look()
    lion.eat()
    lion.move()

    eagle.look()
    eagle.eat()
    eagle.move()

    shark.look()
    shark.eat()
    shark.move()
}
