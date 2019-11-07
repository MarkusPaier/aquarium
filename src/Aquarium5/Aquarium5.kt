package Aquarium5

/*
 * scope functions -> let, run, with, apply, also
 * are for objects
 */

data class Fish(var name: String)

fun main(args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

//    with(fish.name) {
//        capitalize()
//    }

    myWith(fish.name) {
        println(capitalize())
    }

    println(fish.run { name })  // run returns the result of the block function
    println(fish.apply { })    // apply returns the object of the block function

    val fish2: Fish = Fish(name = "splashy").apply { name = "Sharky" }
    println(fish2.name)

    println(fish.let { it.name.capitalize() }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })
}

fun myWith(name: String, block: String.() -> Unit) {

    name.block()
}