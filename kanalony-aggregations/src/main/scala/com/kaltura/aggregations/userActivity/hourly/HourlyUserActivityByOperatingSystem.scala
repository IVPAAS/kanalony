package com.kaltura.aggregations.userActivity.hourly

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.keys.UserActivityOperatingSystemKey
import com.kaltura.aggregations.IAggregateHourly
import com.kaltura.aggregations.userActivity.BaseUserActivityAggregation
import com.kaltura.model.events.EnrichedPlayerEvent
import kanalony.storage.generated.hourly_ua_prtn_osRow

object HourlyUserActivityByOperatingSystem extends BaseUserActivityAggregation[UserActivityOperatingSystemKey, hourly_ua_prtn_osRow] with IAggregateHourly with Serializable{

  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "hourly_ua_prtn_os" -> columns,
    "hourly_ua_clst_os" -> columns
  )

  val columns : SomeColumns = new SomeColumns(
    "partner_id" as "partnerId",
    "operating_system" as "operatingSystem",
    "metric" as "metric",
    "hour" as "hour",
    "year" as "year",
    "value" as "value")

  override def aggKey(e: EnrichedPlayerEvent): UserActivityOperatingSystemKey = UserActivityOperatingSystemKey(e.partnerId, e.eventType, e.eventTime.hourOfDay().roundFloorCopy(), e.userAgent.operatingSystem.id)
  override def toRow(pair: (UserActivityOperatingSystemKey, Long)): hourly_ua_prtn_osRow = hourly_ua_prtn_osRow(pair._1.partnerId, pair._1.operatingSystem, pair._1.metric, pair._1.time.getYear, pair._1.time, pair._2)
}
