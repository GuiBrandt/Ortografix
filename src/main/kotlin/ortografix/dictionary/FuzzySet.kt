package ortografix.dictionary

typealias FuzzyScore = Double

// TODO: Documentação
data class FuzzyMatch<T>(val match: T, val score: FuzzyScore) : Comparable<FuzzyMatch<T>> {

    // TODO: Documentação
    public override operator fun compareTo(other: FuzzyMatch<T>): Int = score.compareTo(other.score)
}

// TODO: Documentação
data class FuzzyMatches<T>(val matches: Collection<FuzzyMatch<T>>) : Iterable<FuzzyMatch<T>> {

    // TODO: Documentação
    val best : T?
        get() = matches.maxBy { it.score }?.match

    public override operator fun iterator() = matches.iterator()
}

// TODO: Documentação
interface IFuzzySet<T> {
    
    // TODO: Documentação
    public fun get(value: T, threshold: FuzzyScore = 0.6): FuzzyMatches<T>
    
    // TODO: Documentação
    public fun add(value: T)

    // TODO: Documentação
    public fun contains(value: T): FuzzyScore
    
    // TODO: Documentação
    public fun find(value: T): T?
}