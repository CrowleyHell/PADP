## Лабораторные работы по курсу "Разработка парарллельных и распределительных программ".

[Лабораторная работа №1 (_сдана_)](#lab1)

[Лабораторная работа №2 (_сдана_)](#lab2)

[Лабораторная работа №3 (_сделана_)](#lab3)

[Лабораторная работа №4 (_сделана_)](#lab4)

[Лабораторная работа №5 (_сделана_)(#lab5)

<a name="lab1"><h3>Лабораторная работа №1</h3></a>
Package: lab1

Output: outputs/lab1

Run:

    export HADOOP_CLASSPATH=target/padp-1.0.jar
    hadoop lab1.WordCountApp warandpeace1.txt lab1


<a name="lab2"><h3>Лабораторная работа №2</h3></a>
Package: lab2

Output: outputs/lab2

Run:

    export HADOOP_CLASSPATH=target/padp-1.0.jar
    hadoop lab2.Main airData.csv flyData.csv lab2


<a name="lab3"><h3>Лабораторная работа №3</h3></a>   
Package: lab3

Output: outputs/lab3

Run:

    spark-submit --class lab3.Lab3Main --master yarn-client --num-executors target/padp-1.0.jar airData.csv flyData.csv lab3
    
    
<a name="lab4"><h3>Лабораторная работа №4</h3></a>   
Package: lab4

Output: outputs/lab4

Run:

	mvn compile
	
	mvn exec:java -Dexec.mainClass="lab4.AkkaMain"
	
	
<a name="lab5"><h3>Лабораторная работа №5</h3></a>   
Package: lab5

Output: --

Run:

	mvn compile
	
	mvn exec:java -Dexec.mainClass="lab5.AkkaMain"
	

