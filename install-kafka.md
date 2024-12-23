### Install kafka 

- Download Java 

```
cd /usr/local
```
```
sudo wget https://github.com/AdoptOpenJDK/openjdk8-upstream-binaries/releases/download/jdk8u342-b07/OpenJDK8U-jdk_x64_linux_8u342b07.tar.gz
```
```
sudo chmod 755 OpenJDK8U-jdk_x64_linux_8u342b07.tar.gz ; sudo tar xvfz OpenJDK8U-jdk_x64_linux_8u342b07.tar.gz
```
```
sudo ln -s openjdk-8u342-b07 java
```
```
sudo vi /etc/profile
```
```
export JAVA_HOME=/usr/local/java
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH="."
```
```
source /etc/profile
```


- Download kafka </br>

cd ~

```
sudo wget https://archive.apache.org/dist/kafka/2.5.0/kafka_2.12-2.5.0.tgz
```
```
tar xvf kafka_2.12-2.5.0.tgz;ln -s kafka_2.12-2.5.0 kafka
```
```
sudo vi ~/.bashrc
```
```
export KAFKA_HEAP_OPTS="-Xmx400m -Xms400m"
```
```
echo $KAFKA_HEAP_OPTS
```
exit </br>
echo $KAFKA_HEAP_OPTS

```
sudo vi kafka/config/server.properties
```
```
- advertised.listeners=PLAINTEXT:qqqqqqqqqqqq:9092
```
```
cd kafka
```
```
bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
```
```
bin/kafka-server-start.sh -daemon config/server.properties
```
jps

```
bin/kafka-topics.sh --create --bootstrap-server qqqqqqqqqqqq:9092 --replication-factor 1 --partitions 3 --topic select-color \
```
```
bin/kafka-console-consumer.sh --bootstrap-server qqqqqqqqqqqq:9092 --topic select-color --from-beginning
```