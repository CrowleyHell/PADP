package lab3;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class Lab3Main {
    SparkConf conf = new SparkConf().setAppName("lab4");
    JavaSparkContext sc = new JavaSparkContext(conf);
    JavaRDD<String> airData = sc.textFile("airData.csv");
    JavaRDD<String> flyData = sc.textFile("flyData.csv");
    JavaPairRDD<Long, String> dictionaryAir = airData.map(s -> s.replaceFirst(",", "&")
            .replaceAll("\"", "")
            .split("&"))
            .mapToPair(s -> new Tuple2<>(Long.parseLong(s[0]), s[1]));
    JavaPairRDD<Tuple2<Long, Long>, FlightStats> flightsInfo = flyData.map(s -> s.)

}
