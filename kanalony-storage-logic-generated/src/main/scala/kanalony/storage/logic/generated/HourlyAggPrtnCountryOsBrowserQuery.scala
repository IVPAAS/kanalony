package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.{OperatingSystem, Browser}
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future
import scala.util.{Failure, Try}

class HourlyAggPrtnCountryOsBrowserQuery(accessor : IHourlyAggPrtnCountryOsBrowserTableAccessor) extends QueryBase[HourlyAggPrtnCountryOsBrowserQueryParams, HourlyAggPrtnCountryOsBrowserRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnCountryOsBrowserQueryParams = {
        val (partner_id,country,operating_system,browser) = QueryParamsValidator.extractEqualityConstraintParams[Int,String,Int,Int]((Dimensions.partner,Dimensions.country,Dimensions.operatingSystem,Dimensions.browser), params)
        HourlyAggPrtnCountryOsBrowserQueryParams(params.startUtc, params.endUtc, partner_id,country,operating_system,browser, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnCountryOsBrowserQueryParams): Future[List[HourlyAggPrtnCountryOsBrowserRow]] = {
        accessor.query(params.partnerIdList,params.countryList,params.operatingSystemList,params.browserList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.operatingSystem.toString,Dimensions.browser.toString,Dimensions.metric.toString,Dimensions.hour.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnCountryOsBrowserRow): List[String] = {
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
        List(row.partnerId.toString,row.country.toString,os,browser,row.metric.toString,row.hour.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: HourlyAggPrtnCountryOsBrowserRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnCountryOsBrowserRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnCountryOsBrowserRow = {
        HourlyAggPrtnCountryOsBrowserRow(row.partnerId, row.country, row.operatingSystem, row.browser, row.metric, row.year, row.hour.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.value)
      }

    }

case class HourlyAggPrtnCountryOsBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], operatingSystemList : List[Int], browserList : List[Int], metricList : List[String]) extends IYearlyPartitionedQueryParams