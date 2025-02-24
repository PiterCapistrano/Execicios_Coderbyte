package com.pitercapistrano.exercicioscoderbyte.ifElse

/*Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:

1. The username is between 4 and 25 characters.
2. It must start with a letter.
3. It can only contain letters, numbers, and the underscore character.
4. It cannot end with an underscore character.

If the username is valid then your program should return the string true, otherwise return the string false.*/

// Primeira solução

fun CodelandUsernameValidation(str: String?): Any {
    if (str == null || str.length < 4 || str.length > 25 ||
        !str.first().isLetter() ||
        str.any { !it.isLetterOrDigit() && it != '_' } ||
        str.last() == '_') {
        return false
    }
    return str
}

//! Otimização

fun CodelandUsernameValidationOtimization(str: String?): Any =
    str?.let { it.length in 4..25 && it.first().isLetter() && it.all { c -> c.isLetterOrDigit() || c == '_' } && it.last() != '_' } ?: false

fun main() {
    println(CodelandUsernameValidationOtimization(readLine()))
    println(CodelandUsernameValidation(readLine()))
}

/* Fuções de String em condicionais:

1 - first(): 
    - Descrição: Retorna o primeiro caractere de uma string.
    - Exemplo: str.first() retorna o primeiro caractere de str.

2 - last():
    - Descrição: Retorna o último caractere de uma string.
    - Exemplo: str.last() retorna o último caractere de str.

3 - length:
    - Descrição: Retorna o comprimento (número de caracteres) da String.
    - Exemplo: str.length retorna o número de caracteres na string str.

4 - isLetter():
    - Descrição: Retorna true se o caractere for uma letra (A-Z, a-z).
    - Exemplo: "a".isLetter() retorna true, e "1".isNotLetter() retorna false.

5 - isNotLetter():
    - Descrição: Retorna true se o caractere não for uma letra.
    - Exemplo: "1".isNotLetter() retorna true, e "a".isNotLetter() retorna false.

6 - isDigit():
    - Descrição: Retorna true se o caractere for um dígito (0-9).
    - Exemplo: "1".isDigit() retorna true, e "a".isDigit() retorna false.

7 - isNotDigit():
    - Descrição: Retorna true se o caractere não for um dígito.
    - Exemplo: "a".isNotDigit() retorna true, e "1".isNotDigit() retorna false.

8 - isLetterOrDigit():
    - Descrição: Retorna true se o caractere for uma letra ou um dígito.
    - Exemplo: "a".isLetterOrDigit() retorna true, e "#".isLetterOrDigit() retorna false

9 - isBlank():
    - Descrição: Retorna true se a string for vazia ou contiver apenas espaços em branco.
    - Exemplo: str.isBlank() retorna true se str contiver apenas espaços ou estiver vazia.

10 - isNotBlank():
    - Descrição: Retorna true se a string não for vazia e não contiver apenas espaços em branco.
    - Exemplo: str.isNotBlank() retorna true se str contiver algo além de espaços em branco.

11 - contains():
    - Descrição: Verifica se a string contém a sequência fornecida.
    - Exemplo: str.contains("abc") retorna true se str contiver a substring "abc".

12 - startsWith():
    - Descrição: Verifica se a string começa com a sequência fornecida.
    - Exemplo: str.startsWith("abc") retorna true se str começar com "abc".

13 - endsWith():
    - Descrição: Verifica se a string termina com a sequência fornecida.
    - Exemplo: str.endsWith("xyz") retorna true se str terminar com "xyz".

14 - substring():
    - Descrição: Retorna uma substring da string, a partir de um índice inicial (e opcionalmente, um índice final).
    - Exemplo: str.substring(2, 5) retorna uma substring de str do índice 2 até o 5.

15 - toLowerCase():
    - Descrição: Retorna a string convertida para minúsculas.
    - Exemplo: "ABC".toLowerCase() retorna "abc".

16 - toUpperCase():
    - Descrição: Retorna a string convertida para maiúsculas.
    - Exemplo: "abc".toUpperCase() retorna "ABC".

17 - trim():
    - Descrição: Retorna a string sem os espaços em branco no início e no final.
    - Exemplo: " abc ".trim() retorna "abc".

18 - replace():
    - Descrição: Substitui todas as ocorrências de um caractere ou substring por outra.
    - Exemplo: "hello".replace("l", "r") retorna "hero".

19 - split():
    - Descrição: Divide a string em várias partes com base no delimitador fornecido.
    - Exemplo: "a,b,c".split(",") retorna uma lista de substrings ["a", "b", "c"].

20 - toInt():
    - Descrição: Converte a string para um número inteiro, se possível.
    - Exemplo: "123".toInt() retorna 123.

21 - toDouble():
    - Descrição: Converte a string para um número de ponto flutuante, se possível.
    - Exemplo: "3.14".toDouble() retorna 3.14.

!Funções de Coleções (Listas, Arrays, etc.):

1 - first():
    - Descrição: Retorna o primeiro elemento de uma coleção.
    - Exemplo: listOf(1, 2, 3).first() retorna 1.

2 - last():
    - Descrição: Retorna o último elemento de uma coleção.
    - Exemplo: listOf(1, 2, 3).last() retorna 3.

3 - isEmpty():
    - Descrição: Retorna true se a coleção estiver vazia.
    - Exemplo: listOf().isEmpty() retorna true.

4 - isNotEmpty():
    - Descrição: Retorna true se a coleção não estiver vazia.
    - Exemplo: listOf(1).isNotEmpty() retorna true.

5 - contains():
    - Descrição: Verifica se um elemento está presente na coleção.
    - Exemplo: listOf(1, 2, 3).contains(2) retorna true.

6 - any():
    - Descrição: Retorna true se algum elemento da coleção satisfizer a condição fornecida.
    - Exemplo: listOf(1, 2, 3).any { it > 2 } retorna true.

7 - all():
    - Descrição: Retorna true se todos os elementos da coleção satisfizerem a condição fornecida.
    - Exemplo: listOf(1, 2, 3).all { it > 0 } retorna true.

8 - find():
    - Descrição: Retorna o primeiro elemento que corresponde à condição fornecida.
    - Exemplo: listOf(1, 2, 3).find { it > 1 } retorna 2.

9 - filter():
    - Descrição: Retorna uma nova coleção com os elementos que atendem à condição fornecida.
    - Exemplo: listOf(1, 2, 3).filter { it > 1 } retorna [2, 3].

10 - map():
    - Descrição: Retorna uma nova coleção, transformando cada elemento de acordo com a função fornecida.
    - Exemplo: listOf(1, 2, 3).map { it * 2 } retorna [2, 4, 6].
    
    */

    //! SOLUÇÃO EM JAVASCRIPT:
