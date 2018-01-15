package com.matthicks.pu4spark

import org.apache.spark.ml.classification._
import org.apache.spark.ml.linalg._

case class RandomForestConfig(numTrees: Int = 512) extends ProbabilisticClassifierConfig {
  def build(): ProbabilisticClassifier[Vector, RandomForestClassifier, RandomForestClassificationModel] = {
    new RandomForestClassifier()
      .setLabelCol(ProbabilisticClassifierConfig.labelName).setFeaturesCol(ProbabilisticClassifierConfig.featuresName)
      .setNumTrees(numTrees)
  }
}
