package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.OperatingSystem
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future
import scala.util.{Failure, Try}

class MinutelyAggPrtnEntryCountryClstOsQuery(accessor : IMinutelyAggPrtnEntryCountryClstOsTableAccessor) extends QueryBase[MinutelyAggPrtnEntryCountryClstOsQueryParams, MinutelyAggPrtnEntryCountryClstOsRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnEntryCountryClstOsQueryParams = {
        val (partner_id,entry_id,country) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,String]((Dimensions.partner,Dimensions.entry,Dimensions.country), params)
        MinutelyAggPrtnEntryCountryClstOsQueryParams(params.startUtc, params.endUtc, partner_id,entry_id,country, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnEntryCountryClstOsQueryParams): Future[List[MinutelyAggPrtnEntryCountryClstOsRow]] = {
        accessor.query(params.partnerIdList,params.entryIdList,params.countryList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.entry.toString,Dimensions.country.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.operatingSystem.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnEntryCountryClstOsRow): List[String] = {

        val os : String =
          Try({
            OperatingSystem(row.operatingSystem).toString
          }).recoverWith({
            // Just log the exception and keep it as a failure.
            case (ex: NoSuchElementException) => Failure(ex)
          }).getOrElse(OperatingSystem.UNKNOWN.toString)
        List(row.partnerId.toString,row.entryId.toString,row.country.toString,row.metric.toString,row.minute.toString,os,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.entry, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: MinutelyAggPrtnEntryCountryClstOsRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggPrtnEntryCountryClstOsRow, timezoneOffsetFromUtc : Int) : MinutelyAggPrtnEntryCountryClstOsRow = {
        MinutelyAggPrtnEntryCountryClstOsRow(row.partnerId, row.entryId, row.country, row.metric, row.day, row.minute.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.operatingSystem, row.value)
      }

    }

case class MinutelyAggPrtnEntryCountryClstOsQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], entryIdList : List[String], countryList : List[String], metricList : List[String]) extends IDailyPartitionedQueryParams