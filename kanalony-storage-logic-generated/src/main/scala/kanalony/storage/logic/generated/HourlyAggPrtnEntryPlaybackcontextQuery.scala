package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class HourlyAggPrtnEntryPlaybackcontextQuery(accessor : IHourlyAggPrtnEntryPlaybackcontextTableAccessor) extends QueryBase[HourlyAggPrtnEntryPlaybackcontextQueryParams, HourlyAggPrtnEntryPlaybackcontextRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnEntryPlaybackcontextQueryParams = {
        val (partner_id,entry_id,playback_context) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.playbackContext), params)
        HourlyAggPrtnEntryPlaybackcontextQueryParams(params.startUtc, params.endUtc, partner_id,entry_id,playback_context, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnEntryPlaybackcontextQueryParams): Future[List[HourlyAggPrtnEntryPlaybackcontextRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.playbackContextList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.playbackContext.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnEntryPlaybackcontextRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.playbackContext.toString,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.playbackContext, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyAggPrtnEntryPlaybackcontextRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnEntryPlaybackcontextRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnEntryPlaybackcontextRow = {
        HourlyAggPrtnEntryPlaybackcontextRow(row.partnerId, row.entryId, row.playbackContext, row.metric, row.year, row.hour.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.value)
      }

    }

case class HourlyAggPrtnEntryPlaybackcontextQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], playbackContextList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams