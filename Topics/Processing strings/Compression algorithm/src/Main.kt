fun main() {
    val str = readln()
    println(compressString(str))
}

fun compressString(input: String): String {
    

    var builder = ""
    var count = 1
    var lastChar = input[0]

    for (i in 1 until input.length) {
        if (input[i] == lastChar) {
            count++
        } else {
            builder += lastChar
            builder += count
            count = 1
            lastChar = input[i]
        }
    }

    builder += lastChar
    builder += count

    return builder.toString()
}