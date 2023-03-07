package tictactoe

fun main() {
    var XO = 1
    var switcher = true
    val list = Array(3) {Array(3) {' '} }
    do {
        showTable(list)
        val (a, b) = readln().split(' ')
        val a1 = a.toIntOrNull()
        val b1 = b.toIntOrNull()

        if (a1 !in 1..3 || b1 !in 1..3) {
            println("Coordinates should be from 1 to 3!")
        } else if (a1 == null || b1 == null) {
            println("You should enter numbers!")
        } else if (list[a1 - 1][b1 - 1] != ' ') {
            println("This cell is occupied! Choose another one!")
        } else {
            list[a1 - 1][b1 - 1] = if (XO % 2 != 0) 'X' else 'O'
            XO++
            switcher = possiblePosition(list)
        }
    } while (switcher)
}


fun showTable (list: Array<Array<Char>>){
    println(
        """
        ---------
        | ${list[0][0]} ${list[0][1]} ${list[0][2]} |
        | ${list[1][0]} ${list[1][1]} ${list[1][2]} |
        | ${list[2][0]} ${list[2][1]} ${list[2][2]} |
        ---------
    """.trimIndent()
    )
}

fun possiblePosition(list: Array<Array<Char>>): Boolean {
    val XO = "XO"

    for (i in XO){
        if (list[0][0] == i && list[0][1] == i && list[0][2] == i ||
            list[1][0] == i && list[1][1] == i && list[1][2] == i ||
            list[2][0] == i && list[2][1] == i && list[2][2] == i ||
            list[0][0] == i && list[1][1] == i && list[2][2] == i ||
            list[2][0] == i && list[1][1] == i && list[0][2] == i ||
            list[0][0] == i && list[1][0] == i && list[2][0] == i ||
            list[0][1] == i && list[1][1] == i && list[2][1] == i ||
            list[0][2] == i && list[1][2] == i && list[2][2] == i) {
            showTable(list)
            println("$i wins")
            return false
        }
    }
    return true
}