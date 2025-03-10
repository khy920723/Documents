| 실행모드       | 용도                                                         |
| -------------- | ------------------------------------------------------------ |
| 독립 실행 모드 | 하둡의 기본 실행 모드(로컬 모드)<br />분산 환경 테스트 불가<br />맵 리듀스 프로그램 개발 및 디버깅 용도 |
| 가상 분산 모드 | 하나의 장비에 모든 하둡 환경 설정<br />하나의 장비에 하둡 서비스 제공<br />하나의 장비에 관련 데몬 실행<br />학습용으로 사용 |
| 완전 분산 모드 | 실제 서비스용                                                |

## Hadoop 설치

학습용으로 가상 분산 모드로 구현

### 1. Hadoop 2.7.2 다운로드

> https://archive.apache.org/dist/hadoop/common/hadoop-2.7.2/

```shell
# 홈 디렉토리로 이동
cd
wget https://archive.apache.org/dist/hadoop/common/hadoop-2.7.2/hadoop-2.7.2.tar.gz
```

### 2. 분산 환경 설정

- IP 설정
  - 학습용으로 분산 환경을 하나의 서버(10.0.2.15)를 분산환경으로 사용

```shell
sudo vi /etc/hosts
```

```shell
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
10.0.2.15       hadoopnode01
10.0.2.15       hadoopnode02
10.0.2.15       hadoopnode03
10.0.2.15       hadoopnode04
```

### 3. JDK 설치

- Hadoop에서 프로세스가 정상적으로 작동하는지 확인하기 위해 jps가 필요
  - jps(Java Virtual Machine Process Status Tool) : Java 프로세스의 PID를 검색할 수 있음

```shell
sudo yum install java-1.8.0-openjdk-devel.x86_64
```

### 4. 환경변수 설정

- JVM 버전 확인

```shell
ls -l /usr/lib/jvm

## ...
## drwxr-xr-x. 7 root root  68  8월 18 16:40 java-1.8.0-openjdk-1.8.0.262.b10-0.el7_8.x86_64
## ...
```

- 환경 변수 설정

```shell
# 홈 디렉토리로 이동
cd
vi .bashrc
```

- 아래 내용 추가

```bash
# .bashrc
# ...
# ...
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.262.b10-0.el7_8.x86_64
export PATH=$PATH:$JAVA_HOME/bin
export CLASS_PATH=.:$JAVA_HOME/lib/tools.jar
export HADOOP_HOME=/home/bit44/hadoop-2.7.2
export PATH=$PATH:$JAVA_HOME/bin:$HADOOP_COMMON_LIB_NATIVE_DIR
```

```shell
# shell
source .bashrc
```

### 5. ssh 포트 설정

 ```shell
sudo vi /etc/ssh/ssh_config
 ```

