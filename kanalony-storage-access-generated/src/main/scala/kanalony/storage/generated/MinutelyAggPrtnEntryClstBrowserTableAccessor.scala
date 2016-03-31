package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class MinutelyAggPrtnEntryClstBrowserTableAccessor extends CassandraTable[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object metric extends StringColumn(this)with PartitionKey[String]
object day extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object browser extends IntColumn(this)with ClusteringOrder[Int] with Ascending
object value extends LongColumn(this)


  override def tableName = "minutely_agg_prtn_entry_clst_browser"

  def fromRow(row: Row): MinutelyAggPrtnEntryClstBrowserRow = {
    MinutelyAggPrtnEntryClstBrowserRow(
      partner_id(row), 
entry_id(row), 
metric(row), 
day(row), 
minute(row), 
browser(row), 
value(row)
    )
  }

  def store(entity: MinutelyAggPrtnEntryClstBrowserRow): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.metric, entity.metric)
.value(_.day, entity.day)
.value(_.minute, entity.minute)
.value(_.browser, entity.browser)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, metric : String, day : Int) : SelectQuery[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.metric eqs metric)
.and(_.day eqs day)
  }
 def query(partnerId : Int, entryId : String, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partnerId : Int, entryId : String, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime, browserStart : Int, browserEnd : Int) : SelectQuery[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], metricList : List[String], dayList : List[Int]) : SelectQuery[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.metric in metricList)
.and(_.day in dayList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.metric in metricList)
.and(_.day in dayList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime, browserStart : Int, browserEnd : Int) : SelectQuery[MinutelyAggPrtnEntryClstBrowserTableAccessor, MinutelyAggPrtnEntryClstBrowserRow, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.metric in metricList)
.and(_.day in dayList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
.and(_.browser gte browserStart)
.and(_.browser lt browserEnd)
  }

}