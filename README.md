# pu4spark
A library for [Positive-Unlabeled Learning](https://en.wikipedia.org/wiki/One-class_classification#PU_learning)
for Apache Spark MLlib (ml package)

Forked from the original work done at https://github.com/ispras/pu4spark

## Implemented algorithms

### Traditional PU
Original Positive-Unlabeled learning algorithm; firstly proposed in
> Liu, B., Dai, Y., Li, X. L., Lee, W. S., & Philip, Y. (2002).
Partially supervised classification of text documents.
In ICML 2002, Proceedings of the nineteenth international conference on machine learning. (pp. 387–394).

### Gradual Reduction PU (aka PU-LEA)
Modified Positive-Unlabeled learning algorithm;
main idea is to gradually refine set of positive examples.
Pseudocode was taken from:
>Fusilier, D. H., Montes-y-Gómez, M., Rosso, P., & Cabrera, R. G. (2015).
Detecting positive and negative deceptive opinions using PU-learning.
Information Processing & Management, 51(4), 433-443.

## Requirements

Spark 2+

## Linking

The library is published into Maven central and JCenter.
Add the following lines depending on your build system.

### Gradle

```gradle
compile 'com.matthicks:pu4spark:0.3'
```

### Maven

```xml
<dependency>
    <groupId>com.matthicks</groupId>
    <artifactId>pu4spark</artifactId>
    <version>0.3</version>
</dependency>
```

### SBT

```
libraryDependencies += "com.matthicks" % "pu4spark" % "0.3"
```

## Building from Sources

Build library with SBT:

```shell
sbt publishLocal
```

## Usage example


```scala
val inputLabelName = "category"
val srcFeaturesName = "srcFeatures"
val outputLabel = "outputLabel"

val puLearnerConfig = TraditionalPULearnerConfig(0.05, 1, LogisticRegressionConfig())
val puLearner = puLearnerConfig.build()
val df = ... //needed df that contains at least the following columns:
// binary label for positive and unlabel (inputLabelName)
// and features assembled as vector (featuresName)

val weightedDF = puLearner.weight(preparedDf, inputLabelName, srcFeaturesName, outputLabel)
```
Returned dataframe contains probability estimation for each instance in the column `outputLabel`.

Features can be assembled to one column by using [VectorAssembler](https://spark.apache.org/docs/1.6.2/ml-features.html#vectorassembler):
```scala
val assembler = new VectorAssembler()
  .setInputCols(df.columns.filter(c => c != rowName)) //keep here only feature columns
  .setOutputCol(featuresName)
val pipeline = new Pipeline().setStages(Array(assembler))
val preparedDf = pipeline.fit(df).transform(dfForML)
```
