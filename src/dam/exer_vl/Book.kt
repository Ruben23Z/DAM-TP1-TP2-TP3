package dam.exer_vl

abstract class Book(
    val title: String, val author: String, val publicationYear: Int, availableCopies: Int
    //val publicationYear: Int, var availableCopies: Int
) {

    init {
        println("\n Criação do livro de Titulo: '$title' por $author, ano $publicationYear ($publicationCategory), com $availableCopies cópias disponíveis.")
    }

    //
//    fun getpublicationYear(): String {
//        if (publicationYear < 1980) return "Classic"
//        else if (publicationYear in 1980..2010) return "Modern"
//        else return "Contemporary"
//    }
    val publicationCategory: String
        get() = when {
            publicationYear < 1980 -> "Classic"
            publicationYear in 1980..2010 -> "Modern"
            else -> "Contemporary"
        }

    var availableCopies: Int = availableCopies
        set(value) {
            if (value < 0) {
                println("\nErro: Não é possível definir um número negativo de cópias.")
            } else {
                if (field == 0) {
                    print("\nAVISO->  Livro '$title' está fora de stock")
                }
                field = value
            }
        }

    override fun toString(): String {
        return " \n Título: $title, Autor: $author, Ano: $publicationYear, Categoria: $publicationCategory, Cópias: $availableCopies"
    }
    abstract fun getStorageInfo(): String
}