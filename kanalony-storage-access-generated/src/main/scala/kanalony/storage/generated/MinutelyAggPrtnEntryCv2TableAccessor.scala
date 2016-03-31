package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class MinutelyAggPrtnEntryCv2TableAccessor extends CassandraTable[MinutelyAggPrtnEntryCv2TableAccessor, MinutelyAggPrtnEntryCv2Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object custom_var2 extends StringColumn(this)with PartitionKey[String]
object metric extends StringColumn(this)with PartitionKey[String]
object day extends IntColumn(this)with PartitionKey[Int]
object minute extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object value extends LongColumn(this)


  override def tableName = "minutely_agg_prtn_entry_cv2"

  def fromRow(row: Row): MinutelyAggPrtnEntryCv2Row = {
    MinutelyAggPrtnEntryCv2Row(
      partner_id(row), 
entry_id(row), 
custom_var2(row), 
metric(row), 
day(row), 
minute(row), 
value(row)
    )
  }

  def store(entity: MinutelyAggPrtnEntryCv2Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.custom_var2, entity.customVar2)
.value(_.metric, entity.metric)
.value(_.day, entity.day)
.value(_.minute, entity.minute)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, customVar2 : String, metric : String, day : Int) : SelectQuery[MinutelyAggPrtnEntryCv2TableAccessor, MinutelyAggPrtnEntryCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var2 eqs customVar2)
.and(_.metric eqs metric)
.and(_.day eqs day)
  }
 def query(partnerId : Int, entryId : String, customVar2 : String, metric : String, day : Int, minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[MinutelyAggPrtnEntryCv2TableAccessor, MinutelyAggPrtnEntryCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var2 eqs customVar2)
.and(_.metric eqs metric)
.and(_.day eqs day)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], customVar2List : List[String], metricList : List[String], dayList : List[Int]) : SelectQuery[MinutelyAggPrtnEntryCv2TableAccessor, MinutelyAggPrtnEntryCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var2 in customVar2List)
.and(_.metric in metricList)
.and(_.day in dayList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], customVar2List : List[String], metricList : List[String], dayList : List[Int], minuteStart : DateTime, minuteEnd : DateTime) : SelectQuery[MinutelyAggPrtnEntryCv2TableAccessor, MinutelyAggPrtnEntryCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var2 in customVar2List)
.and(_.metric in metricList)
.and(_.day in dayList)
.and(_.minute gte minuteStart)
.and(_.minute lt minuteEnd)
  }

}