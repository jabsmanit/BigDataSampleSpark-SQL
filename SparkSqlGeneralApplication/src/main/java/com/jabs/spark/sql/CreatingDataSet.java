package com.jabs.spark.sql;

import java.util.Collections;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;

import com.jabs.spark.sql.bean.Person;

public class CreatingDataSet {
	public static void main(String[] args) {
		// Create an instance of a Bean class
		Person person = new Person();
		person.setName("Andy");
		person.setAge(32);
		
		SparkSession session = SparkSession.builder().appName("CreatingDataSet").getOrCreate();
		//Dataset<String> textFile = session.read().textFile("");
		// Encoders are created for Java beans
		Encoder<Person> personEncoder = Encoders.bean(Person.class);
		Dataset<Person> javaBeanDS = session.createDataset(Collections.singletonList(person), personEncoder);
		
		javaBeanDS.show();
		
		//DataTypes.createStructField("", DataTypes.StringType, false);
		
	}
}
