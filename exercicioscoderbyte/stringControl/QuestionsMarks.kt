

/*
!   Questions Marks

Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit 
numbers, letters, and question marks, and check if there are exactly 3 question marks between every pair 
of two numbers that add up to 10. If so, then your program should return the string true, otherwise it 
should return the string false. If there aren't any two numbers that add up to 10 in the string, then your 
program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are 
exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.
*/

fun QuestionsMarks(str: String): String {
var lastNum = -1
var questionCount = 0
var hasPair = false

for (i in str.indices) {
    val char = str[i]

    // Quando encontramos um nÃºmero
    if (char.isDigit()) {
        val num = char.toString().toInt()

        // Se jÃ¡ encontramos um nÃºmero anterior, verificamos a soma e a quantidade de '?'
        if (lastNum != -1 && lastNum + num == 10 && questionCount == 3) {
            hasPair = true
        } else if (lastNum + num == 10) {
            // Se a soma Ã© 10, mas o nÃºmero de '?' nÃ£o Ã© 3, retorna false
            return "false"
        }

        // Resetamos a contagem de '?'
        questionCount = 0
        lastNum = num
    }
    // Contabilizamos os '?'
    else if (char == '?') {
        questionCount++
    }
}

// Se nÃ£o encontramos nenhum par de nÃºmeros que somam 10, ou nÃ£o havia 3 '?' entre eles, retorna "false"
return if (hasPair) "true" else "false"
}

fun main() {
println(QuestionsMarks(readLine()))
}