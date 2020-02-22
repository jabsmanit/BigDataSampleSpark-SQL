package com.jabs.spark.sql;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.jabs.spark.sql.bean.Customer;

public class FirstSparkSqlDriver {

	public static void main(String[] args) {
		SparkSession session = SparkSession.builder().appName("FirstSparkSqlDriver").getOrCreate();
		//Dataset<Row> df = session.read().json("examples/src/main/resources/people.json");
		//session.read().format("parquet").load("/directory");
		//session.read().parquet("/directory");

		JavaRDD<String> javaRDD = session.read().textFile(args[0]).javaRDD();
	
		JavaRDD<Customer> customerRDD = javaRDD.map(line -> {
			String[] coulmns = line.split(",");
			return new Customer(Integer.parseInt(coulmns[0].trim()), coulmns[1].trim(), coulmns[2].trim(), coulmns[3].trim(), Integer.parseInt(coulmns[4].trim()));
		  });
		
		// Apply a schema to an RDD of JavaBeans to get a DataFrame
		Dataset<Row> peopleDF = session.createDataFrame(customerRDD, Customer.class);
		peopleDF.printSchema();
		peopleDF.show();
		//peopleDF.select("").show();
		
		// Register the DataFrame as a temporary view
		peopleDF.createOrReplaceTempView("customer");
		
		Dataset<Row> sqlDataFrame = session.sql("SELECT name FROM customer");
		sqlDataFrame.printSchema();
		sqlDataFrame.show();
	}

}
