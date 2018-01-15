package com.matthicks.pu4spark

case class GradualReductionPULearnerConfig(relNegThreshold: Double = 0.5,
                                           classifierConfig: ProbabilisticClassifierConfig) extends PositiveUnlabeledLearnerConfig {
  override def build(): PositiveUnlabeledLearner = {
    classifierConfig match {
      case lrc: LogisticRegressionConfig => new GradualReductionPULearner(relNegThreshold, lrc.build())
      case rfc: RandomForestConfig => new GradualReductionPULearner(relNegThreshold, rfc.build())
    }
  }
}