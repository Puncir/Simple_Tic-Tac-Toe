
fun main() {
    val nLine = readln().toInt()
    var minimum = 0
    val list = mutableListOf<Int>()
    repeat(nLine){
        val numbers = readln().toInt()
        list.add(numbers)
    }
    println(list.minOrNull())
    /*for (i in list) {
        minimum = if (i < minimum) i else minimum
    }
    println(minimum)

     */
}