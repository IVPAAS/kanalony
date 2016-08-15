package kanalony.storage.logic.generated

import com.kaltura.core.userAgent.enums.Device
import kanalony.storage.generated._
import kanalony.storage.logic._
import kanalony.storage.logic.queries.model._
import org.joda.time.{DateTime, DateTimeZone}

import scala.concurrent.Future

    class MinutelyAggClstDeviceQuery(accessor : IMinutelyAggClstDeviceTableAccessor) extends QueryBase[MinutelyAggClstDeviceQueryParams, MinutelyAggClstDeviceRow] with IUserActivityQuery {
      private[logic] override def extractParams(params: QueryParams): MinutelyAggClstDeviceQueryParams = {
        val (partner_id) = QueryParamsValidator.extractEqualityConstraintParams[Int]((Dimensions.partner), params)
        MinutelyAggClstDeviceQueryParams(params.startUtc, params.endUtc, partner_id, params.metrics.map(_.name))
      }

      override def supportsUserDefinedMetrics = true

      private[logic] override def executeQuery(params: MinutelyAggClstDeviceQueryParams): Future[List[MinutelyAggClstDeviceRow]] = {
        accessor.query(params.partnerIdList,params.metricList,params.days,params.startTime,params.endTime)
      }

      override private[logic] def getResultHeaders(): List[String] =  {
        List(Dimensions.partner.toString,Dimensions.metric.toString,Dimensions.minute.toString,Dimensions.device.toString,"value")
      }

      override protected def getResultRow(row: MinutelyAggClstDeviceRow): List[String] = {
        List(row.partnerId.toString,row.metric.toString,row.minute.toString,Device(row.device).toString,row.value.toString)
      }

      override val dimensionInformation: List[DimensionDefinition] = {
        List(DimensionDefinition(Dimensions.partner, new DimensionConstraintDeclaration(QueryConstraint.Equality)),
DimensionDefinition(Dimensions.minute, new DimensionConstraintDeclaration(QueryConstraint.Range)),
DimensionDefinition(Dimensions.device, new DimensionConstraintDeclaration(QueryConstraint.Range)))
      }

      override def metricValueLocationIndex(): Int = 4

      override private[logic] def extractMetric(row: MinutelyAggClstDeviceRow): String = row.metric

      override private[logic] def updateTimezoneOffset(row : MinutelyAggClstDeviceRow, timezoneOffsetFromUtc : Int) : MinutelyAggClstDeviceRow = {
        MinutelyAggClstDeviceRow(row.partnerId, row.metric, row.day, row.minute.withZone(DateTimeZone.forOffsetHoursMinutes(timezoneOffsetFromUtc / 60, timezoneOffsetFromUtc % 60)), row.device, row.value)
      }

    }

case class MinutelyAggClstDeviceQueryParams(startTime : DateTime, endTime : DateTime, partnerIdList : List[Int], metricList : List[String]) extends IDailyPartitionedQueryParams