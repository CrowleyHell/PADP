package lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.List;
import java.util.Map;

public class Lab3Main {
    public static void main(String[] args) throws Exception{
        SparkConf conf = new SparkConf().setAppName("lab4");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> airData = sc.textFile("airData.csv");
        JavaRDD<String> flyData = sc.textFile("flyData.csv");
        JavaPairRDD<Long, String> dictionaryAir = airData.filter(s -> !s.contains("Code"))
                .map(s -> s.replaceFirst(",", "&")
                        .replaceAll("\"", "")
                        .split("&"))
                .mapToPair(s -> new Tuple2<>(Long.parseLong(s[0]), s[1]));
        JavaPairRDD<Tuple2<Long, Long>, FlightStats> flightsInfo = flyData.filter(s -> !s.contains("YEAR"))
                .map(s -> s.split(","))
                .mapToPair(s -> new Tuple2<>(new Tuple2<>(Long.parseLong(s[11]), Long.parseLong(s[14])), s[18]))
                .groupByKey()
                .mapValues(s -> FlightStats.CountStats(s.iterator()));
        Map<Long, String> dictionaryMap = dictionaryAir.collectAsMap();
        final Broadcast<Map<Long, String>> dictionaryBroadcasted = sc.broadcast(dictionaryMap);
        JavaRDD<FlightStats> resultStats = flightsInfo.map(p -> p._2.formFinalStats(dictionaryBroadcasted.value(), p._1));
        resultStats.saveAsTextFile();

    }
}
