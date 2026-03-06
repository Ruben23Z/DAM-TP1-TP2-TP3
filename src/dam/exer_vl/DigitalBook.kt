package dam.exer_vl

class DigitalBook(
    title: String, author: String, publicationYear: Int, availableCopies: Int, val fileSize: Double, val format: String)
    : Book(title, author, publicationYear, availableCopies) { // constructor da classe DigitalBook, que herda da classe Book


    override fun toString(): String {
        return "DigitalBook: ${super.toString()}"
    }
    override fun getStorageInfo(): String {
        return "Storage: Digitalmente guardado: $fileSize MB, Formato: $format"
    }
}