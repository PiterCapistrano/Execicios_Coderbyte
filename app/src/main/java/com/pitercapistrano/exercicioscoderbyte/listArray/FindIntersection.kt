package com.pitercapistrano.exercicioscoderbyte.listArray

/*
!Find Intersection
Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 
elements: the first element will represent a list of comma-separated numbers sorted in ascending order, the 
second element will represent a second list of comma-separated numbers (also sorted). Your goal is to return a 
comma-separated string containing the numbers that occur in elements of strArr in sorted order. If there is no 
intersection, return the string false.
*/

fun FindIntersection(strArr: Array<String>): String {
  val list1 = strArr[0].split(", ").map { it.toInt() }
  val list2 = strArr[1].split(", ").map { it.toInt() }

  val intersection = list1.intersect(list2).sorted()

  // code goes here  
  return if(intersection.isEmpty()) {
    "false"
  }else {
    intersection.joinToString(",")
  };
  
}

fun main() {
  println(FindIntersection(readLine()))
}

/*
!   DETALHAMENTO DO CÓDIGO:

1. Função split(", "):

val list1 = strArr[0].split(", ").map { it.toInt() }

e

val list2 = strArr[0].split(", ").map { it.toInt() }

- strArr[0]: Acessa o primeiro elemento do array strArr, que é uma string representando uma lista de números 
separados por vírgulas, por exemplo "1, 3, 4, 7, 13".

- split(", "): A função split divide a string em substrings, usando a vírgula seguida de um espaço (, ) como 
delimitador. O resultado será uma lista de substrings (strings), como ["1", "3", "4", "7", "13"].

- map { it.toInt() }: A função map é aplicada a cada elemento da lista de substrings. Para cada elemento, a função 
toInt() converte a string em um número inteiro. Assim, a lista se torna [1, 3, 4, 7, 13].

2 -  Função intersect(list2):

val intersection = list1.intersect(list2).sorted()

- list1.intersect(list2): A função intersect é usada para encontrar a interseção entre list1 e list2, ou seja, os 
elementos que aparecem em ambas as listas. O resultado será um conjunto (Set) contendo apenas os números que são 
comuns nas duas listas.

  - Exemplo: Se list1 = [1, 3, 4, 7, 13] e list2 = [1, 2, 4, 13, 15], a interseção será {1, 4, 13}.

- .sorted(): A função sorted() ordena os elementos do conjunto (Set) em ordem crescente. Como Set não garante a 
ordem dos elementos, usamos sorted() para garantir que o resultado seja uma lista ordenada. O resultado de 
intersection será [1, 4, 13] para o exemplo acima.  

3 - Estrutura condicional if:

return if(intersection.isEmpty()) {
    "false"
} else {
    intersection.joinToString(",")
}

- intersection.isEmpty(): Verifica se a lista de interseção está vazia. A função isEmpty() retorna true se a lista 
não contiver nenhum elemento.

  - Caso a interseção seja vazia (ou seja, não há números em comum entre as duas listas), a função retornará "false".

  - Caso contrário, executará o bloco dentro do else.

- intersection.joinToString(","): A função joinToString(",") é usada para transformar a lista de interseção em uma 
string, onde cada número é separado por uma vírgula. Por exemplo, a lista [1, 4, 13] se tornará a string "1,4,13". 
Essa string é retornada como o resultado da função.
  */