- Port 22 부분의 주석(#) 제거

```shell
# ssh_config
# ...
# ...
Port 22
# ...
# ...
```

- 방화벽에서 포트 열기

```shell
sudo firewall-cmd --permanent --zone=public --add-port=22/tcp
reboot
```

### 6. 네임노드에서 키 생성

현재 가상 분산 모드로 설치를 진행하고 있어 하나의 서버에서 분산 서버를 구현하기 때문에 **네임노드에서 키 생성 과정은 생략 가능**하다.

아래 과정을 각 노드 별로  진행 해줘야 한다.

```shell
ssh-keygen -t rsa
# 키 생성 경로 : Enter (default 사용)
# 비밀번호 설정 : Enter (비밀번호 입력 없이 로그인하기 위해 그냥 Enter)
# 비밀번호 설정 확인 : Enter
ls -al .ssh # 생성 확인
```

- 키 공유
  - hadoopnode02, hadoopnode03, hadoopnode04 모두 아래 단계를 진행

```shell
 ssh-copy-id -i /home/bit44/.ssh/id_rsa.pub bit44@hadoopnode02
 # yes
 # 비밀번호 입력
```

###  7. Hadoop 압축 해제

```shell
# hadoop.tar.gz 가 있는 홈 디렉토리로 이동
cd
tar zxvf hadoop-2.7.2.tar.gz
# 압축파일 삭제
rm hadoop-2.7.2.tar.gz
```

- symbolic link  파일 생성

```shell
ln -s hadoop-2.7.2 hadoop
```

### 8. Hadoop 환경 설정

- Hadoop의 환경 설정 파일은 etc/hadoop 폴더에 있음

```shell
cd hadoop
```

- HADOOP_PID_DIR 설정

```shell
mkdir pids
vi etc/hadoop/hadoop-env.sh
```

```sh
# etc/hadoop/hadoop-env.sh
# ...
# ... HADOOP_PID_DIR를 생성한 pids 폴더 경로로 변경
export HADOOP_PID_DIR=/home/bit44/hadoop/pids
```

- masters 파일 생성
  - 세컨더리 네임 노드의 호스트 명을 기술하는 파일

```shell
vi etc/hadoop/masters
```

```shell
# etc/hadoop/masters
hadoopnode01
```

- slaves 파일 생성
  - 데이터 노드의 호스트 명을 기술하는 파일

```shell
vi etc/hadoop/slaves
```

```shell
# etc/hadoop/slaves
hadoopnode01
```

- 홈 디렉토리에 hdfs-data/hadoop/tmp 폴더 생성

```shell
cd
mkdir hdfs-data
mkdir hdfs-data/hadoop
mkdir hdfs-data/hadoop/tmp
```

- fs.deaultFS : 하둡 파일 시스템의 접근 경로
- hadoop.tmp.dir : 임시 파일을 생성하고 삭제할 때 사용되는 공간

```shell
cd hadoop
vi etc/hadoop/core-site.xml
```

```xml
<configuration>
<property>
    <name>fs.defaultFS</name>
    <value>hdfs://hadoopnode01:9000</value>
</property>
<property>
    <name>hadoop.tmp.dir</name>
    <value>/home/bit44/hdfs-data/hadoop/tmp</value>
</property>
</configuration>
```

```shell
cd
cd hdfs-data/hadoop
mkdir data
mkdir data/name-secondary
mkdir data/namenode
mkdir data/datanode
mkdir data/yarn
mkdir data/yarn/local
mkdir data/yarn/rmstore
mkdir data/yarn/logs
cd 
cd hadoop
```

- hdfs-site.xml

| property                    | 용도                                                         |
| --------------------------- | ------------------------------------------------------------ |
| dfs.replication             | 데이터노드에 들어갈 데이터 블록 복제본의 수                  |
| dfs.namenode.checkpoint.dir | 세컨더리노드가 체크포인팅 할 때 저장할 경로                  |
| dfs.http.address            | HDFS의 정보를 웹으로 확인할 수 있는 포트<br />세컨더리노드가 네임도를 참조할 때 이 주소를 활용 |
| dfs.secondary.http.address  | 세컨더리노드의 정보를 웹으로 확인할 수 있는 포트<br />네임노드가 세컨더리노드를 참조할 때 이 주소를 활용 |
| dfs.namenode.name.dir       | 네임노드가 생성한 파일을 저장하는 경로                       |
| dfs.datanode.data.dir       | 데이터노드가 생성한 파일을 저장하는 경로                     |

```shell
vi etc/hadoop/hdfs-site.xml
```

```xml
<!--hdfs-site.xml -->
<configuration>
<property>
    <name>dfs.replication</name>
    <value>1</value>
</property>
<property>
    <name>dfs.namenode.checkpoint.dir</name>
    <value>/home/bit44/hdfs-data/hadoop/data/name-secondary</value>
</property>
<property>
    <name>dfs.http.address</name>
    <value>hadoopnode01:50070</value>
</property>
<property>
    <name>dfs.secondary.http.address</name>
    <value>hadoopnode01:50090</value>
</property>
<property>
    <name>dfs.namenode.name.dir</name>
    <value>/home/bit44/hdfs-data/hadoop/data/namenode</value>
</property>
<property>
    <name>dfs.datanode.data.dir</name>
    <value>/home/bit44/hdfs-data/hadoop/data/datanode</value>
</property>
</configuration>
```

- mapred-site.xml

| property                  | 용도                                      |
| ------------------------- | ----------------------------------------- |
| mapreduce.framework.name  | 맵리듀스 프레임워크를 yarn으로 설정       |
| yarn.app.mapreduce.am.env | yarn 애플리케이션 맵리듀스 작업 환경 설정 |
| mapreduce.map.env         | 맵리듀스에서 map 작업 환경 설정           |
| mappreduce.reduce.env     | 맵리듀스 reudce 작업 환경 설정            |

```shell
cp etc/hadoop/mapred-site.xml.template etc/hadoop/mapred-site.xml
vi etc/hadoop/mapred-site.xml
```

```xml
<!--mapred-site.xml -->

<configuration>
<property>
    <name>mapreduce.framework.name</name>
    <value>yarn</value>
</property>
<property>
    <name>yarn.app.mapreduce.am.env</name>
    <value>HADOOP_MAPRED_HOME=$HADOOP_HOME</value>
</property>
<property>
    <name>mapreduce.map.env</name>
    <value>HADOOP_MAPRED_HOME=$HADOOP_HOME</value>
</property>
<property>
    <name>mapreduce.reduce.env</name>
    <value>HADOOP_MAPRED_HOME=$HADOOP_HOME</value>
</property>
</configuration>
```

- yarn-site.xml

| property                                              | 용도                                                         |
| ----------------------------------------------------- | ------------------------------------------------------------ |
| yarn.nodemanager.aux-services                         | map 작업 후 reduce 작업 전에 suffle 실행                     |
| yarn.nodemanager.aux-services.mapreduce.shuffle.class | shuffle을 할 때 사용할 클래스 설정                           |
| yarn.nodemanager.local-dirs                           | nodemanager가 작업할 디렉토리<br />nodemanager는 Task Tracker 역할을 함 |
| yarn.resourcemanager.fs.state-store.uri               | resourcemanager가 작업할 디렉토리<br /> resourcemanager는 Job Tracker 역할을 함 |
| yarn.resourcemanager.hostname                         | resourcemanager 호스트 명                                    |
| yarn.web-proxy.address                                | 웹 프록시 서버 설정                                          |
| yarn.nodemanager.log-dirs                             | yarn 작업할 때 만드는 로그를 저장할 경로                     |

```xml
<!-- yarn-site.xml -->
<configuration>
<property>
    <name>yarn.nodemanager.aux-services</name>
    <value>mapreduce_shuffle</value>
</property>
<property>
    <name>yarn.nodemanager.aux-services.mapreduce.shuffle.class</name>
    <value>org.apache.hadoop.mapred.ShuffleHandler</value>
</property>
<property>
    <name>yarn.nodemanager.local-dirs</name>
    <value>/home/bit44/hdfs-data/hadoop/data/yarn/local</value>
</property>
<property>
    <name>yarn.resourcemanager.fs.state-store.uri</name>
    <value>/home/bit44/hdfs-data/hadoop/data/yarn/rmstore</value>
</property>
<property>
    <name>yarn.resourcemanager.hostname</name>
    <value>hadoopnode01</value>
</property>
<property>
    <name>yarn.web-proxy.address</name>
    <value>0.0.0.0:8090</value>
</property>
<property>
    <name>yarn.nodemanager.log-dirs</name>
    <value>/home/bit44/hdfs-data/hadoop/data/yarn/logs</value>
</property>
</configuration>
```

위의 과정들을 각 노드 별로 실행을 해줘야 하는데 손쉽게 하기 위해 scp를 활용해 복사를 한다. 이번 과정은 가상 분산 모드로 설치 했기 때문에 복사를 하지 않아도 된다.

```shell
scp -r /home/bit44/hadoop/etc/hadoop hadoopnode02:/home/bit44/hadoop/etc/hadoop
```

### 9. namenode 포맷

- 최초 hadoop 실행전에 한번만 실행

```shell
bin/hdfs namenode -format
```

```shell
### ...
### ...
INFO common.Storage: Storage directory /home/bit44/hdfs-data/hadoop/data/namenode has been successfully formatted.
20/08/19 13:13:00 INFO namenode.NNStorageRetentionManager: Going to retain 1 images with txid >= 0
20/08/19 13:13:01 INFO util.ExitUtil: Exiting with status 0
20/08/19 13:13:01 INFO namenode.NameNode: SHUTDOWN_MSG:
/************************************************************
SHUTDOWN_MSG: Shutting down NameNode at hadoopnode01/10.0.2.15
************************************************************/
```

위와 같이 successfully formatted 나오면 정상적으로 실행된 것이다.

### 10. Deamon 실행

- sbin: 스크립트들이 모여있는 곳

```shell
ls -l sbin
```

- 각 노드의 데몬을 실행

```shell
sbin/start-dfs.sh
```

- 프로세스가 실행 됐는지 확인
  - 에러가 났다면 logs 폴더에 있는 log를 확인ㄴ

```shell
jps
```

```shell
# 결과
7205 NameNode
7509 SecondaryNameNode
7343 DataNode
7775 Jps
```

- yarn 실행

```shell
sbin/start-yarn.sh
```

- 프로세스가 실행 됏는지 확인

```shell
jps
```

```shell
# 결과
8464 Jps
7205 NameNode
7509 SecondaryNameNode
8149 ResourceManager
8254 NodeManager
7343 DataNode
```

- Proxy 서버 실행

하둡 3.0 에서는 yarn을 실행시키면 proxy 서버가 자동으로 실행되지만 하둡 2.0 대 버전에서는 직접 실행해야 한다.

```shell
sbin/yarn-daemon.sh start proxyserver
jps
```

```shell
7205 NameNode
7509 SecondaryNameNode
8149 ResourceManager
8613 WebAppProxyServer
8649 Jps
8254 NodeManager
7343 DataNode
```

- jobhistory 서버 실행

하둡 2.0대에서 jobhistory 서버 실행시키는 법

```shell
sbin/mr-jobhistory-daemon.sh start historyserver
jps
```

```shell
8690 JobHistoryServer
8770 Jps
7205 NameNode
7509 SecondaryNameNode
8149 ResourceManager
8613 WebAppProxyServer
8254 NodeManager
7343 DataNode
```

하둡 3.0에서 jobhistory 서버 실행시키는 법

```shell
/bin/mapred historyserver start&
```

### 11. Virtual Box에서 포트 포워딩

- 방화벽 - 설정 [런타임, 영구적] 모두 포트 추가

![image-20200819142030697](https://github.com/jeonsanggi/TIL/blob/master/Image/Hadoop/centos-포트.PNG)

- 설정 - 네트워크 - 고급 - 포트 포워딩

![virtualbox-포트](https://github.com/jeonsanggi/TIL/blob/master/Image/Hadoop/virtualbox-포트.PNG)

### 12. HDFS의 Base 폴더 생성

HDFS에서 Write하고 Read할 때 기본으로 사용되는 폴더를 만든다.

```shell
bin/hdfs dfs -mkdir /user
bin/hdfs dfs -mkdir /user/bit44
```

### 13. Hadoop 실습

Hadoop에서 실습 예제로 word count 하는 예제를 제공한다.

```shell
bin/hdfs dfs -mkdir word-input
```

put 옵션으로 파일을 복사하여 옮긴다.

```shell
bin/hdfs dfs -put etc/hadoop/hadoop-env.sh word-input
```

hadoop-mapreduce-examples-2.7.2.jar의 wordcount 클래스로 word-input에 있는 파일을 입력에 있는 파일의 word를 count해서 결과를 word-output 폴더에 만든다.

```shell
bin/yarn jar share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.2.jar wordcount word-input word-output
```

```shell
bin/hdfs dfs -ls word-output
bin/hdfs dfs -cat word-output/part-r-00000
```

### 14. 서비스 종료

Deamon 실행 순서의 반대로 종료를 시키면 된다.

stop-yarn.sh를 실행하면 proxyserver도 같이 종료된다.

하둡 2.0대 에서 jobhistoryserver를 종료하는 법

```shell
sbin/mr-jobhistory-daemon.sh stop historyserver
sbin/stop-yarn.sh
sbin/stop-dfs.sh
```

하둡 3.0에서 jobhistoryserver를 종료하는 법

```shell
ps -ef | grep jobhistoryserver
kill 'jobhistoryserver pid'
```

