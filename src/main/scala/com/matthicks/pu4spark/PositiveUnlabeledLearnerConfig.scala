package com.matthicks.pu4spark

/**
  * Subclasses should be case classes in order to be easily serializable (e.g. to JSON)
  */
trait PositiveUnlabeledLearnerConfig {
  def build(): PositiveUnlabeledLearner
}

/**
  * Needed for serialization by json4s (should be passed to org.json4s.ShortTypeHints)
  */
object PositiveUnlabeledLearnerConfig {
  val subclasses = List(classOf[TraditionalPULearnerConfig], classOf[GradualReductionPULearnerConfig])
}