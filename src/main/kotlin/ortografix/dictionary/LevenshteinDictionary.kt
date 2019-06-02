package ortografix.dictionary
import java.util.*

// TODO: Documentação
class LevenshteinDictionary() : FuzzyDictionary() {
    private val strings : HashSet<CharSequence> = hashSetOf<CharSequence>()

    // TODO: Documentação
    protected override fun CharSequence.distance(other : CharSequence) : Int {
        val lhsLength = this.length
        val rhsLength = other.length

        var cost = IntArray(rhsLength + 1) { it }
        var newCost = IntArray(rhsLength + 1) { 0 }

        for (i in 0..lhsLength - 1) {
            newCost[0] = i

            for (j in 0..rhsLength - 1) {
                val editCost = if (this[i] == other[j]) 0 else 1
                val costReplace = cost[j] + editCost
                val costDelete = cost[j + 1] + 1
                val costInsert = newCost[j] + 1

                newCost[j + 1] = minOf(costInsert, costDelete, costReplace)
            }

            val swap = cost
            cost = newCost
            newCost = swap
        }

        return cost[rhsLength]
    }
    
    // TODO: Documentação
    public override fun add(value: CharSequence) {
        strings.add(value)
    }

    // TODO: Documentação
    public override fun get(value: CharSequence, threshold: FuzzyScore) : FuzzyMatches<CharSequence> {
        return FuzzyMatches(strings
            .map { FuzzyMatch(it, it.score(value)) }
            .filter { it.score >= threshold }.sortedDescending())
    }

    // TODO: Documentação
    public override fun contains(value: CharSequence) : FuzzyScore {
        return strings.map { it.score(value) }.max() ?: 0.0
    }

    // TODO: Documentação
    public override fun find(value: CharSequence) : CharSequence? {
        if (value in strings)
            return value
        return strings.minBy { it.distance(value) }
    }
}