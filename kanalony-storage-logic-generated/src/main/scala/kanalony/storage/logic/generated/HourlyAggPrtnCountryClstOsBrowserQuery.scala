package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.{OperatingSystem, Browser}
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future
import scala.util.{Failure, Try}

class HourlyAggPrtnCountryClstOsBrowserQuery(accessor : IHourlyAggPrtnCountryClstOsBrowserTableAccessor) extends QueryBase[HourlyAggPrtnCountryClstOsBrowserQueryParams, HourlyAggPrtnCountryClstOsBrowserRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): HourlyAggPrtnCountryClstOsBrowserQueryParams = {
        val (partner_id,country) = QueryParamsValidator.extractEqualityConstraintParams[Int,String]((Dimensions.partner,Dimensions.country), params)
        HourlyAggPrtnCountryClstOsBrowserQueryParams(params.startUtc, params.endUtc, partner_id,country, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: HourlyAggPrtnCountryClstOsBrowserQueryParams): Future[List[HourlyAggPrtnCountryClstOsBrowserRow]] = {
        accessor.query(params.partnerIdList,params.countryList,params.metricList,params.years,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.country.toString,Dimensions.metric.toString,Dimensions.hour.toString,Dimensions.operatingSystem.toString,Dimensions.browser.toString,"value")
      }

      override protected def getResultRow(row: HourlyAggPrtnCountryClstOsBrowserRow): List[String] = {
        val browser : String =
          Try({
            Browser(row.browser).toString
          }).recoverWith({
            case (ex: NoSuchElementException) => Failure(ex)
          }).getOrElse(Browser.UNKNOWN.toString)
        val os : String =
          Try({
            OperatingSystem(row.operatingSystem).toString
          }).recoverWith({
            case (ex: NoSuchElementException) => Failure(ex)
          }).getOrElse(OperatingSystem.UNKNOWN.toString)
        List(row.partnerId.toString,row.country.toString,row.metric.toString,row.hour.toString,os,browser,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.country, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.hour, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.browser, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 6

      override private[logic] def extractMetric(row: HourlyAggPrtnCountryClstOsBrowserRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : HourlyAggPrtnCountryClstOsBrowserRow, timezoneOffsetFromUtc : Int) : HourlyAggPrtnCountryClstOsBrowserRow = {
        HourlyAggPrtnCountryClstOsBrowserRow(row.partnerId, row.country, row.metric, row.year, row.hour.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.operatingSystem, row.browser, row.value)
      }

    }

case class HourlyAggPrtnCountryClstOsBrowserQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], countryList : List[String], metricList : List[String]) extends IYearlyPartitionedQueryParams