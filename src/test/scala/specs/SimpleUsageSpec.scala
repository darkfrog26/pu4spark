package specs

import com.matthicks.pu4spark.{LogisticRegressionConfig, TraditionalPULearnerConfig}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.sql.SparkSession
import org.scalatest.{Matchers, WordSpec}

class SimpleUsageSpec extends WordSpec with Matchers {
  private lazy val spark = SparkSession.builder().appName("Simple Usage").master("local[2]").getOrCreate()

  "Simple Usage" should {
    "test basic positive data" in {
      val puLearnerConfig = TraditionalPULearnerConfig(0.05, 1, LogisticRegressionConfig())
      val puLearner = puLearnerConfig.build()

      val training = spark.createDataFrame(Seq(
        (1.0, Vectors.dense(0.0, 1.1, 0.1)),
        (1.0, Vectors.dense(0.0, 1.0, -1.0)),
        (1.0, Vectors.dense(0.2, 1.3, 1.0)),
        (1.0, Vectors.dense(0.1, 1.2, -0.5))
      )).toDF("label", "features")

      val weightedDF = puLearner.weight(training, "label", "features")
      // TODO: what's next?
    }
  }
}
