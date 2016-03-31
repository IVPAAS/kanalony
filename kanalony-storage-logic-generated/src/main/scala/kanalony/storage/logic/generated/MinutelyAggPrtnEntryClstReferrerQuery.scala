package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.DateTime
    import scala.concurrent.Future

    class MinutelyAggPrtnEntryClstReferrerQuery extends QueryBase[MinutelyAggPrtnEntryClstReferrerQueryParams, MinutelyAggPrtnEntryClstReferrerRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnEntryClstReferrerQueryParams = {
        val (partner_id,entry_id) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.entry), params)
        MinutelyAggPrtnEntryClstReferrerQueryParams(params.start, params.end, partner_id,entry_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnEntryClstReferrerQueryParams): Future[List[MinutelyAggPrtnEntryClstReferrerRow]] = {
        val rawQueryResult = MinutelyAggPrtnEntryClstReferrerTableAccessor.query(params.partnerIdList,params.entryIdList,params.metricList,params.days,params.startTime,params.endTime)
      .fetch()(dbApi.session, scala.concurrent.ExecutionContext.Implicits.global, dbApi.keyspace)
    rawQueryResult
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.referrer.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnEntryClstReferrerRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.metric.toString,row.minute.toString,row.referrer.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.referrer, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: MinutelyAggPrtnEntryClstReferrerRow): String = row.metric
    }

case class MinutelyAggPrtnEntryClstReferrerQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams