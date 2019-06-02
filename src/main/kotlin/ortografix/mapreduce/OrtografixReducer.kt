package ortografix.mapreduce

import java.util.*

import org.apache.hadoop.mapreduce.Reducer

import org.apache.hadoop.io.Text

class OrtografixReducer : Reducer<Text, Text, Text, Text>() {
    public override fun reduce(key: Text?, values: Iterable<Text>?, context: Context?) {
        context?.write(key, values?.first() ?: key)
    }
}