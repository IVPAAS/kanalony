package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyAggClstCv3Query extends QueryBase[MinutelyAggClstCv3QueryParams, MinutelyAggClstCv3Row] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggClstCv3QueryParams = {
        val (partner_id) = QueryParamsValidator.extractEqualityConstraintParams[Int]((Dimensions.partner), params)
        MinutelyAggClstCv3QueryParams(params.start, params.end, partner_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggClstCv3QueryParams): Future[List[MinutelyAggClstCv3Row]] = {
        val rawQueryResult = MinutelyAggClstCv3TableAccessor.query(params.partnerIdList,params.metricList,params.days,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.cf3.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggClstCv3Row): List[String] = {
        List(row.partnerId.toString,row.metric.toString,row.minute.toString,row.customVar3.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.cf3, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: MinutelyAggClstCv3Row): String = row.metric
    }

case class MinutelyAggClstCv3QueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams