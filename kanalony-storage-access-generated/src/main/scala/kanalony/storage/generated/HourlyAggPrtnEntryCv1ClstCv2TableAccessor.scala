package kanalony.storage.generated
import com.websudos.phantom.dsl._
import com.websudos.phantom.builder.query._
import com.websudos.phantom.builder._
import shapeless.HNil
import scala.concurrent.Future

abstract class HourlyAggPrtnEntryCv1ClstCv2TableAccessor extends CassandraTable[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row] with RootConnector {

  object partner_id extends IntColumn(this)with PartitionKey[Int]
object entry_id extends StringColumn(this)with PartitionKey[String]
object custom_var1 extends StringColumn(this)with PartitionKey[String]
object year extends IntColumn(this)with PartitionKey[Int]
object metric extends StringColumn(this)with PartitionKey[String]
object hour extends DateTimeColumn(this)with ClusteringOrder[DateTime] with Descending
object custom_var2 extends StringColumn(this)with ClusteringOrder[String] with Ascending
object value extends LongColumn(this)


  override def tableName = "hourly_agg_prtn_entry_cv1_clst_cv2"

  def fromRow(row: Row): HourlyAggPrtnEntryCv1ClstCv2Row = {
    HourlyAggPrtnEntryCv1ClstCv2Row(
      partner_id(row), 
entry_id(row), 
custom_var1(row), 
year(row), 
metric(row), 
hour(row), 
custom_var2(row), 
value(row)
    )
  }

  def store(entity: HourlyAggPrtnEntryCv1ClstCv2Row): Future[ResultSet] = {
    insert.value(_.partner_id, entity.partnerId)
.value(_.entry_id, entity.entryId)
.value(_.custom_var1, entity.customVar1)
.value(_.year, entity.year)
.value(_.metric, entity.metric)
.value(_.hour, entity.hour)
.value(_.custom_var2, entity.customVar2)
.value(_.value, entity.value)

      .future()
  }

  def query(partnerId : Int, entryId : String, customVar1 : String, year : Int, metric : String) : SelectQuery[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var1 eqs customVar1)
.and(_.year eqs year)
.and(_.metric eqs metric)
  }
 def query(partnerId : Int, entryId : String, customVar1 : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var1 eqs customVar1)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerId : Int, entryId : String, customVar1 : String, year : Int, metric : String, hourStart : DateTime, hourEnd : DateTime, customVar2Start : String, customVar2End : String) : SelectQuery[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id eqs partnerId).and(_.entry_id eqs entryId)
.and(_.custom_var1 eqs customVar1)
.and(_.year eqs year)
.and(_.metric eqs metric)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.custom_var2 gte customVar2Start)
.and(_.custom_var2 lt customVar2End)
  }
def query(partnerIdList : List[Int], entryIdList : List[String], customVar1List : List[String], yearList : List[Int], metricList : List[String]) : SelectQuery[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var1 in customVar1List)
.and(_.year in yearList)
.and(_.metric in metricList)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], customVar1List : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime) : SelectQuery[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var1 in customVar1List)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
  }
 def query(partnerIdList : List[Int], entryIdList : List[String], customVar1List : List[String], yearList : List[Int], metricList : List[String], hourStart : DateTime, hourEnd : DateTime, customVar2Start : String, customVar2End : String) : SelectQuery[HourlyAggPrtnEntryCv1ClstCv2TableAccessor, HourlyAggPrtnEntryCv1ClstCv2Row, Unlimited, Unordered, Unspecified, Chainned, HNil] = {
    select.where(_.partner_id in partnerIdList).and(_.entry_id in entryIdList)
.and(_.custom_var1 in customVar1List)
.and(_.year in yearList)
.and(_.metric in metricList)
.and(_.hour gte hourStart)
.and(_.hour lt hourEnd)
.and(_.custom_var2 gte customVar2Start)
.and(_.custom_var2 lt customVar2End)
  }

}