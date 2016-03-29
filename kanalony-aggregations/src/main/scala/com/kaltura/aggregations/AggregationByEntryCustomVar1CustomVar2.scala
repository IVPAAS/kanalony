package com.kaltura.aggregations

import com.datastax.spark.connector.{SomeColumns, _}
import com.kaltura.aggregations.keys.AggregationEntryCustomVar1CustomVar2Key
import com.kaltura.model.events.EnrichedPlayerEvent
import org.joda.time.DateTime
import com.kaltura.core.utils.ReadableDateUnits.ReadableDateUnits


abstract class AggregationByEntryCustomVar1CustomVar2 extends BaseAggregation[AggregationEntryCustomVar1CustomVar2Key, EntryCustomVar1CustomVar2Res] with IAggregate with Serializable{

  val columns: List[(String, String)] = List[(String, String)](
    ("partner_id","partnerId"),
    ("entry_id","entryId"),
    ("custom_var1","cv1"),
    ("custom_var2","cv2"),
    ("metric","metric"),
    (getAggrTimeUnit,"time"),
    ("value","value"))

   override def aggKey(e: EnrichedPlayerEvent): AggregationEntryCustomVar1CustomVar2Key = AggregationEntryCustomVar1CustomVar2Key(e.partnerId, e.entryId, e.eventType, getAggrTime(e.eventTime), e.customVar1, e.customVar2)
   override def toRow(pair: (AggregationEntryCustomVar1CustomVar2Key, Long)): EntryCustomVar1CustomVar2Res = EntryCustomVar1CustomVar2Res(partnerId = pair._1.partnerId, entryId = pair._1.entryId, cv1 = pair._1.cv1, cv2 = pair._1.cv2, metric = pair._1.metric, year = pair._1.time getYear, month = pair._1.time getYearMonth, day = pair._1.time getYearMonthDay, time = pair._1.time, value = pair._2)
}

object HourlyAggregationByEntryCustomVar1CustomVar2 extends AggregationByEntryCustomVar1CustomVar2 with IAggregateHourly {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "hourly_agg_prtn_entry_cv1_cv2" -> toSomeColumns(columns :+ ("year", "year")),
    "hourly_agg_prtn_entry_cv1_clst_cv2" -> toSomeColumns(columns :+ ("year", "year")),
    "hourly_agg_prtn_cv1_cv2_clst_entry" -> toSomeColumns(columns :+ ("month", "month"))

  )
}

object MinutelyAggregationByEntryCustomVar1CustomVar2 extends AggregationByEntryCustomVar1CustomVar2 with IAggregateMinutely {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "minutely_agg_prtn_entry_cv1_cv2" -> toSomeColumns(columns :+ ("day", "day")),
    "minutely_agg_prtn_entry_cv1_clst_cv2" -> toSomeColumns(columns :+ ("day", "day")),
    "minutely_agg_prtn_cv1_cv2_clst_entry" -> toSomeColumns(columns :+ ("day", "day"))

  )
}

object TenSecsAggregationByEntryCustomVar1CustomVar2 extends AggregationByEntryCustomVar1CustomVar2 with IAggregateTenSecs {
  override lazy val tableMetadata: Map[String, SomeColumns] = Map(
    "tensecs_agg_prtn_entry_cv1_cv2" -> toSomeColumns(columns :+ ("day", "day")),
    "tensecs_agg_prtn_entry_cv1_clst_cv2" -> toSomeColumns(columns :+ ("day", "day"))
  )
}
case class EntryCustomVar1CustomVar2Res(partnerId:Int, entryId: String, cv1:String, cv2:String, metric:String, year:Int, month: Int, day: Int, time:DateTime, value:Long)
