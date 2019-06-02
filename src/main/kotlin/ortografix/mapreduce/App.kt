package ortografix.mapreduce

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapred.Mapper
import org.apache.hadoop.mapred.Reducer
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.Text

fun main(args: Array<String>) {
    val conf = Configuration()
    val job = Job.getInstance(conf)
    job.jobName = "Ortografix"
    job.mapperClass = OrtografixMapper::class.java
    job.reducerClass = OrtografixReducer::class.java
    job.outputKeyClass = Text::class.java
    job.outputValueClass = Text::class.java
    FileInputFormat.addInputPath(job, Path(args[0]))
    FileOutputFormat.setOutputPath(job, Path(args[1]))
    System.exit(if (job.waitForCompletion(true)) 0 else 1)
}
