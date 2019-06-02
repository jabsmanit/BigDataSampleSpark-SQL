# SparkSQLGeneralApplication
This is a sample Spark program in Java demonstrating Spark SQL.

Steps for execution:
1) Build the SparkSqlGeneralApplication maven project.
   You can either import the project into eclipse & build it or if maven is installed on your laptop, you can build it from command prompt.
   For building from command prompt, navigate to the root directory of the project and fire the command
    # mvn clean install
2) Create the input. 
   # hdfs dfs -mkdir -p /Spark/sql/input
   # hdfs dfs -put data/input.txt /Spark/sql/input
2) Navigate to the target directory on VM and run the spark application
    # spark-submit --class com.jabs.spark.sql.FirstSparkSqlDriver --master yarn SparkSqlGeneralApplication-0.0.1-SNAPSHOT.jar /Spark/sql/input > logs.txt