package com.matthicks.pu4spark

case class TraditionalPULearnerConfig(relNegThreshold: Double = 0.5,
                                      maxIters: Int = 1,
                                      classifierConfig: ProbabilisticClassifierConfig = LogisticRegressionConfig()
                                     ) extends PositiveUnlabeledLearnerConfig {
  override def build(): PositiveUnlabeledLearner = {
    classifierConfig match {
      case lrc: LogisticRegressionConfig => new TraditionalPULearner(relNegThreshold, maxIters, lrc.build())
      case rfc: RandomForestConfig => new TraditionalPULearner(relNegThreshold, maxIters, rfc.build())
    }
  }
}