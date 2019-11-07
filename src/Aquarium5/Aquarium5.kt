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

    // without inline an object is created every call to myWith2
    myWith2(fish.name, object : Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    // with inline no object is created, and lambda body is inlined here
    fish.name.capitalize()

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

inline fun myWith2(name: String, block: String.() -> Unit) {

    name.block()
}