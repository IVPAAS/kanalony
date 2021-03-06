package kanalony.storage.logic.generated

    import kanalony.storage.generated._
    import kanalony.storage.logic._
    import kanalony.storage.logic.queries.model._
    import kanalony.storage.DbClientFactory._
    import org.joda.time.{DateTimeZone, DateTime}
    import scala.concurrent.Future

    class HourlyAggPrtnEntryClstReferrerQuery(accessor : IHourlyAggPrtnEntryClstReferrerTableAccessor) extends QueryBase[HourlyAggPrtnEntryClstReferrerQueryParams, HourlyAggPrtnEntryClstReferrerRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnEntryClstReferrerQueryParams = {
        val (partner_id,entry_id) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.entry), params)
        HourlyAggPrtnEntryClstReferrerQueryParams(params.startUtc, params.endUtc, partner_id,entry_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnEntryClstReferrerQueryParams): Future[List[HourlyAggPrtnEntryClstReferrerRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.referrer.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnEntryClstReferrerRow): List[String] = {
        List(row.partnerId.toString,row.entryId.toString,row.metric.toString,row.hour.toString,row.referrer.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.referrer, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 5

      override private[logic] def extractMetric(row: HourlyAggPrtnEntryClstReferrerRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnEntryClstReferrerRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnEntryClstReferrerRow = {
        HourlyAggPrtnEntryClstReferrerRow(row.partnerId, row.entryId, row.metric, row.year, row.hour.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.referrer, row.value)
      }

    }

case class HourlyAggPrtnEntryClstReferrerQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams