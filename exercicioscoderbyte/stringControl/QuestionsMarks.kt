

/*
!   Questions Marks

Have the function QuestionsMarks(str) take the str string parameter, which will contain single digit 
numbers, letters, and question marks, and check if there are exactly 3 question marks between every pair 
of two numbers that add up to 10. If so, then your program should return the string true, otherwise it 
should return the string false. If there aren't any two numbers that add up to 10 in the string, then your 
program should return false as well.

For example: if str is "arrb6???4xxbl5???eee5" then your program should return true because there are 
exactly 3 question marks between 6 and 4, and 3 question marks between 5 and 5 at the end of the string.


Faça com que a função QuestionsMarks(str) receba o parâmetro de string str, que conterá um único dígito 
números, letras e pontos de interrogação e verifique se há exatamente 3 pontos de interrogação entre cada par 
de dois números que somam 10. Nesse caso, seu programa deve retornar a string true, caso contrário, 
deve retornar a string falsa. Se não houver dois números que somam 10 na string, então seu 
o programa também deve retornar falso.

Por exemplo: se str for "arrb6???4xxbl5???eee5" então seu programa deverá retornar verdadeiro porque existem 
exatamente 3 pontos de interrogação entre 6 e 4 e 3 pontos de interrogação entre 5 e 5 no final da string.
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

/*
!       DETALHES DA FUNÇÃO:

!    Variáveis de Controle:

    var lastNum = -1
    var questionCount = 0
    var hasPair = false

- lastNum = -1: Variável usada para armazenar o último número encontrado na string. Inicializamos com -1 
porque ainda não encontramos nenhum número.

- questionCount = 0: Variável que conta quantos sinais de interrogação (?) existem entre dois números 
consecutivos.

- hasPair = false: Variável booleana usada para indicar se existe pelo menos um par de números cuja soma 
seja 10 e que tenha exatamente 3 ? entre eles.

!    Laço de Repetiçao:

    for (i in str.indices) {
    val char = str[i]

- for (i in str.indices): Um loop que percorre a string str de índice 0 até o final. A variável i 
representa o índice de cada caractere na string.

- val char = str[i]: A variável char armazena o caractere atual da string em cada iteração do loop.

!    Verificação de Números:

    if (char.isDigit()) {
        val num = char.toString().toInt()

- if (char.isDigit()): Verifica se o caractere atual é um número. A função isDigit() retorna true se o 
caractere for um dígito (0-9).

- val num = char.toString().toInt(): Se o caractere for um número, ele é convertido para um inteiro. O 
método toString() converte o caractere em uma string, e o método toInt() converte essa string para um 
número inteiro.

!     Verificação da Soma dos Números:

if (lastNum != -1 && lastNum + num == 10 && questionCount == 3) {
    hasPair = true
} else if (lastNum + num == 10) {
    return "false"
}

1 - if (lastNum != -1 && lastNum + num == 10 && questionCount == 3):

    Verifica se:

     - Já encontramos um número anterior (lastNum != -1).
     - A soma do número anterior (lastNum) com o número atual (num) é igual a 10 (lastNum + num == 10).
     - Existe exatamente 3 ? entre os dois números (questionCount == 3).

    - Se todas essas condições forem verdadeiras, significa que encontramos um par de números que somam 10 
    e têm exatamente 3 ? entre eles. Nesse caso, definimos hasPair = true.

2 - else if (lastNum + num == 10):

     - Caso a soma dos números seja 10, mas a contagem de ? não seja 3, retornamos imediatamente "false", 
     pois a condição do desafio não é atendida.

!       Resetando a Contagem e Atualizando o Número:

questionCount = 0
lastNum = num

     - questionCount = 0: Após encontrar um número, resetamos a contagem de ? para iniciar a contagem entre 
    o próximo par de números.

     - lastNum = num: Atualizamos lastNum com o número atual (num) para usá-lo na próxima iteração, caso 
    outro número seja encontrado.

!       Contabilizando os Sinais de Interrogação:

else if (char == '?') {
    questionCount++
}

     - else if (char == '?'): Se o caractere atual for um sinal de interrogação (?), incrementamos a variável 
    questionCount, que mantém o controle de quantos sinais de interrogação estão entre os números.

!       Verificação Final:

     - if (hasPair) "true" else "false": Após o laço, se a variável hasPair for true, significa que 
    encontramos pelo menos um par de números cujas somas são 10 e que têm exatamente 3 ? entre eles. 
    Nesse caso, a função retorna "true".

     - Se não encontramos tal par, a função retorna "false".

!       Resumo do Fluxo de Execução:

    1 - O código percorre a string caractere por caractere.

    2 - Quando encontra um número, verifica se a soma do número atual com o anterior é 10 e se existe 
    exatamente 3 ? entre eles.

    3 - Se a soma for 10 e a quantidade de ? for 3, marca que encontramos um par válido.

    4 - Se a soma for 10, mas a quantidade de ? não for 3, retorna "false".

    5 - Após percorrer toda a string, se encontrou pelo menos um par válido, retorna "true", caso 
    contrário, retorna "false".

!       Exemplo de Execução:

Para o input "acc?7??sss?3rr1??????5", o código verifica que:

    - Há exatamente 3 ? entre 7 e 3 (não soma 10).

    - Há exatamente 3 ? entre 3 e 1 (não soma 10).

    - Encontra 5 e 5, com exatamente 3 ? entre eles, e retorna true.
 */