package ortografix.mapreduce

import java.util.*	
import java.io.File

import ortografix.dictionary.FuzzyDictionary
import ortografix.dictionary.LevenshteinDictionary

import org.apache.hadoop.mapreduce.Mapper

import org.apache.hadoop.io.Text

class OrtografixMapper : Mapper<Any, Text, Text, Text>() {
    val dictionary: FuzzyDictionary = LevenshteinDictionary()

    protected override fun setup(context: Context?) {
        val ptWords = File("resources/wordlist-big-latest.txt").readText().split("\n")
        for (word in ptWords)
            dictionary.add(word)
    }

    public override fun map(key: Any?, value: Text?, context: Context?) {
        val str = value.toString()
        context?.write(value, Text(dictionary.get(str).best?.toString() ?: str))
    }
}