package ortografix.dictionary
import java.util.*

// TODO: Documentação
class FuzzyNGramDictionary() : FuzzyDictionary() {
    protected override fun CharSequence.distance(other : CharSequence) : Int {
        // TODO: Implementar
        throw NotImplementedError()
    }
    
    public override fun add(value: CharSequence) {
        // TODO: Implementar
        throw NotImplementedError()
    }
    
    public override fun get(value: CharSequence, threshold: FuzzyScore) : FuzzyMatches<CharSequence> {
        // TODO: Implementar
        throw NotImplementedError()
    }

    public override fun contains(value: CharSequence) : FuzzyScore {
        // TODO: Implementar
        throw NotImplementedError()
    }

    public override fun find(value: CharSequence) : CharSequence? {
        // TODO: Implementar
        throw NotImplementedError()
    }
}