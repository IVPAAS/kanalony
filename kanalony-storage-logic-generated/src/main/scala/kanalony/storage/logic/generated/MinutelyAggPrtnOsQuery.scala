package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.OperatingSystem
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future
import scala.util.{Failure, Try}

class MinutelyAggPrtnOsQuery(accessor : IMinutelyAggPrtnOsTableAccessor) extends QueryBase[MinutelyAggPrtnOsQueryParams, MinutelyAggPrtnOsRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggPrtnOsQueryParams = {
        val (partner_id,operating_system) = QueryParamsValidator.extractEqualityConstraintParams[Int,Int]((Dimensions.partner,Dimensions.operatingSystem), params)
        MinutelyAggPrtnOsQueryParams(params.startUtc, params.endUtc, partner_id,operating_system, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggPrtnOsQueryParams): Future[List[MinutelyAggPrtnOsRow]] = {
        accessor.query(params.partnerIdList,params.operatingSystemList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.operatingSystem.toString,Dimensions.metric.toString,Dimensions.minute.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggPrtnOsRow): List[String] = {

        val os : String =
          Try({
            OperatingSystem(row.operatingSystem).toString
          }).recoverWith({
            // Just log the exception and keep it as a failure.
            case (ex: NoSuchElementException) => Failure(ex)
          }).getOrElse(OperatingSystem.UNKNOWN.toString)
        List(row.partnerId.toString,os,row.metric.toString,row.minute.toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.operatingSystem, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: MinutelyAggPrtnOsRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggPrtnOsRow, timezoneOffsetFromUtc : Int) : MinutelyAggPrtnOsRow = {
        MinutelyAggPrtnOsRow(row.partnerId, row.operatingSystem, row.metric, row.day, row.minute.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.value)
      }

    }

case class MinutelyAggPrtnOsQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], operatingSystemList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams