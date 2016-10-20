package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.{Browser, OperatingSystem}
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future
import scala.util.{Failure, Try}

class MinutelyAggPrtnEntryOsBrowserQuery(accessor : IMinutelyAggPrtnEntryOsBrowserTableAccessor) extends QueryBase[MinutelyAggPrtnEntryOsBrowserQueryParams, MinutelyAggPrtnEntryOsBrowserRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnEntryOsBrowserQueryParams = {
        val (partner_id,entry_id,operating_system,browser) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,Int,Int]((Dimensions.partner,Dimensions.entry,Dimensions.operatingSystem,Dimensions.browser), params)
        MinutelyAggPrtnEntryOsBrowserQueryParams(params.startUtc, params.endUtc, partner_id,entry_id,operating_system,browser, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnEntryOsBrowserQueryParams): Future[List[MinutelyAggPrtnEntryOsBrowserRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.operatingSystemList,params.browserList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.operatingSystem.toString,Dimensions.browser.toString,Dimensions.metric.toString,Dimensions.minute.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnEntryOsBrowserRow): List[String] = {
        val browser : String =
          Try({
            Browser(row.browser).toString
          }).recoverWith({
            // Just log the exception and keep it as a failure.
            case (ex: NoSuchElementException) => Failure(ex)
          }).getOrElse(Browser.UNKNOWN.toString)
        val os : String =
          Try({
            OperatingSystem(row.operatingSystem).toString
          }).recoverWith({
            // Just log the exception and keep it as a failure.
            case (ex: NoSuchElementException) => Failure(ex)
          }).getOrElse(OperatingSystem.UNKNOWN.toString)
        List(row.partnerId.toString,row.entryId.toString,os,browser,row.metric.toString,row.minute.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: MinutelyAggPrtnEntryOsBrowserRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggPrtnEntryOsBrowserRow, timezoneOffsetFromUtc : Int) : MinutelyAggPrtnEntryOsBrowserRow = {
        MinutelyAggPrtnEntryOsBrowserRow(row.partnerId, row.entryId, row.operatingSystem, row.browser, row.metric, row.day, row.minute.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.value)
      }

    }

case class MinutelyAggPrtnEntryOsBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], operatingSystemList : List[Int], browserList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams