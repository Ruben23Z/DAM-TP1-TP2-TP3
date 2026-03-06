package dam.exer_vl

class Library(val name: String) {

    val books = mutableListOf<Book>() // cria-se uma lista mutável de objetos Book

    fun addBook(book: Book) {
        books.add(book)
        incrementBooks()
        println("\n Titulo: '${book.title}'por ${book.author} foi adicionado á biblioteca.")
    }

    fun borrowBook(title: String) {
        val bookDecrease = books.find { it.title == title }

        if (bookDecrease != null && bookDecrease.availableCopies > 0) {
            bookDecrease.availableCopies--
            println("\nLivro requesitado'$title' com sucesso. Nº de cópias restantes: ${bookDecrease.availableCopies}")
        } else if (bookDecrease != null && bookDecrease.availableCopies == 0) {
            println("AVISO: Livro fora de stock!")
            println("Sorry, '$title' não pode ser emprestado.")
        } else {
            println("Book '$title' não encontrado na biblio.")
        }
    }

    fun returnBook(title: String) {
        val book = books.find { it.title == title }

        if (book != null) {
            book.availableCopies++
            println("\n DEVOLUÇÃO Livro '$title' devolvido. Copias disponiveis: ${book.availableCopies}")
        } else {
            println("\nLivro '$title' não encontrado na biblio.")
        }
    }

    fun showBooks() {
        println("\n--- Catalogo da Biblioteca ---")

//        for (book in books) {
//            println("Titlo: ${book.title}, Autor: ${book.author}, Ano de publicação: ${book.publicationCategory}, nº de copias: ${book.availableCopies}")
//        }
        for (book in books) {
            println(book)
            println(book.getStorageInfo())
        }
    }

    fun searchByAuthor(author: String) {
        val results = books.filter { it.author == author }
        println("\nLivros por $author:")
        if (results.isEmpty()) {
            println("Sem livros do autor.")
        } else {
            for (book in results) {
                println("- ${book.title} (${book.publicationCategory}, ${book.availableCopies} cópias disponiveis)")
            }
        }
    }

    companion object {
        private var totalBooksCreated = 0
        fun getTotalBooksCreated(): Int {
            return totalBooksCreated
        }
        fun incrementBooks() {
            totalBooksCreated++
        }
    }
}