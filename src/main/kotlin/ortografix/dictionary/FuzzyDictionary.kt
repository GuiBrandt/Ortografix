package ortografix.dictionary
import java.util.*

// TODO: Documentação
abstract class FuzzyDictionary : IFuzzySet<CharSequence> {

    // TODO: Documentação
    protected abstract fun CharSequence.distance(other : CharSequence) : Int 
    
    // TODO: Documentação
    protected fun CharSequence.score(other: CharSequence) : FuzzyScore {
        return 1.0 - distance(other).toDouble() / other.length
    }
}