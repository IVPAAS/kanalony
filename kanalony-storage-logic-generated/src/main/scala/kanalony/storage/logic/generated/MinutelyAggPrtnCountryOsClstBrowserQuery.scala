package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.{Browser, OperatingSystem}
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future
import scala.util.{Failure, Try}

class MinutelyAggPrtnCountryOsClstBrowserQuery(accessor : IMinutelyAggPrtnCountryOsClstBrowserTableAccessor) extends QueryBase[MinutelyAggPrtnCountryOsClstBrowserQueryParams, MinutelyAggPrtnCountryOsClstBrowserRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnCountryOsClstBrowserQueryParams = {
        val (partner_id,country,operating_system) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,Int]((Dimensions.partner,Dimensions.country,Dimensions.operatingSystem), params)
        MinutelyAggPrtnCountryOsClstBrowserQueryParams(params.startUtc, params.endUtc, partner_id,country,operating_system, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnCountryOsClstBrowserQueryParams): Future[List[MinutelyAggPrtnCountryOsClstBrowserRow]] = {
        accessor.query(params.partnerIdList,params.countryList,params.operatingSystemList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.operatingSystem.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.browser.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnCountryOsClstBrowserRow): List[String] = {
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
        List(row.partnerId.toString,row.country.toString,os,row.metric.toString,row.minute.toString,browser,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: MinutelyAggPrtnCountryOsClstBrowserRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggPrtnCountryOsClstBrowserRow, timezoneOffsetFromUtc : Int) : MinutelyAggPrtnCountryOsClstBrowserRow = {
        MinutelyAggPrtnCountryOsClstBrowserRow(row.partnerId, row.country, row.operatingSystem, row.metric, row.day, row.minute.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.browser, row.value)
      }

    }

case class MinutelyAggPrtnCountryOsClstBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], operatingSystemList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams