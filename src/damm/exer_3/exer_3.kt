package damm.exer_3

fun main() {
    val height = 1000.0
    val seq = generateSequence(height) {
        if (it*0.6  >= 1.0) it * 0.6
        else null
    }
    println("alturas da bola ${seq.take(15).joinToString("| ") { "%.2f".format(it) }}")
}