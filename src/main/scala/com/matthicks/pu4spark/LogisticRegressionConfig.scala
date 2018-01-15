package com.matthicks.pu4spark

import org.apache.spark.ml.classification.{LogisticRegression, LogisticRegressionModel, ProbabilisticClassifier}
import org.apache.spark.ml.linalg.Vector

case class LogisticRegressionConfig(maxIter: Int = 100,
                                    regParam: Double = 1.0e-8,
                                    elasticNetParam: Double = 0.0) extends ProbabilisticClassifierConfig {
  def build(): ProbabilisticClassifier[Vector, LogisticRegression, LogisticRegressionModel] = {
    new LogisticRegression()
      .setLabelCol(ProbabilisticClassifierConfig.labelName)
      .setFeaturesCol(ProbabilisticClassifierConfig.featuresName)
      .setMaxIter(maxIter)
      .setRegParam(regParam)
      .setElasticNetParam(elasticNetParam)
  }
}