/*
    function CodelandUsernameValidation(str) {
        if (str == null || str.length < 4 || str.length > 25 ||
            !/^[a-zA-Z]/.test(str[0]) ||
            /[^a-zA-Z0-9_]/.test(str) ||
            str[str.length - 1] === '_') {
            return false;
        }
        return str;
    }
    
    // Otimização
    function CodelandUsernameValidationOtimization(str) {
        return str && str.length >= 4 && str.length <= 25 &&
            /^[a-zA-Z]/.test(str[0]) &&
            /^[a-zA-Z0-9_]+$/.test(str) &&
            str[str.length - 1] !== '_' ? str : false;
    }
    
    // Exemplo de uso
    console.log(CodelandUsernameValidationOtimization(prompt()));
    console.log(CodelandUsernameValidation(prompt()));

    */

    //! Explicação em JavaScript:
    /*
    1 - Verificação do primeiro caractere: Usamos uma expressão regular ^[a-zA-Z] para verificar se o primeiro 
    caractere é uma letra.
    
    2 - Verificação de caracteres válidos: Usamos a expressão regular ^[a-zA-Z0-9_]+$ para garantir que todos os 
    caracteres sejam letras, números ou underlines.

    3 - Verificação do último caractere: Comparamos o último caractere str[str.length - 1] com '_'.
    */

    //! SOLUÇÃO EM PYTHON:

    /*

    def CodelandUsernameValidation(str):
        if str is None or len(str) < 4 or len(str) > 25 or not str[0].isalpha() or any(not (c.isalnum() or c == '_') for c in str) or str[-1] == '_':
            return False
        return str

    # Otimização
    def CodelandUsernameValidationOtimization(str):
        return str if str and 4 <= len(str) <= 25 and str[0].isalpha() and all(c.isalnum() or c == '_' for c in str) and str[-1] != '_' else False

    # Exemplo de uso
    print(CodelandUsernameValidationOtimization(input()))
    print(CodelandUsernameValidation(input()))
    
    */

    //! Explicações em Python:

    /*
    1 - Verificação do primeiro caractere: Usamos str[0].isalpha() para verificar se o primeiro caractere é uma 
    letra.
    
    2 - Verificação de caracteres válidos: Usamos uma expressão all(c.isalnum() or c == '_' for c in str) para 
    garantir que todos os caracteres sejam letras, números ou underlines.
    
    3 - Verificação do último caractere: Verificamos str[-1] == '_' para garantir que o último caractere não seja 
    um underline.
    
    */

    //! SOLUÇÃO EM PORTUGOL:

   /* 
funcao CodelandUsernameValidation(str: cadeia) : qualquercoisa
inicio
    se (str = nulo ou comprimento(str) < 4 ou comprimento(str) > 25 ou nao eLetra(str[0]) ou existe(caractere em str onde nao eAlfanumerico(caractere) e caractere <> "_") ou str[comprimento(str) - 1] = "_") entao
        retorne Falso
    fimse
    retorne str
fimalgoritmo

// Otimização
funcao CodelandUsernameValidationOtimization(str: cadeia) : qualquercoisa
inicio
    se (str <> nulo e comprimento(str) >= 4 e comprimento(str) <= 25 e eLetra(str[0]) e todos(caractere em str onde eAlfanumerico(caractere) ou caractere = "_") e str[comprimento(str) - 1] <> "_") entao
        retorne str
    senao
        retorne Falso
    fimse
fimalgoritmo

algoritmo principal
inicio
    escreva(CodelandUsernameValidationOtimization(leia()))
    escreva(CodelandUsernameValidation(leia()))
fimalgoritmo
*/

    //! Explicações em Portugol:

    /*
    1 - Verificação do primeiro caractere: Utilizamos a função eLetra() para verificar se o primeiro caractere é 
    uma letra.
    
    2 - Verificação de caracteres válidos: Usamos a função todos() para garantir que todos os caracteres sejam 
    alfanuméricos ou underlines.

    3 - Verificação do último caractere: Verificamos se o último caractere é um underline, usando 
    str[comprimento(str) - 1].
    
    */