fun printSortedUniqueNames(names: List<String?>) {
    val uniqueNames = names
        .filterNotNull()
        .distinct()
        .sorted()

    for (name in uniqueNames) {
        println(name)
    }
}

fun main() {
    val names = listOf("Alice", "Bob", null, "Charlie", "Bob", null, "Alice")
    printSortedUniqueNames(names)
}
