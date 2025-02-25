/*
!     First Reverse

Have the function FirstReverse(str) take the str parameter being passed and return the string in reversed 
order. For example: if the input string is "Hello World and Coders" then your program should return the 
string sredoC dna dlroW olleH.


Faça com que a função FirstReverse(str) pegue o parâmetro str que está sendo passado e retorne a string invertida 
ordem. Por exemplo: se a string de entrada for "Hello World and Coders", então seu programa deverá retornar o 
string sredoC dna dlroW olleH.

*/

fun FirstReverse(str: String): String {
   
  // code goes here  
  return str.reversed();
  
}

fun main() {
  println(FirstReverse(readLine()))
}

/*
 - reversed(): Inverte a string e retorna uma nova string com os caracteres em ordem reversa.

 - A função FirstReverse usa essa função para inverter a string fornecida como entrada e retornar o 
 resultado.


!     Construção da função reversed():
*/

fun customReversed(str: String): String {
  // Usando um StringBuilder para construir a string invertida
  val reversedString = StringBuilder()
  
  // Iterando pelos caracteres da string original de trás para frente
  for (i in str.length - 1 downTo 0) {
      reversedString.append(str[i])
  }
  
  // Retorna a string invertida como uma string
  return reversedString.toString()
}

/*
!     Explicação:

1 - StringBuilder:

- A classe StringBuilder é usada para construir a nova string. Ela é eficiente porque modifica a sequência de
caracteres sem criar novos objetos toda vez que um caractere é adicionado, o que é mais rápido do que 
concatenar strings diretamente.

2 - Laço de Iteração:

- O laço for (i in str.length - 1 downTo 0) começa no último índice da string (str.length - 1) e vai até o 
índice 0, com decremento a cada iteração (downTo).
- A cada iteração, o caractere str[i] é adicionado ao StringBuilder usando append().

3 - Retorno:

- Após completar o laço e adicionar todos os caracteres ao StringBuilder, a função toString() é chamada 
para converter o StringBuilder em uma string e retornar o resultado.


!   Construção da função StringBuilder():
*/

class SimpleStringBuilder {
  private val charArray: CharArray
  private var size: Int = 0

  // Construtor que cria um array com tamanho inicial
  constructor(capacity: Int) {
      charArray = CharArray(capacity)
  }

  // Construtor padrão
  constructor() : this(16) // Default capacity is 16

  // Adiciona um caractere ao StringBuilder
  fun append(c: Char): SimpleStringBuilder {
      if (size == charArray.size) {
          resizeArray()  // Aumenta o tamanho do array quando necessário
      }
      charArray[size] = c
      size++
      return this
  }

  // Método para adicionar uma String
  fun append(str: String): SimpleStringBuilder {
      for (ch in str) {
          append(ch)
      }
      return this
  }

  // Redimensiona o array quando ele atinge o limite
  private fun resizeArray() {
      val newArray = CharArray(charArray.size * 2)
      System.arraycopy(charArray, 0, newArray, 0, charArray.size)
      charArray = newArray
  }

  // Retorna a String formada pelo StringBuilder
  fun toString(): String {
      return String(charArray, 0, size)
  }
}
